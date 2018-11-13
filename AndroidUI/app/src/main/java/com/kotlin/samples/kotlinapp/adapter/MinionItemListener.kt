package com.kotlin.samples.kotlinapp.adapter

import com.kotlin.samples.kotlinapp.model.Minion

/**
 * @author : Eduardo Medina
 * @since : 11/13/18
 * @see : https://developer.android.com/index.html
 */
interface MinionItemListener {

    fun onSelectedItem(minion:Minion?)
}