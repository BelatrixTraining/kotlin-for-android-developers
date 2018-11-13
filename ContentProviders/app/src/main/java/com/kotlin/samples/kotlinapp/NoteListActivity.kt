package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.AdapterView
import com.kotlin.samples.kotlinapp.extensions.toast
import com.kotlin.samples.kotlinapp.model.NoteEntity
import com.kotlin.samples.kotlinapp.storage.DbInjector
import com.kotlin.samples.kotlinapp.ui.NoteAdapter
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    private val noteOperations= DbInjector.db()
    private var notes:List<NoteEntity>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        listView.onItemClickListener= AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val noteEntity= adapterView?.adapter?.getItem(i)

            Log.v("CONSOLE", "item $noteEntity")
            toast("item : $noteEntity")
        }
    }

    override fun onResume() {
        super.onResume()
        loadNotes()
    }

    private fun loadNotes(){
        notes= noteOperations?.getAllNotes()
        notes?.forEach {
            Log.v("CONSOLE","it $it")
        }
        listView.adapter= NoteAdapter(this,notes?: emptyList())
    }
}
