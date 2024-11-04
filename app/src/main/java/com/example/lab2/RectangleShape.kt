package com.example.lab2

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint

open class RectangleShape : Shape() {

    override fun draw(canvas: Canvas, isDrawing: Boolean) {
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK

        if (isDrawing) {
            paint.pathEffect = DashPathEffect(floatArrayOf(20f, 10f), 0f)
        } else {
            paint.pathEffect = null
        }

        canvas.drawRect(startX, startY, endX, endY, paint)

    }

}
