package com.example.lab2.Shapes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.lab2.Shapes.Interfaces.ILineShape
import com.example.lab2.Shapes.Interfaces.IRectangleShape

class CubeShape : Shape("Куб"), IRectangleShape, ILineShape {

  private val cubePaint: Paint = Paint().apply {
    color = Color.BLACK
    style = Paint.Style.STROKE
    strokeWidth = 8f
  }

  override fun draw(canvas: Canvas, isDrawing: Boolean) {
    val width = endX - startX
    val offset = width / 4

    drawCoordLine(canvas, startX, startY, startX + offset, startY - offset, isDrawing) // Left vertical
    drawCoordLine(canvas, endX, startY, endX + offset, startY - offset, isDrawing) // Right vertical
    drawCoordLine(canvas, startX, endY, startX + offset, endY - offset, isDrawing) // Bottom left vertical
    drawCoordLine(canvas, endX, endY, endX + offset, endY - offset, isDrawing) // Bottom right vertical

    drawRectangleBase(canvas, startX + offset, startY - offset, endX + offset, endY - offset, cubePaint, isDrawing)
    drawRectangleBase(canvas, startX, startY, endX, endY, cubePaint, isDrawing)
  }
}
