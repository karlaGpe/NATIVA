// Clase Vector4 que maneja un arreglo de enteros
class Vector4 {
    // Arreglo de enteros de tamaño 5, inicializado con los valores 0, 1, 2, 3, 4
    val arreglo = IntArray(5, { it })

    // Método para imprimir los elementos del arreglo
    fun imprimir() {
        // Recorre el arreglo e imprime cada elemento
        for (elemento in arreglo)
            print("$elemento ")
        println() // Salto de línea al final de la impresión
    }

    // Sobrecarga del operador +=, que realiza la suma componente a componente
    // y actualiza el primer vector (vec1) con los valores sumados
    operator fun plusAssign(vec2: Vector4) {
        // Suma los elementos de vec2.arreglo a los elementos de arreglo (vec1)
        for (i in arreglo.indices)
            arreglo[i] += vec2.arreglo[i]
    }
}

// Función main que crea y maneja objetos de la clase Vector4
fun main(args: Array<String>) {
    // Creación del primer vector (vec1)
    val vec1 = Vector4()
    println("Valores de vec1 antes de la suma:")
    vec1.imprimir() // Imprime los valores iniciales de vec1

    // Creación del segundo vector (vec2)
    val vec2 = Vector4()
    println("Valores de vec2:")
    vec2.imprimir() // Imprime los valores de vec2

    // Realiza la suma componente a componente de vec2 a vec1 utilizando el operador +=
    vec1 += vec2

    // Imprime los valores de vec1 después de la suma
    println("Valores de vec1 después de la suma con vec2:")
    vec1.imprimir()
}
