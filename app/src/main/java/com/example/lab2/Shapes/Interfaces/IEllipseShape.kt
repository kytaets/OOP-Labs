package com.example.lab2.Shapes.Interfaces

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

interface IEllipseShape {
  fun drawCircle(canvas: Canvas, centerX: Float, centerY: Float, radius: Float, circleColor: Int) {
    val finalRadius = if (centerX == 0f) 0f else radius

    val basicCirclePaint: Paint = Paint().apply {
      color = Color.BLACK
      style = Paint.Style.STROKE
      strokeWidth = 5f
    }

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

    canvas.drawOval(
      centerX - finalRadius, centerY - finalRadius,
      centerX + finalRadius, centerY + finalRadius,
      basicCirclePaint
    )
  }

}