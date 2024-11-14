package com.example.lab2.Shapes

import android.graphics.Canvas
import com.example.lab2.Shapes.Interfaces.IRectangleShape

open class RectangleShape : Shape("Прямокутник"), IRectangleShape {

    override fun draw(canvas: Canvas, isDrawing: Boolean) {
        drawRectangleBase(canvas, startX, startY, endX, endY, paint, isDrawing)
    }

}
