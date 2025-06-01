package com.example.diceroller  // Se mantiene el mismo paquete

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

        val num1EditText: EditText = findViewById(R.id.num1_input)
        val num2EditText: EditText = findViewById(R.id.num2_input)
        val num3EditText: EditText = findViewById(R.id.num3_input)
        val findButton: Button = findViewById(R.id.find_button)
        val resultTextView: TextView = findViewById(R.id.result_text)

        findButton.setOnClickListener {
            val num1 = num1EditText.text.toString().toDoubleOrNull()
            val num2 = num2EditText.text.toString().toDoubleOrNull()
            val num3 = num3EditText.text.toString().toDoubleOrNull()

            if (num1 == null || num2 == null || num3 == null) {
                Toast.makeText(this, "Por favor, ingresa números válidos", Toast.LENGTH_SHORT).show()
            } else {
                val mayor = maxOf(num1, num2, num3)
                resultTextView.text = "El mayor número es: $mayor"
            }
        }
    }
}





