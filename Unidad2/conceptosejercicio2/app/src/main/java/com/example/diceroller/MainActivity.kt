package com.example.diceroller

//Precio de las entradas de cine-----------------------------------------------------------


fun main() {
    val child = 5               // Edad de un niño
    val adult = 28              // Edad de un adulto
    val senior = 87             // Edad de una persona mayor

    val isMonday = true         // Indica si hoy es lunes (true = sí)

    // Imprime el precio de la entrada para el niño
    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    // Imprime el precio de la entrada para el adulto
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    // Imprime el precio de la entrada para la persona mayor
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

// Función que calcula el precio de la entrada según la edad y si es lunes
fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when(age) {
        in 0..12 -> 15                      // Niños (0 a 12 años) pagan 15
        in 13..60 -> if (isMonday) 25 else 30  // Adultos (13 a 60): 25 si es lunes, sino 30
        in 61..100 -> 20                    // Personas mayores (61 a 100) pagan 20
        else -> -1                         // Edad inválida o no considerada, retorna -1
    }
}
