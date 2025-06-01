package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputText: EditText = findViewById(R.id.input_text)
        val countButton: Button = findViewById(R.id.count_button)
        val resultTextView: TextView = findViewById(R.id.result_text)

        countButton.setOnClickListener {
            val text = inputText.text.toString().trim()
            val wordCount = if (text.isEmpty()) 0 else text.split("\\s+".toRegex()).size
            resultTextView.text = "Palabras: $wordCount"
        }
    }
}





