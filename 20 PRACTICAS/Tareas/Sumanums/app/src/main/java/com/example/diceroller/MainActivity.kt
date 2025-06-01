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

        val num1EditText: EditText = findViewById(R.id.num1)
        val num2EditText: EditText = findViewById(R.id.num2)
        val sumButton: Button = findViewById(R.id.sum_button)
        val resultTextView: TextView = findViewById(R.id.result_text)

        sumButton.setOnClickListener {
            val num1 = num1EditText.text.toString().toDoubleOrNull()
            val num2 = num2EditText.text.toString().toDoubleOrNull()

            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Ingresa dos números válidos", Toast.LENGTH_SHORT).show()
            } else {
                val sum = num1 + num2
                resultTextView.text = "Resultado: $sum"
            }
        }
    }
}





