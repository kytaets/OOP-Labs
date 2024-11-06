package com.example.lab2

import android.graphics.Canvas
import android.graphics.Paint

interface IEllipseShape {
  fun drawCircle(canvas: Canvas, centerX: Float, centerY: Float, radius: Float, circleColor: Int) {
    val final_radius = if (centerX == 0f) 0f else radius

    val circlePaint: Paint = Paint().apply {
      color = circleColor
      style = Paint.Style.FILL
      strokeWidth = 8f
    }

    canvas.drawOval(
      centerX - final_radius, centerY - final_radius,
      centerX + final_radius, centerY + final_radius,
      circlePaint
    )
  }

}