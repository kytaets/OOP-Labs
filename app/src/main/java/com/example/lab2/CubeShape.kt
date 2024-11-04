package com.example.lab2

import android.graphics.Canvas

class CubeShape : RectangleShape() {

  private val lineShape = LineShape()

  override fun draw(canvas: Canvas, isDrawing: Boolean) {
    drawCube(canvas, isDrawing)
  }

  private fun drawCube(canvas: Canvas, isDrawing: Boolean) {
    val width = endX - startX

    val offset = width / 4
    lineShape.drawCoordLine(canvas, startX + offset, startY - offset, endX + offset, startY - offset, isDrawing)
    lineShape.drawCoordLine(canvas, startX + offset, startY - offset, startX + offset, endY - offset, isDrawing)
    lineShape.drawCoordLine(canvas, endX + offset, startY - offset, endX + offset, endY - offset, isDrawing)
    lineShape.drawCoordLine(canvas, startX + offset, endY - offset, endX + offset, endY - offset, isDrawing)

    lineShape.drawCoordLine(canvas, startX, startY, startX + offset, startY - offset, isDrawing)
    lineShape.drawCoordLine(canvas, endX, startY, endX + offset, startY - offset, isDrawing)
    lineShape.drawCoordLine(canvas, startX, endY, startX + offset, endY - offset, isDrawing)
    lineShape.drawCoordLine(canvas, endX, endY, endX + offset, endY - offset, isDrawing)
    super.draw(canvas, isDrawing)

  }
}