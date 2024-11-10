package com.example.lab2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.graphics.Color
import android.widget.Toast


class MainActivity : AppCompatActivity() {

  lateinit var filesBtn: Button
  lateinit var objectsBtn: Button
  lateinit var infoBtn: Button
  lateinit var filesList: ListView
  lateinit var editorView: Editor

  lateinit var dotBtn: Button
  lateinit var lineBtn: Button
  lateinit var rectBtn: Button
  lateinit var ellipseBtn: Button
  lateinit var cubeBtn: Button
  lateinit var segmentBtn: Button
  private var selectedButton: Button? = null

  lateinit var objectName: String

  lateinit var prevShapeBtn: Button
  lateinit var nextShapeBtn: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    filesBtn = findViewById(R.id.filesButton)
    objectsBtn = findViewById(R.id.objectsButton)
    infoBtn = findViewById(R.id.infoButton)
    filesList = findViewById(R.id.filesList)
    editorView = findViewById(R.id.editorView)

    dotBtn = findViewById(R.id.dot_btn)
    lineBtn = findViewById(R.id.line_btn)
    rectBtn = findViewById(R.id.rect_btn)
    ellipseBtn = findViewById(R.id.ellipse_btn)
    cubeBtn = findViewById(R.id.cube_btn)
    segmentBtn = findViewById(R.id.segment_btn)


    val objectList = resources.getStringArray(R.array.objects)
    val customAdapter = CustomAdapter(this, objectList)
    val buttons = listOf(dotBtn, lineBtn, rectBtn, ellipseBtn, cubeBtn, segmentBtn)

    filesList.adapter = customAdapter

    objectsBtn.setOnClickListener {
      editorView.visibility = View.GONE
      filesList.visibility = View.VISIBLE
    }

    filesList.setOnItemClickListener { parent, _, position, _ ->
      objectName = parent.getItemAtPosition(position).toString()

      customAdapter.setSelectedPosition(position)

      filesList.visibility = View.GONE
      editorView.visibility = View.VISIBLE

      selectedButton?.setBackgroundColor(Color.parseColor("#6B89FF"))
      selectedButton = buttons.find { it.text == objectName }
      selectedButton?.setBackgroundColor(Color.parseColor("#5067BF"))

      editorView.setCurrentShape(objectName)
    }


    for (button in buttons) {
      button.setOnClickListener {
        selectedButton?.setBackgroundColor(Color.parseColor("#6B89FF"))
        button.setBackgroundColor(Color.parseColor("#5067BF"))

        selectedButton = button
        editorView.setCurrentShape(button.text.toString())

        customAdapter.setSelectedPosition(buttons.indexOf(selectedButton))
      }

      button.setOnLongClickListener {
        Toast.makeText(this, "${button.text}", Toast.LENGTH_SHORT).show()
        true
      }
    }

    prevShapeBtn = findViewById(R.id.prevShapeBtn)
    nextShapeBtn = findViewById(R.id.nextShapeBtn)

    prevShapeBtn.setOnClickListener {
      editorView.setShapeIndex(-1)

    }

    nextShapeBtn.setOnClickListener {
      editorView.setShapeIndex(+1)

    }

  }


}
