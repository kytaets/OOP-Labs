package com.example.lab2.adapters

import com.example.lab2.Shapes.CubeShape
import com.example.lab2.Shapes.DotShape
import com.example.lab2.Shapes.EllipseShape
import com.example.lab2.Shapes.LineShape
import com.example.lab2.Shapes.RectangleShape
import com.example.lab2.Shapes.SegmentShape
import com.example.lab2.Shapes.Shape

class ShapeSerializer {
  // Серіалізація фігури в рядок
  fun serialize(shape: Shape): String {
    return "${shape.name}: (${shape.startX}, ${shape.startY}) -> (${shape.endX}, ${shape.endY})"
  }

  // Десеріалізація рядка у фігуру
  fun deserialize(data: String): Shape {
    val parts = data.split(": ")
    val name = parts[0]
    val coordinates = parts[1].split(" -> ")

    val startCoordinates = coordinates[0].removePrefix("(").removeSuffix(")").split(", ")
    val startX = startCoordinates[0].toFloat()
    val startY = startCoordinates[1].toFloat()

    val endCoordinates = coordinates[1].removePrefix("(").removeSuffix(")").split(", ")
    val endX = endCoordinates[0].toFloat()
    val endY = endCoordinates[1].toFloat()

    val shape = when (name) {
      "Прямокутник" -> RectangleShape()
      "Еліпс" -> EllipseShape()
      "Лінія" -> LineShape()
      "Крапка" -> DotShape()
      "Куб" -> CubeShape()
      "Відрізок" -> SegmentShape()
      else -> throw IllegalArgumentException("Unknown shape type: $name")
    }

    shape.setCoordinates(startX, startY, endX, endY)
    return shape
  }
}