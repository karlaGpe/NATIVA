package com.example.diceroller


// Catálogo de canciones-----------------------------------------------------------

fun main() {
    // Crea una instancia de la clase Song con título, artista, año y número de reproducciones
    val brunoSong = Song("We Don't Talk About Bruno", "Encanto Cast", 2022, 1_000_000)

    // Llama al método printDescription() para imprimir una descripción de la canción
    brunoSong.printDescription()

    // Imprime si la canción es popular (true o false) según el número de reproducciones
    println(brunoSong.isPopular)
}

// Definición de la clase Song
class Song(
    val title: String,         // Título de la canción
    val artist: String,        // Artista que la interpreta
    val yearPublished: Int,    // Año de publicación
    val playCount: Int         // Número de veces que se ha reproducido
) {
    // Propiedad calculada: devuelve true si las reproducciones son 1000 o más
    val isPopular: Boolean
        get() = playCount >= 1000

    // Método que imprime una descripción de la canción
    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}
