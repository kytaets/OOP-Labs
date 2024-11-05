package com.example.lab2

import android.graphics.Canvas

open class LineShape : Shape(), ILineShape {

    override fun draw(canvas: Canvas, isDrawing: Boolean) {
        drawCoordLine(canvas, startX, startY, endX, endY, isDrawing)
    }

}
