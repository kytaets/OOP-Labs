package com.example.lab2

import android.graphics.Canvas
import android.graphics.Paint

abstract class Shape {

    protected val paint: Paint = Paint()

    var startX:  Float = 0f
    var startY:  Float = 0f
    var endX:  Float = 0f
    var endY: Float = 0f

    protected var isDrawing: Boolean = false

    init {
        paint.strokeWidth = 8f
    }

    open fun setCoordinates(startX: Float, startY: Float, endX: Float, endY: Float) {
        this.startX = startX
        this.startY = startY
        this.endX = endX
        this.endY = endY
    }

    abstract fun draw(canvas: Canvas, isDrawing: Boolean)
}
