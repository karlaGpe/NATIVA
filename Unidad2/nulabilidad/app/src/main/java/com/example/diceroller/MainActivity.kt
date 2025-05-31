package com.example.diceroller

fun main() {
    // Variable nullable (puede ser null) que guarda el nombre de un actor favorito
    var favoriteActor: String? = "Sandra Oh"

    // Usa el operador seguro de acceso ?. y el operador Elvis ?:
    // Si favoriteActor no es null, obtiene la longitud del nombre
    // Si es null, devuelve 0
    val lengthOfName = favoriteActor?.length ?: 0

    // Imprime cuántos caracteres tiene el nombre del actor favorito
    println("The number of characters in your favorite actor's name is $lengthOfName.")
}
