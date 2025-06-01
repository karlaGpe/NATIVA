package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonFlip: Button = findViewById(R.id.buttonFlip)
        val textViewResult: TextView = findViewById(R.id.textViewResult)

        buttonFlip.setOnClickListener {
            val resultado = if (Random.nextBoolean()) "Cara" else "Cruz"
            textViewResult.text = "Resultado: $resultado"
        }
    }
}





