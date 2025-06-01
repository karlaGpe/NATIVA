package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var textViewGreeting: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        textViewGreeting = findViewById(R.id.textViewGreeting)

        val buttonGreet: Button = findViewById(R.id.buttonGreet)

        buttonGreet.setOnClickListener {
            // Obtener el nombre ingresado por el usuario
            val name = editTextName.text.toString()

            // Si el campo no está vacío, mostrar el saludo
            if (name.isNotEmpty()) {
                val greetingMessage = "¡Hola, $name!"
                textViewGreeting.text = greetingMessage
            } else {
                // Si no se ingresó un nombre, mostrar un mensaje predeterminado
                textViewGreeting.text = "¡Hola, Usuario!"
            }
        }
    }
}





