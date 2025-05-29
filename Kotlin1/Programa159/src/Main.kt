// Función de extensión para IntArray que imprime todos los elementos del arreglo con formato
fun IntArray.imprimir() {
    print("[") // Imprime el corchete de apertura
    for (elemento in this) { // Recorre cada elemento del arreglo
        print("$elemento ") // Imprime el elemento seguido de un espacio
    }
    println("]") // Imprime el corchete de cierre y un salto de línea
}

// Función principal
fun main(args: Array<String>) {
    // Se crea un arreglo de enteros (IntArray) de tamaño 10
    // Cada posición se inicializa con el índice correspondiente (it = índice)
    val arreglo1 = IntArray(10, { it })

    // Se llama al método de extensión imprimir() para mostrar el arreglo
    arreglo1.imprimir()
}
