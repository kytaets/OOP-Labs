package com.example.lab2

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class SegmentShape : Shape(), IEllipseShape, ILineShape {

  private val segmentPaint: Paint = Paint().apply {  // Use a separate Paint instance
    color = Color.BLACK
    style = Paint.Style.STROKE
    strokeWidth = 8f
  }

  override fun draw(canvas: Canvas, isDrawing: Boolean) {
    paint.color = segmentPaint.color // Use the paint's color for the line
    drawCoordLine(canvas, startX, startY, endX, endY, isDrawing) // Draw the line

    val radius = 20f
    segmentPaint.color = if (isDrawing) Color.BLACK else Color.GRAY // Change color based on drawing state

    drawCircle(canvas, startX, startY, radius, segmentPaint) // Circle at the start
    drawCircle(canvas, endX, endY, radius, segmentPaint) // Circle at the end
  }
}

