package com.example.lab2

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class SegmentShape : Shape(), IEllipseShape, ILineShape {

  private val segmentPaint: Paint = Paint().apply {
    color = Color.BLACK
    style = Paint.Style.STROKE
    strokeWidth = 8f
  }

  override fun draw(canvas: Canvas, isDrawing: Boolean) {
    paint.color = segmentPaint.color
    drawCoordLine(canvas, startX, startY, endX, endY, isDrawing)

    val radius = 20f

    drawCircle(canvas, startX, startY, radius, Color.GRAY)
    drawCircle(canvas, endX, endY, radius, Color.GRAY )
  }
}

