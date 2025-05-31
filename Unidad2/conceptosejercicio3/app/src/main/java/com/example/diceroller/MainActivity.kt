package com.example.diceroller

// Conversor de temperatura-----------------------------------------------------------

fun main() {
    // Convierte 27 grados Celsius a Fahrenheit usando la fórmula dada
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }

    // Convierte 350 grados Kelvin a Celsius usando la fórmula dada
    printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }

    // Convierte 10 grados Fahrenheit a Kelvin usando la fórmula dada
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }
}

// Función que recibe la temperatura inicial, las unidades y una función para convertir la temperatura
fun printFinalTemperature(
    initialMeasurement: Double,                   // Temperatura inicial (número decimal)
    initialUnit: String,                          // Unidad de la temperatura inicial (ej. Celsius)
    finalUnit: String,                            // Unidad a la que se quiere convertir (ej. Fahrenheit)
    conversionFormula: (Double) -> Double        // Función que recibe la temperatura inicial y devuelve la convertida
) {
    // Aplica la fórmula de conversión y formatea el resultado a 2 decimales
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement))

    // Imprime el resultado en formato legible
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
