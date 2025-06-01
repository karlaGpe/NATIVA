package com.example.diceroller  // Mantiene el mismo paquete

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import kotlin.math.PI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radiusEditText: EditText = findViewById(R.id.radius_input)
        val calculateButton: Button = findViewById(R.id.calculate_button)
        val resultTextView: TextView = findViewById(R.id.result_text)

        calculateButton.setOnClickListener {
            val radius = radiusEditText.text.toString().toDoubleOrNull()

            if (radius == null || radius <= 0) {
                Toast.makeText(this, "Por favor, ingresa un radio válido", Toast.LENGTH_SHORT).show()
            } else {
                // Calcular área del círculo
                val area = PI * radius * radius
                resultTextView.text = "El área del círculo es: %.2f".format(area)
            }
        }
    }
}



