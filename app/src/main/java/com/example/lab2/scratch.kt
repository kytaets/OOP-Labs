//package com.example.lab2
//
//import android.os.Bundle
//import android.view.View
//import android.widget.ArrayAdapter
//import android.widget.Button
//import android.widget.ListView
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//
//class MainActivity : AppCompatActivity() {
//
//    lateinit var filesBtn : Button
//    lateinit var objectsBtn : Button
//    lateinit var infoBtn : Button
//    lateinit var filesList : ListView
//    lateinit var editorView: Editor
//
//    lateinit var objectName : String
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//        filesBtn = findViewById(R.id.filesButton)
//        objectsBtn = findViewById(R.id.objectsButton)
//        infoBtn = findViewById(R.id.infoButton)
//        filesList = findViewById(R.id.filesList)
//        editorView = findViewById(R.id.editorView)
//
//        // list part
//        val countryList = resources.getStringArray(R.array.countries)
//        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countryList)
//        filesList.adapter = arrayAdapter
//
//
//        objectsBtn.setOnClickListener {
//            editorView.visibility = View.GONE
//            filesList.visibility = View.VISIBLE
//        }
//
//        filesList.setOnItemClickListener { parent, _, position, _ ->
//            objectName = parent.getItemAtPosition(position).toString()
//
//            // Після вибору показуємо Canvas і ховаємо список
//            filesList.visibility = View.GONE
//            editorView.visibility = View.VISIBLE
//
//            // Логіка для малювання вибраної фігури в Editor
//            editorView.setCurrentShape(objectName)
//        }
//    }
//}