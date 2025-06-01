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
        val countButton: Button = findViewById(R.id.count_button)

        countButton.setOnClickListener {
            count++
            countText.text = count.toString()
        }
    }
}





