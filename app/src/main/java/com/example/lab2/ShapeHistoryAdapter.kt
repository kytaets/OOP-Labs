package com.example.lab2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.lab2.Shapes.Shape

class ShapeHistoryAdapter(
  private val context: Context,
  private val shapes: List<Shape>
) : BaseAdapter() {

  override fun getCount(): Int = shapes.size

  override fun getItem(position: Int): Any = shapes[position]

  override fun getItemId(position: Int): Long = position.toLong()

  override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
    val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)

    val shapeName = view.findViewById<TextView>(R.id.shapeName)
    val x1 = view.findViewById<TextView>(R.id.x1)
    val y1 = view.findViewById<TextView>(R.id.y1)
    val x2 = view.findViewById<TextView>(R.id.x2)
    val y2 = view.findViewById<TextView>(R.id.y2)

    val shape = shapes[position]

    shapeName.text = shape.name

    x1.text = shape.startX.toString()
    y1.text = shape.startY.toString()
    x2.text = shape.endX.toString()
    y2.text = shape.endY.toString()

    return view
  }
}

