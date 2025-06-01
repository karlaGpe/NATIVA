package com.example.diceroller

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var timeDisplay: TextView
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeDisplay = findViewById(R.id.timeDisplay)

        // Actualizar la hora cada segundo
        val runnable = object : Runnable {
            override fun run() {
                updateClock()
                handler.postDelayed(this, 1000) // 1000ms = 1 segundo
            }
        }

        handler.post(runnable)
    }

    // Actualizar el TextView con la hora actual
    private fun updateClock() {
        val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        timeDisplay.text = currentTime
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null) // Detener el Handler cuando la actividad se destruya
    }
}





