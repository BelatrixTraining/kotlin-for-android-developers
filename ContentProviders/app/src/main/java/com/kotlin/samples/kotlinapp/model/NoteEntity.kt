package com.kotlin.samples.kotlinapp.model

import java.io.Serializable

/**
 * @author : Eduardo Medina
 * @since : 11/13/18
 * @see : https://developer.android.com/index.html
 */
data class NoteEntity(val id:Int?,val name:String?,
                      val description:String?,val path:String?):Serializable {

    override fun toString(): String {
        return "NoteEntity(id=$id, name='$name', description='$description', path='$path')"
    }
}