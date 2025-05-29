// PROBLEMA PROPUESTO 161
/* Codificar la función de extensión llamada "hasta" que debe extender la clase Int y tiene por objetivo
   mostrar desde el valor entero que almacena el objeto hasta el valor que llega como parámetro. */

// Declaramos la función de extensión 'hasta' para la clase Int.
// 'this' representa el número entero desde donde se comenzará a contar.
fun Int.hasta(fin: Int) {
    // Utilizamos un bucle for para recorrer desde el número actual (this) hasta el valor final (fin)
    for(valor in this..fin)
    // Imprime cada número seguido de un guion
        print("$valor-")
    // Hace un salto de línea después de imprimir toda la secuencia
    println()
}

// Función principal del programa
fun main(args: Array<String>) {
    // Se crea una variable 'v' con valor 10
    val v = 10
    // Se llama al método de extensión 'hasta' desde la variable 'v', mostrando del 10 al 100
    v.hasta(100)

    // También se puede llamar directamente desde un literal entero
    // Muestra del 5 al 10
    5.hasta(10)
}
