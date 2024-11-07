package com.example.lab2.Shapes

import android.graphics.Canvas
import com.example.lab2.Shapes.Interfaces.ILineShape

open class LineShape : Shape(), ILineShape {

    override fun draw(canvas: Canvas, isDrawing: Boolean) {
        drawCoordLine(canvas, startX, startY, endX, endY, isDrawing)
    }

}
