package com.example.diceroller

// Función principal: punto de entrada del programa
fun main() {
    // Llamada a la función para imprimir el clima de Ankara
    printWeatherForCity("Ankara", 27, 31, 82)
    // Llamada a la función para imprimir el clima de Tokyo
    printWeatherForCity("Tokyo", 32, 36, 10)
    // Llamada a la función para imprimir el clima de Ciudad del Cabo
    printWeatherForCity("Cape Town", 59, 64, 2)
    // Llamada a la función para imprimir el clima de Ciudad de Guatemala
    printWeatherForCity("Guatemala City", 50, 55, 7)
}

// Función que imprime la información del clima para una ciudad
// Parámetros:
// - cityName: nombre de la ciudad
// - lowTemp: temperatura mínima
// - highTemp: temperatura máxima
// - chanceOfRain: probabilidad de lluvia en porcentaje
fun printWeatherForCity(cityName: String, lowTemp: Int, highTemp: Int, chanceOfRain: Int) {
    // Imprime el nombre de la ciudad
    println("City: $cityName")
    // Imprime las temperaturas mínima y máxima
    println("Low temperature: $lowTemp, High temperature: $highTemp")
    // Imprime la probabilidad de lluvia
    println("Chance of rain: $chanceOfRain%")
    // Imprime una línea en blanco para separar la salida de cada ciudad
    println()
}
