package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val minEditText: EditText = findViewById(R.id.min_number)
        val maxEditText: EditText = findViewById(R.id.max_number)
        val generateButton: Button = findViewById(R.id.generate_button)
        val resultTextView: TextView = findViewById(R.id.result_text)

        generateButton.setOnClickListener {
            val min = minEditText.text.toString().toIntOrNull()
            val max = maxEditText.text.toString().toIntOrNull()

            if (min == null || max == null || min > max) {
                Toast.makeText(this, "Ingresa un rango válido", Toast.LENGTH_SHORT).show()
            } else {
                val randomNumber = (min..max).random()
                resultTextView.text = "Número generado: $randomNumber"
            }
        }
    }
}





