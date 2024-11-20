package com.example.lab2.adapters

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class FileOptionsAdapter(context: Context) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1) {

  // Визначаємо масив варіантів безпосередньо в адаптері
  private val fileOptions = arrayOf("Зберегти файл", "Завантажити файл")

  init {
    // Додаємо елементи в адаптер
    addAll(*fileOptions)
  }

  override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
    val view = super.getView(position, convertView, parent)

    // Кастомізація вигляду елементів ListView, якщо потрібно
    val textView = view.findViewById<TextView>(android.R.id.text1)
    textView.textSize = 18f
    textView.setTextColor(Color.BLACK)

    return view
  }
}

