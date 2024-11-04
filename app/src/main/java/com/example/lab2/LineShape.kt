package com.example.lab2

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.DashPathEffect


open class LineShape : Shape() {

    override fun draw(canvas: Canvas, isDrawing: Boolean) {
        drawCoordLine(canvas, startX, startY, endX, endY, isDrawing)
    }

    fun drawCoordLine(canvas: Canvas, startX: Float, startY: Float, endX: Float, endY: Float, isDrawing: Boolean) {
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK

        paint.pathEffect = when (isDrawing) {
            true -> DashPathEffect(floatArrayOf(20f, 10f), 0f)
            false -> null
        }
        canvas.drawLine(startX, startY, endX, endY, paint)
    }
}
