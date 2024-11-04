package com.example.lab2

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint

interface IRectangleShape {
  fun drawBase(canvas: Canvas, startX: Float, startY: Float, endX: Float, endY: Float,paint: Paint, isDrawing: Boolean) {
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