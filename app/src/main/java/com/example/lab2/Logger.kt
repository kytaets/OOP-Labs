package com.example.lab2

import android.content.Context
import com.example.lab2.Shapes.Shape
import java.io.File
import java.io.FileWriter
import java.io.IOException

class Logger (context: Context){

  private val file: File = File(context.filesDir, "shapes_log.txt")

  init {
    // Очистимо файл при створенні нового сеансу
    try {
      file.writeText("") // Очищення файлу при старті
    } catch (e: IOException) {
      e.printStackTrace()
    }
  }

  fun logShape(shapeType: String, shape: Shape) {
    try {
      FileWriter(file, true).use { writer ->
        val logEntry = "${shapeType}: (${shape.startX}, ${shape.startY}) -> (${shape.endX}, ${shape.endY})\n"
        writer.append(logEntry)
      }
    } catch (e: IOException) {
      e.printStackTrace()
    }
  }

}