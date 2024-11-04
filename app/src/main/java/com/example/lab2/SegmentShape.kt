package com.example.lab2

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint


class SegmentShape : LineShape() {
  private val ellipseShape = EllipseShape()
  private val RADIUS = 20f

  override fun draw(canvas: Canvas, isDrawing: Boolean) {

    super.draw(canvas, isDrawing)

    val circlePaint = Paint().apply {
      color = Color.RED
      style = Paint.Style.FILL
    }

    ellipseShape.drawSimpleCircle(canvas, startX, startY, RADIUS, circlePaint)
    ellipseShape.drawSimpleCircle(canvas, endX, endY, RADIUS, circlePaint)
  }
}