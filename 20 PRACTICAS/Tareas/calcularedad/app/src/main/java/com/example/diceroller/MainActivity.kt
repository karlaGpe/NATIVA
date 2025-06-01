package com.example.diceroller

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var editTextDOB: EditText
    private lateinit var textViewAge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextDOB = findViewById(R.id.editTextDOB)
        textViewAge = findViewById(R.id.textViewAge)

        val buttonCalculateAge: Button = findViewById(R.id.buttonCalculateAge)

        buttonCalculateAge.setOnClickListener {
            val dobText = editTextDOB.text.toString()

            // Verificar que el campo no esté vacío
            if (TextUtils.isEmpty(dobText)) {
                Toast.makeText(this, "Por favor ingresa tu fecha de nacimiento", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Intentar analizar la fecha de nacimiento
            try {
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val dob = sdf.parse(dobText)
                val age = calculateAge(dob)
                textViewAge.text = "Tu edad es: $age años"
            } catch (e: Exception) {
                Toast.makeText(this, "Formato de fecha inválido. Usa (YYYY-MM-DD).", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Función para calcular la edad
    private fun calculateAge(dob: Date): Int {
        val calendar = Calendar.getInstance()
        val today = calendar.time
        calendar.time = dob

        var age = today.year - dob.year
        if (today.month < dob.month || (today.month == dob.month && today.date < dob.date)) {
            age--
        }

        return age
    }
}





