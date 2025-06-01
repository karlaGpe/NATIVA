package com.example.diceroller

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerAnimals: Spinner
    private lateinit var textViewSound: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerAnimals = findViewById(R.id.spinnerAnimals)
        textViewSound = findViewById(R.id.textViewSound)

        val animals = listOf("Perro", "Gato", "Vaca", "Oveja", "Pato")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, animals)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAnimals.adapter = adapter

        val buttonShowSound: Button = findViewById(R.id.buttonShowSound)

        buttonShowSound.setOnClickListener {
            val selectedAnimal = spinnerAnimals.selectedItem.toString()
            val sound = getAnimalSound(selectedAnimal)
            textViewSound.text = sound
        }
    }

    private fun getAnimalSound(animal: String): String {
        return when (animal) {
            "Perro" -> "Guau"
            "Gato" -> "Miau"
            "Vaca" -> "Muuu"
            "Oveja" -> "Beee"
            "Pato" -> "Cuac"
            else -> "Sonido no disponible"
        }
    }
}





