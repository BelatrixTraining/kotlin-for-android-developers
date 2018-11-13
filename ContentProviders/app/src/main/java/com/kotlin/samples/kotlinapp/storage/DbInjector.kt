package com.kotlin.samples.kotlinapp.storage

import android.content.Context


/**
 * @author : Eduardo Medina
 * @since : 11/13/18
 * @see : https://developer.android.com/index.html
 */
object DbInjector {

    private var crudOperations: NoteOperations? = null

    fun setup(context: Context) {
        crudOperations = NoteOperations(context,NoteDbHelper(context))
    }

    fun db(): NoteOperations? {
        return crudOperations
    }
}