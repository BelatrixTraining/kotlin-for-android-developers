package com.kotlin.samples.kotlinapp.storage

import android.net.Uri
import android.provider.BaseColumns



/**
 * @author : Eduardo Medina
 * @since : 11/13/18
 * @see : https://developer.android.com/index.html
 */
class NoteContract {

    companion object {
        const val CONTENT_AUTHORITY = "com.kotlin.samples.kotlinapp.storage.NoteProvider"//"<packageName>.myContentProvider";
        //BASE_CONTENT_URI : content://com.kotlin.samples.kotlinapp.storage.NoteProvider
        val BASE_CONTENT_URI = Uri.parse("content://$CONTENT_AUTHORITY")
        //Path to get CLIENT APP to our table
        const val PATH_NOTES = "tb_notes"
    }

    class NoteEntry : BaseColumns {
        companion object {

            val CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_NOTES)

            //Table Name
            const val TABLE_NAME = "tb_notes"

            //Columns
            const val  ID = "id"//BaseColumns._ID;
            const val COLUMN_NAME = "name"
            const val COLUMN_DESC = "desc"
            const val COLUMN_PATH = "path"
        }
    }
}