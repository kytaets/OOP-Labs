package com.example.lab2.Shapes.Interfaces

import android.graphics.Canvas
import android.graphics.Paint

interface IEllipseShape {
  fun drawCircle(canvas: Canvas, centerX: Float, centerY: Float, radius: Float, circleColor: Int) {
    val finalRadius = if (centerX == 0f) 0f else radius

    val circlePaint: Paint = Paint().apply {
      color = circleColor
      style = Paint.Style.FILL
      strokeWidth = 8f
    }

    canvas.drawOval(
      centerX - finalRadius, centerY - finalRadius,
      centerX + finalRadius, centerY + finalRadius,
      circlePaint
    )
  }

}