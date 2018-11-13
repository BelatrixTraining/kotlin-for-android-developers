package com.kotlin.samples.kotlinapp.storage

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import android.util.Log


/**
 * @author : Eduardo Medina
 * @since : 11/13/18
 * @see : https://developer.android.com/index.html
 */
class NoteProvider: ContentProvider() {

    private lateinit var noteDbHelper:NoteDbHelper

    companion object {
        private const val TAG="CONSOLE"
        //constants for the operation
        private const val NOTES = 1
        private const val NOTES_ID = 2
        private const val NOTES_NOTE_NAME = 3

        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)

        // static{}
        init {
            //notes
            //notes/{id}
            //notes/{name}
            uriMatcher.addURI(NoteContract.CONTENT_AUTHORITY,NoteContract.PATH_NOTES,NOTES)//1);
            uriMatcher.addURI(NoteContract.CONTENT_AUTHORITY,NoteContract.PATH_NOTES+"/#",NOTES_ID)//3);
            uriMatcher.addURI(NoteContract.CONTENT_AUTHORITY,NoteContract.PATH_NOTES+"/*",NOTES_NOTE_NAME)//2);
        }

    }

    override fun onCreate(): Boolean {
        noteDbHelper= NoteDbHelper(context)
        return true
    }

    override fun insert(uri: Uri?, values: ContentValues?): Uri? {
        when (uriMatcher.match(uri)) {
            NOTES -> return insertRecord(uri, values, NoteContract.NoteEntry.TABLE_NAME)
            else -> throw IllegalArgumentException("Error uri $uri")
        }
    }

    override fun query(uri: Uri?, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor {
        val database = noteDbHelper.readableDatabase
        val cursor: Cursor
        cursor = when (uriMatcher.match(uri)) {
            NOTES -> database.query(NoteContract.NoteEntry.TABLE_NAME, projection,
                    selection, selectionArgs, null, null, sortOrder)
            NOTES_ID -> database.query(NoteContract.NoteEntry.TABLE_NAME, projection,
                    selection, selectionArgs, null, null, sortOrder)
            else -> throw IllegalArgumentException("Error uri $uri")
        }
        return cursor
    }


    override fun update(uri: Uri?, values: ContentValues?, selection: String?, selectionArgs: Array<String>?): Int {
        when (uriMatcher.match(uri)) {
            NOTES// For Notes Table
            -> return updateRecord(values, selection, selectionArgs, NoteContract.NoteEntry.TABLE_NAME)
            else -> throw IllegalArgumentException(TAG + "Unknown URI: " + uri)
        }
    }

    override fun delete(uri: Uri?, selection: String?, selectionArgs: Array<String>?): Int {
        when (uriMatcher.match(uri)) {
            NOTES_ID // To delete a row by ID
            -> {
                val nSelection = NoteContract.NoteEntry.ID.plus(" = ?")
                val nSelectionArgs = arrayOf(ContentUris.parseId(uri).toString())
                return deleteRecord(nSelection, nSelectionArgs, NoteContract.NoteEntry.TABLE_NAME)
            }
            else -> throw IllegalArgumentException(TAG + "Unknown URI: " + uri)
        }
    }

    override fun getType(uri: Uri?): String? {
        return null
    }

    //implementation
    private fun insertRecord(uri: Uri?, values: ContentValues?, tableName: String): Uri? {
        val database = noteDbHelper.writableDatabase
        val rowId = database.insert(NoteContract.NoteEntry.TABLE_NAME, null, values)
        if (rowId < 0) {
            Log.v(TAG, "Insert error for Uri $uri")
            return null
        }
        return ContentUris.withAppendedId(uri, rowId)
    }

    private fun deleteRecord(selection: String, selectionArgs: Array<String>, tableName: String): Int {
        val database = noteDbHelper.writableDatabase
        return database.delete(tableName, selection, selectionArgs)
    }

    private fun updateRecord(values: ContentValues?, selection: String?, selectionArgs: Array<String>?, tableName: String): Int {
        val database = noteDbHelper.writableDatabase
        return database.update(tableName, values, selection, selectionArgs)
    }
}