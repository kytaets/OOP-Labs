package com.example.lab2.Shapes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class DotShape : Shape() {

  override fun draw(canvas: Canvas, isDrawing: Boolean) {
    if (!isDrawing) {
      val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.FILL
      }
      canvas.drawCircle(startX, startY, 10f, paint)
    }
  }
}