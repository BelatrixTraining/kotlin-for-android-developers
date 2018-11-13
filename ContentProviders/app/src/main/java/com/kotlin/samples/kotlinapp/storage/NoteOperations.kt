package com.kotlin.samples.kotlinapp.storage

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.kotlin.samples.kotlinapp.model.NoteEntity


/**
 * @author : Eduardo Medina
 * @since : 11/13/18
 * @see : https://developer.android.com/index.html
 */
class NoteOperations(val context: Context,val noteDbHelper: NoteDbHelper) {

    fun getAllNotes(): List<NoteEntity> {
        val lst = mutableListOf<NoteEntity>()
        val uri = NoteContract.NoteEntry.CONTENT_URI
        val projection = arrayOf(NoteContract.NoteEntry.ID, NoteContract.NoteEntry.COLUMN_NAME, NoteContract.NoteEntry.COLUMN_DESC, NoteContract.NoteEntry.COLUMN_PATH)

        val selection: String? = null
        val selectionArg: Array<String>? = null
        val sortOrden: String? = null
        val cursor = context.contentResolver.query(uri, projection, selection,
                selectionArg, sortOrden)

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val id= Integer.parseInt(cursor?.getString(0))
                val name = cursor?.getString(1)
                val desc= cursor?.getString(2)
                val path= cursor?.getString(3)
                val contact = NoteEntity(id,name,desc,path)
                lst.add(contact)
            } while (cursor?.moveToNext())
            cursor?.close()
        }
        return lst.toList()
    }

    fun insert( noteEntity: NoteEntity) {
        val contentValues = ContentValues()
        contentValues.put(NoteContract.NoteEntry.COLUMN_NAME, noteEntity.name)
        contentValues.put(NoteContract.NoteEntry.COLUMN_DESC, noteEntity.description)
        contentValues.put(NoteContract.NoteEntry.COLUMN_PATH, noteEntity.path)

        val uri = NoteContract.NoteEntry.CONTENT_URI
        val uriRowInserted = context.contentResolver.insert(uri, contentValues)

        Log.v("CONSOLE", "Item inserted ar $uriRowInserted")
    }
}