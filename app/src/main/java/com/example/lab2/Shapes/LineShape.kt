package com.example.lab2.Shapes

import android.graphics.Canvas
import com.example.lab2.Shapes.Interfaces.ILineShape

open class LineShape : Shape("Лінія"), ILineShape {

    override fun draw(canvas: Canvas, isHighlighted: Boolean, isDrawing: Boolean) {
        val paint = getPaint(isHighlighted)
        drawCoordLine(canvas, startX, startY, endX, endY, paint, isDrawing)
    }

}
