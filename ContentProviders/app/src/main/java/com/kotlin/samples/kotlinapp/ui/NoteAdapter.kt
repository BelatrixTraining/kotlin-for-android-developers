package com.kotlin.samples.kotlinapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.model.NoteEntity



/**
 * @author : Eduardo Medina
 * @since : 11/13/18
 * @see : https://developer.android.com/index.html
 */
class NoteAdapter (val context: Context,
                   private val notes:List<NoteEntity>):BaseAdapter(){

    private val mInflater: LayoutInflater=LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val vh: RowHolder
        if (convertView == null) {
            view = mInflater.inflate(R.layout.row_note, parent, false)
            vh = RowHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as RowHolder
        }
        vh.label.text = notes[position].name
        return view
    }

    override fun getItem(i: Int): Any {
        return notes[i]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return notes.size
    }

    private class RowHolder(row: View?) {
        val label: TextView = row?.findViewById(R.id.tviName) as TextView
    }

}