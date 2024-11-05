package com.example.lab2

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class CubeShape : Shape(), IRectangleShape, ILineShape {

  private val cubePaint: Paint = Paint().apply {
    color = Color.BLACK
    style = Paint.Style.STROKE
    strokeWidth = 8f
  }

  override fun draw(canvas: Canvas, isDrawing: Boolean) {
    // Use the current coordinates of the shape to determine width and height
    val width = endX - startX
    val offset = width / 4

    // Draw top edges of the cube
    drawCoordLine(canvas, startX + offset, startY - offset, endX + offset, startY - offset, isDrawing) // Top edge
    drawCoordLine(canvas, startX + offset, startY - offset, startX + offset, endY - offset, isDrawing) // Left top edge
    drawCoordLine(canvas, endX + offset, startY - offset, endX + offset, endY - offset, isDrawing) // Right top edge
    drawCoordLine(canvas, startX + offset, endY - offset, endX + offset, endY - offset, isDrawing) // Bottom edge

    // Draw vertical lines connecting top and bottom
    drawCoordLine(canvas, startX, startY, startX + offset, startY - offset, isDrawing) // Left vertical
    drawCoordLine(canvas, endX, startY, endX + offset, startY - offset, isDrawing) // Right vertical
    drawCoordLine(canvas, startX, endY, startX + offset, endY - offset, isDrawing) // Bottom left vertical
    drawCoordLine(canvas, endX, endY, endX + offset, endY - offset, isDrawing) // Bottom right vertical

    // Draw the base of the cube
    drawRectangleBase(canvas, startX, startY, endX, endY, cubePaint, isDrawing)
  }
}
