package com.kotlin.samples.kotlinapp.data

import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.model.Minion

/**
 * @author : Eduardo Medina
 * @since : 11/13/18
 * @see : https://developer.android.com/index.html
 */
object MinionData {

    fun getMinions():List<Minion>{
        val minions= mutableListOf<Minion>()
        minions.add(Minion("Luis", R.drawable.ic_minion01))
        minions.add(Minion("Luis 2", R.drawable.ic_minion02))
        minions.add(Minion("Luis 3", R.drawable.ic_minion03))
        minions.add(Minion("Luis 4", R.drawable.ic_minion04))
        minions.add(Minion("Luis 5", R.drawable.ic_minion05))
        minions.add(Minion("Luis 6", R.drawable.ic_minion06))
        minions.add(Minion("Luis 7", R.drawable.ic_minion07))

        return minions.toList()
    }
}