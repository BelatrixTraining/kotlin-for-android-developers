package com.kotlin.samples.kotlinapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.model.Minion

/**
 * @author : Eduardo Medina
 * @since : 11/13/18
 * @see : https://developer.android.com/index.html
 */
class MinionAdapter(val minions:List<Minion>,val mListener:MinionItemListener?):RecyclerView.Adapter<MinionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent?.context)
                .inflate(R.layout.row_minion,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return minions.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name= minions[position].name
        val image=minions[position].image?:0
        holder?.textView?.text=name
        holder?.imageView.setImageResource(image)

        holder?.imageView.setOnClickListener {
            mListener?.onSelectedItem(minions[position])
        }
    }

    class ViewHolder(item:View):RecyclerView.ViewHolder(item){
        val imageView= item.findViewById<ImageView>(R.id.imageView)
        val textView= item.findViewById<TextView>(R.id.textView)
    }
}