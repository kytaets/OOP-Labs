package com.example.lab2

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.widget.ListView
import com.example.lab2.adapters.ShapeHistoryAdapter

class ShapeHistoryDialog (private val context: Context){

  fun showHistoryDialog() {
    val dialogView = View.inflate(context, R.layout.history_list, null)
    val listView = dialogView.findViewById<ListView>(R.id.listView)

    val adapter = ShapeHistoryAdapter(context, (context as MainActivity).editorView.shapes)
    listView.adapter = adapter

    AlertDialog.Builder(context)
      .setView(dialogView)
      .setTitle("Історія фігур")
      .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
      .show()
  }

}