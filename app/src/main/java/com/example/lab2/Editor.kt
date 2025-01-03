package com.example.lab2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.os.Environment
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.example.lab2.Shapes.CubeShape
import com.example.lab2.Shapes.DotShape
import com.example.lab2.Shapes.EllipseShape
import com.example.lab2.Shapes.LineShape
import com.example.lab2.Shapes.RectangleShape
import com.example.lab2.Shapes.SegmentShape
import com.example.lab2.Shapes.Shape
import com.example.lab2.adapters.ShapeSerializer
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

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
    private var currentShapeType: String = "Прямокутник"

    val shapes: MutableList<Shape> = mutableListOf()
    var shapesIndex: Int? = 0

    private val shapeLogger: Logger = Logger(context)

    var updateShapesCallback: ((List<Shape>) -> Unit)? = null


    // Shape interaction
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

    // History interaction
    fun highlightShape(index: Int) {
        shapes.forEachIndexed { i, shape ->
            shape.highlighted = (i == index)
        }
        invalidate()
    }

    fun addShape(shape: Shape) {
        shapes.add(shape)
        shapesIndex = shapes.size
        updateShapesCallback?.invoke(shapes)
        invalidate()
    }

    fun removeShapeAt(index: Int) {
        if (index in shapes.indices) {
            shapes.removeAt(index)
            shapesIndex = shapes.size
            updateShapesCallback?.invoke(shapes)
            invalidate()
        }
    }


    // File picker interaction
    fun saveShapesToDownloads(fileName: String) {
        try {
            val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val file = File(downloadsDir, fileName)
            val outputStream = FileOutputStream(file)
            outputStream.bufferedWriter().use { writer ->
                shapes.forEach { shape ->
                    val serializedShape = ShapeSerializer().serialize(shape)
                    writer.write("$serializedShape\n")
                }
            }
            Toast.makeText(context, "Файл збережено у 'Завантаження': ${file.absolutePath}", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Log.e("Editor", "Помилка збереження файлу в Завантаження", e)
            Toast.makeText(context, "Помилка збереження файлу.", Toast.LENGTH_SHORT).show()
        }
    }

    fun loadShapesFromFile(inputStream: InputStream) {
        val shapeSerializer = ShapeSerializer()

        try {
            inputStream.bufferedReader().use { reader ->
                val fileContent = reader.readText()
                shapes.clear()

                fileContent.lines().filter { it.isNotBlank() }.forEach { line ->
                    try {
                        val shape = shapeSerializer.deserialize(line)
                        shapes.add(shape)
                    } catch (e: Exception) {
                        Log.e("ShapeSerializer", "Error deserializing shape: $line", e)
                    }
                }

                shapesIndex = shapes.size
                updateShapesCallback?.invoke(shapes)
                invalidate()
            }
        } catch (e: Exception) {
            Log.e("Editor", "Error loading shapes from file", e)
            Toast.makeText(context, "Не вдалося завантажити файл. Перевірте його формат.", Toast.LENGTH_SHORT).show()
        }
    }


    // Basic functions
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val limit = shapesIndex?.coerceAtMost(shapes.size) ?: shapes.size

        for (i in 0 until limit) {
            val shape = shapes[i]
            shape.draw(canvas, shape.highlighted, false)
        }

        currentShape?.draw(canvas, false, true)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {

            MotionEvent.ACTION_DOWN -> {
                shapesIndex?.let { index ->
                    if (index < shapes.size) {
                        shapes.subList(index, shapes.size).clear()
                        updateShapesCallback?.invoke(shapes)
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
                    addShape(it)
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
