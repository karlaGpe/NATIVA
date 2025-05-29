// PROBLEMA PROPUESTO 160
/* Agregar a la clase String un método imprimir que muestre todos los caracteres que tiene almacenado en una línea. */

// Se declara una función de extensión para la clase String llamada 'imprimir'
fun String.imprimir() {
    // La palabra 'this' se refiere a la cadena sobre la cual se llama el método
    // Simplemente imprime la cadena completa en una línea
    println(this)
}

// Función principal del programa
fun main(args: Array<String>) {
    // Se llama al método imprimir directamente sobre un literal de texto
    "Hola Mundo".imprimir()

    // Se declara una variable de tipo String
    val cadena1 = "Fin"

    // Se llama al método imprimir utilizando la variable
    cadena1.imprimir()
}
