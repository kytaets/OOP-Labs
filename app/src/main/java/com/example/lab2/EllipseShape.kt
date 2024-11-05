package com.example.lab2

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint

class EllipseShape : Shape() {

    override fun draw(canvas: Canvas, isDrawing: Boolean) {
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK

        if (isDrawing) {
            paint.pathEffect = DashPathEffect(floatArrayOf(20f, 10f), 0f)
            canvas.drawOval(startX, startY, endX, endY, paint)
        } else {
            paint.pathEffect = null
            canvas.drawOval(startX, startY, endX, endY, paint)

            paint.style = Paint.Style.FILL
            paint.color = Color.GRAY
            canvas.drawOval(startX, startY, endX, endY, paint)
        }
    }
}
