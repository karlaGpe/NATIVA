package com.example.diceroller

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextAmount: EditText
    private lateinit var editTextTipPercentage: EditText
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextAmount = findViewById(R.id.editTextAmount)
        editTextTipPercentage = findViewById(R.id.editTextTipPercentage)
        textViewResult = findViewById(R.id.textViewResult)

        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            // Obtener los valores ingresados
            val amountText = editTextAmount.text.toString()
            val tipPercentageText = editTextTipPercentage.text.toString()

            // Verificar que los campos no estén vacíos
            if (amountText.isNotEmpty() && tipPercentageText.isNotEmpty()) {
                // Convertir los valores a números
                val amount = amountText.toDouble()
                val tipPercentage = tipPercentageText.toDouble()

                // Calcular la propina
                val tipAmount = (tipPercentage / 100) * amount
                val totalAmount = amount + tipAmount

                // Mostrar el resultado
                textViewResult.text = "Propina: \$${"%.2f".format(tipAmount)}\nTotal con propina: \$${"%.2f".format(totalAmount)}"
            } else {
                textViewResult.text = "Por favor ingresa todos los datos"
            }
        }
    }
}





