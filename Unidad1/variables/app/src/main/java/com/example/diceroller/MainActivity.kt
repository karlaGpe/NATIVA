package com.example.diceroller

/*
 * This program displays the number of messages
 * in the user's inbox.
 */
// Función principal: punto de entrada del programa
fun main() {
    // Crea una variable mutable llamada 'count' y le asigna el valor 10
    // Representa la cantidad de mensajes no leídos
    var count = 10

    // Imprime el mensaje actual con la cantidad de mensajes no leídos
    println("You have $count unread messages.")

    // Disminuye el valor de 'count' en 1 (equivalente a count = count - 1)
    count--

    // Imprime nuevamente el mensaje, ahora con un mensaje menos
    println("You have $count unread messages.")
}
