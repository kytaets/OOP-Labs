package com.example.lab2

import android.graphics.Canvas
import android.graphics.Paint

interface IEllipseShape {
  fun drawCircle(canvas: Canvas, centerX: Float, centerY: Float, radius: Float, paint: Paint) {
    val final_radius = if (centerX == 0f) 0f else radius

    paint.style = Paint.Style.FILL
    canvas.drawOval(
      centerX - final_radius, centerY - final_radius,
      centerX + final_radius, centerY + final_radius,
      paint
    )
  }

}