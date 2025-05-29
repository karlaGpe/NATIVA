// Función de extensión para la clase String que retorna la primera mitad de la cadena
fun String.mitadPrimera(): String {
    // Usamos substring desde el índice 0 hasta la mitad de la longitud menos 1
    // Si la longitud es impar, la mitad es un número entero (división entera)
    return this.substring(0..this.length / 2 - 1)
}

// Función de extensión para la clase String que retorna la segunda mitad de la cadena
fun String.segundaMitad(): String {
    // Usamos substring desde la mitad de la cadena hasta el final
    return this.substring(this.length / 2..this.length - 1)
}

// Función principal
fun main(args: Array<String>) {
    // Definimos una cadena
    val cadena1 = "Viento"

    // Imprimimos la primera mitad de la cadena
    println(cadena1.mitadPrimera())   // Salida: "Vie"

    // Imprimimos la segunda mitad de la cadena
    println(cadena1.segundaMitad())   // Salida: "nto"
}
