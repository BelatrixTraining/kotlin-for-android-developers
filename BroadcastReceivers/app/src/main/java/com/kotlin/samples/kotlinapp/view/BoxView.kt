package com.kotlin.samples.kotlinapp.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View


/**
 * @author : Eduardo Medina
 * @since : 11/13/18
 * @see : https://developer.android.com/index.html
 */
class BoxView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){

    companion object {
        private const val BOX_WIDTH = 800f//width
        private const val BOX_HEIGHT = 800f
    }

    private val paint:Paint= Paint()

    private var xo = 0f
    private var yo = 0f
    private var stroke = 1f
    private var delay = 0

    fun updateView(level: Int) {
        val percent = level / 100.0
        delay = BOX_HEIGHT.toInt() - Math.round(BOX_HEIGHT * percent).toInt()
        Log.v("CONSOLE", "level $level percent $percent delay $delay")
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.apply {
            color= Color.BLACK
            strokeWidth= stroke
        }
        canvas?.drawRect(xo,yo, BOX_WIDTH, BOX_HEIGHT,paint)

        paint.apply {
            color= Color.CYAN
            strokeWidth= 0f
        }
        canvas?.drawRect(xo+stroke, yo+stroke, BOX_WIDTH-stroke, BOX_HEIGHT-stroke, paint)

        paint.apply {
            color= Color.YELLOW
        }
        canvas?.drawRect(xo+stroke, yo+stroke+delay, BOX_WIDTH-stroke, BOX_HEIGHT-stroke, paint)

    }
}