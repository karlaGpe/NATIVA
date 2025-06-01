package com.example.diceroller

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private var segundos = 0
    private var corriendo = false
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tiempoTextView: TextView = findViewById(R.id.tiempo_text)
        val iniciarButton: Button = findViewById(R.id.iniciar_button)
        val pausarButton: Button = findViewById(R.id.pausar_button)
        val reiniciarButton: Button = findViewById(R.id.reiniciar_button)

        iniciarButton.setOnClickListener {
            corriendo = true
            actualizarTiempo(tiempoTextView)
        }

        pausarButton.setOnClickListener {
            corriendo = false
        }

        reiniciarButton.setOnClickListener {
            corriendo = false
            segundos = 0
            tiempoTextView.text = "Tiempo: 0s"
        }
    }

    private fun actualizarTiempo(tiempoTextView: TextView) {
        handler.post(object : Runnable {
            override fun run() {
                if (corriendo) {
                    segundos++
                    tiempoTextView.text = "Tiempo: ${segundos}s"
                }
                handler.postDelayed(this, 1000)
            }
        })
    }
}






