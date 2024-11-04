package com.example.lab2

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class Editor @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var currentShape: Shape? = null
    private val shapes: MutableList<Shape> = mutableListOf()
    private var currentShapeType: String = "Прямокутник"

    fun setCurrentShape(shapeType: String) {
        currentShapeType = shapeType
        currentShape = when (shapeType) {
            "Прямокутник" -> RectangleShape()
            "Еліпс" -> EllipseShape()
            "Лінія" -> LineShape()
            "Крапка" -> DotShape()
            "Куб" -> CubeShape()
            "Відрізок" -> SegmentShape()
            else -> null
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for (shape in shapes) {
            shape.draw(canvas, false)
        }

        currentShape?.draw(canvas, true)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {

            MotionEvent.ACTION_DOWN -> {
                currentShape?.setCoordinates(event.x, event.y, event.x, event.y)
                invalidate()
            }

            MotionEvent.ACTION_MOVE -> {
                currentShape?.setCoordinates(currentShape?.startX ?: 0f, currentShape?.startY ?: 0f, event.x, event.y)
                invalidate()
            }

            MotionEvent.ACTION_UP -> {
                currentShape?.setCoordinates(currentShape?.startX ?: 0f, currentShape?.startY ?: 0f, event.x, event.y)
                currentShape?.let {
                    shapes.add(it)
                }
                setCurrentShape(currentShapeType)
                invalidate()
            }
        }
        return true
    }
}
