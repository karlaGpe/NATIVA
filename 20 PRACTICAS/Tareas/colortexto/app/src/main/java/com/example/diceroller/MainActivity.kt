package com.example.diceroller

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorTextView: TextView = findViewById(R.id.color_text)
        val changeColorButton: Button = findViewById(R.id.change_color_button)

        changeColorButton.setOnClickListener {
            // Cambia el color del texto a un color aleatorio
            colorTextView.setTextColor(Color.rgb((0..255).random(), (0..255).random(), (0..255).random()))
        }
    }
}





