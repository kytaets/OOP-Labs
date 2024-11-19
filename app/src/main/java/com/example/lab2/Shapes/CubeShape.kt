package com.example.lab2.Shapes

import android.graphics.Canvas
import com.example.lab2.Shapes.Interfaces.ILineShape
import com.example.lab2.Shapes.Interfaces.IRectangleShape

class CubeShape : Shape("Куб"), IRectangleShape, ILineShape {

  override fun draw(canvas: Canvas, isHighlighted: Boolean, isDrawing: Boolean) {
    val paint = getPaint(isHighlighted)
    val width = endX - startX
    val offset = width / 4

    drawCoordLine(canvas, startX, startY, startX + offset, startY - offset, paint, isDrawing) // Left vertical
    drawCoordLine(canvas, endX, startY, endX + offset, startY - offset, paint, isDrawing) // Right vertical
    drawCoordLine(canvas, startX, endY, startX + offset, endY - offset, paint, isDrawing) // Bottom left vertical
    drawCoordLine(canvas, endX, endY, endX + offset, endY - offset, paint, isDrawing) // Bottom right vertical

    drawRectangleBase(canvas, startX + offset, startY - offset, endX + offset, endY - offset, paint, isDrawing)
    drawRectangleBase(canvas, startX, startY, endX, endY, paint, isDrawing)
  }
}
