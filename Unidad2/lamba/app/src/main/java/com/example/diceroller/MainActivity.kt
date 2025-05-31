package com.example.diceroller

fun trickOrTreat(isTrick: Boolean, treatMessage: ((Int) -> String)?): () -> Unit {
    return if (isTrick) {
        {
            println("No treats!")
        }
    } else {
        {
            // Imprime el mensaje "5 quarters" solo una vez
            if (!hasPrintedMessage) {
                treatMessage?.let {
                    println(it(5))  // Imprime el mensaje de la función treatMessage con el valor 5
                }
                hasPrintedMessage = true  // Marcar que ya se imprimió el mensaje
            }
            println("Have a treat!")
        }
    }
}

var hasPrintedMessage = false  // Variable global para asegurarnos que "5 quarters" se imprima solo una vez.

fun main() {
    // Se define treatFunction con la lambda para obtener un trato (mensaje de cuartos)
    val treatFunction = trickOrTreat(false) { "$it quarters" }

    // Se define trickFunction sin un mensaje (sin trato)
    val trickFunction = trickOrTreat(true, null)

    // Llamada a treatFunction para imprimir "5 quarters" solo una vez
    treatFunction()

    // Llamada a treatFunction 4 veces para imprimir "Have a treat!" 4 veces
    repeat(4) {
        treatFunction()  // Llama a treatFunction en cada iteración
    }

    // Llamada a trickFunction una vez, mostrando el mensaje de no hay trato
    trickFunction()
}
