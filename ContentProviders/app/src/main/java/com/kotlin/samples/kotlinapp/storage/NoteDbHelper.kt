package com.kotlin.samples.kotlinapp.storage

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * @author : Eduardo Medina
 * @since : 11/13/18
 * @see : https://developer.android.com/index.html
 */
class NoteDbHelper(context: Context): SQLiteOpenHelper(context,"BDNote",null,1) {
    companion object {
        const val TABLE_NOTES = "tb_notes"

        const val KEY_ID = "id"
        const val KEY_NAME = "name"
        const val KEY_DESC = "desc"
        const val KEY_PATH = "path"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = ("CREATE TABLE " + TABLE_NOTES + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + KEY_NAME + " TEXT,"
                + KEY_DESC + " TEXT,"
                + KEY_PATH + " TEXT" + ")")
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF EXISTS $TABLE_NOTES"
        db?.execSQL(sql)
    }
}