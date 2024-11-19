package com.example.lab2

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.lab2.Shapes.CubeShape
import com.example.lab2.Shapes.DotShape
import com.example.lab2.Shapes.EllipseShape
import com.example.lab2.Shapes.LineShape
import com.example.lab2.Shapes.RectangleShape
import com.example.lab2.Shapes.SegmentShape
import com.example.lab2.Shapes.Shape

class Editor @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    companion object {
        @Volatile
        private var instance: Editor? = null

        fun init(editor: Editor): Editor {
            return instance ?: synchronized(this) {
                instance ?: editor.also { instance = it }
            }
        }

        fun getInstance(): Editor {
            return instance ?: throw IllegalStateException("Editor instance is not initialized. Call getInstance(editor) first.")
        }
    }

    private var currentShape: Shape? = null
    val shapes: MutableList<Shape> = mutableListOf()
    private var currentShapeType: String = "Прямокутник"
    var shapesIndex: Int? = 0

    private val shapeLogger: Logger = Logger(context)


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

    fun setShapeIndex(addIndex: Int) {
        shapesIndex = (shapesIndex ?: 0) + addIndex
        shapesIndex = shapesIndex?.coerceIn(0, shapes.size)
        invalidate()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val limit = shapesIndex?.coerceAtMost(shapes.size) ?: shapes.size

        for (i in 0 until limit) {
            shapes[i].draw(canvas, false)
        }

        currentShape?.draw(canvas, true)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {

            MotionEvent.ACTION_DOWN -> {
                shapesIndex?.let { index ->
                    if (index < shapes.size) {
                        shapes.subList(index, shapes.size).clear()
                    }
                }
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
                    shapesIndex = shapes.size

                    shapeLogger.logShape(currentShapeType, it)
                }
                setCurrentShape(currentShapeType)
                invalidate()
            }
        }
        return true
    }
}
