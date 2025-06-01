package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countText: TextView = findViewById(R.id.count_text)
        val addButton: Button = findViewById(R.id.add_button)
        val subtractButton: Button = findViewById(R.id.subtract_button)
        val resetButton: Button = findViewById(R.id.reset_button)

        addButton.setOnClickListener {
            count++
            countText.text = count.toString()
        }

        subtractButton.setOnClickListener {
            count--
            countText.text = count.toString()
        }

        resetButton.setOnClickListener {
            count = 0
            countText.text = count.toString()
        }
    }
}






