package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private var randomNumber = (1..10).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputField: EditText = findViewById(R.id.input_number)
        val checkButton: Button = findViewById(R.id.check_button)
        val resultText: TextView = findViewById(R.id.result_text)

        checkButton.setOnClickListener {
            val userGuess = inputField.text.toString().toIntOrNull()

            if (userGuess == null) {
                Toast.makeText(this, "Por favor ingresa un número", Toast.LENGTH_SHORT).show()
            } else if (userGuess == randomNumber) {
                resultText.text = "🎉 ¡Correcto! El número era $randomNumber"
                randomNumber = (1..10).random() // Genera un nuevo número para seguir jugando
            } else {
                resultText.text = "❌ Incorrecto, intenta otra vez."
            }
        }
    }
}





