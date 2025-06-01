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

        val numberEditText: EditText = findViewById(R.id.number_input)
        val checkButton: Button = findViewById(R.id.check_button)
        val resultTextView: TextView = findViewById(R.id.result_text)

        checkButton.setOnClickListener {
            val number = numberEditText.text.toString().toIntOrNull()

            if (number == null) {
                Toast.makeText(this, "Por favor, ingresa un número válido", Toast.LENGTH_SHORT).show()
            } else {
                val result = if (number % 2 == 0) "Par" else "Impar"
                resultTextView.text = "El número es: $result"
            }
        }
    }
}





