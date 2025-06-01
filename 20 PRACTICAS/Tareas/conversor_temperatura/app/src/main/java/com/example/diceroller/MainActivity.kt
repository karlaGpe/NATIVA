package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputTemp: EditText = findViewById(R.id.input_temp)
        val convertButton: Button = findViewById(R.id.convert_button)
        val radioGroup: RadioGroup = findViewById(R.id.radio_group)
        val resultText: TextView = findViewById(R.id.result_text)

        convertButton.setOnClickListener {
            val tempValue = inputTemp.text.toString().toDoubleOrNull()

            if (tempValue == null) {
                Toast.makeText(this, "Por favor ingresa un número válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "Selecciona una conversión", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = when (selectedId) {
                R.id.radio_celsius_to_fahrenheit -> (tempValue * 9 / 5) + 32
                R.id.radio_fahrenheit_to_celsius -> (tempValue - 32) * 5 / 9
                else -> 0.0
            }

            resultText.text = "Resultado: ${"%.2f".format(result)}°"
        }
    }
}






