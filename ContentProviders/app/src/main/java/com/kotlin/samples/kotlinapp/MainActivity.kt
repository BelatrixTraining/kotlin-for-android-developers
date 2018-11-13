package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.kotlin.samples.kotlinapp.model.NoteEntity
import com.kotlin.samples.kotlinapp.storage.DbInjector

class MainActivity : AppCompatActivity() {

    private val noteOperations= DbInjector.db()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //populate()
        loadNotes()
    }

    override fun onResume() {
        super.onResume()
        //loadNotes()
    }

    private fun populate(){
        noteOperations?.insert(
                NoteEntity(0,"First note","First note desc",""))

        noteOperations?.insert(
                NoteEntity(1,"Second Note","Second note desc",""))

        noteOperations?.insert(
                NoteEntity(2,"Third note","Third note desc",""))

        noteOperations?.insert(
                NoteEntity(3,"Fourth note","Fourthnote desc",""))
    }

    private fun loadNotes(){
        val notes= noteOperations?.getAllNotes()
        notes?.forEach {
            Log.v("CONSOLE","it $it")
        }
    }
}
