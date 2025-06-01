package com.example.diceroller  // Mantiene el mismo paquete

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

        val grade1EditText: EditText = findViewById(R.id.grade1_input)
        val grade2EditText: EditText = findViewById(R.id.grade2_input)
        val grade3EditText: EditText = findViewById(R.id.grade3_input)
        val calculateButton: Button = findViewById(R.id.calculate_button)
        val resultTextView: TextView = findViewById(R.id.result_text)

        calculateButton.setOnClickListener {
            val grade1 = grade1EditText.text.toString().toDoubleOrNull()
            val grade2 = grade2EditText.text.toString().toDoubleOrNull()
            val grade3 = grade3EditText.text.toString().toDoubleOrNull()

            if (grade1 == null || grade2 == null || grade3 == null) {
                Toast.makeText(this, "Por favor, ingresa calificaciones válidas", Toast.LENGTH_SHORT).show()
            } else {
                val average = (grade1 + grade2 + grade3) / 3
                resultTextView.text = "El promedio es: $average"
            }
        }
    }
}






