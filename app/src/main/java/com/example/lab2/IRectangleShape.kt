package com.example.lab2

import android.graphics.Canvas

interface IRectangleShape {
  fun draw(canvas: Canvas, isDrawing: Boolean, startX: Float, startY: Float, endX: Float, endY: Float)
}