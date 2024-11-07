package com.example.lab2

import android.graphics.Canvas
import android.graphics.Color

class SegmentShape : Shape(), IEllipseShape, ILineShape {

  private val radius = 20f

  override fun draw(canvas: Canvas, isDrawing: Boolean) {
    drawCoordLine(canvas, startX, startY, endX, endY, isDrawing)

    drawCircle(canvas, startX, startY, radius, Color.GRAY)
    drawCircle(canvas, endX, endY, radius, Color.GRAY )
  }
}

