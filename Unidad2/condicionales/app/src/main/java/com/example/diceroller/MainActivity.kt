package com.example.diceroller
fun main() {
    // Variable que representa el color actual del semáforo
    val trafficLightColor = "Amber"

    // Se usa una expresión `when` para decidir qué mensaje mostrar según el color
    val message = when(trafficLightColor) {
        "Red" -> "Stop"                            // Si es "Red", el mensaje es "Stop"
        "Yellow", "Amber" -> "Proceed with caution." // Si es "Yellow" o "Amber", el mensaje es "Proceed with caution."
        "Green" -> "Go"                            // Si es "Green", el mensaje es "Go"
        else -> "Invalid traffic-light color"      // Si el color no coincide con ninguno, muestra un mensaje de error
    }

    // Imprime el mensaje correspondiente al color
    println(message)
}
