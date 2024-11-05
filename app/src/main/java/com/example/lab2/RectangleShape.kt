package com.example.lab2

import android.graphics.Canvas

open class RectangleShape : Shape(), IRectangleShape {

    override fun draw(canvas: Canvas, isDrawing: Boolean) {
        drawRectangleBase(canvas, startX, startY, endX, endY, paint, isDrawing)
    }

}
