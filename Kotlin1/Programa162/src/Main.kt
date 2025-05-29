class Vector0 {
    val arreglo = IntArray(5) // Arreglo de 5 enteros

    // Llena el vector con valores aleatorios entre 1 y 11
    fun cargar() {
        for (i in arreglo.indices)
            arreglo[i] = (Math.random() * 11 + 1).toInt()
    }

    // Imprime los valores del vector en una línea
    fun imprimir() {
        for (elemento in arreglo)
            print("$elemento ")
        println()
    }

    // Suma componente a componente
    operator fun plus(vector2: Vector0): Vector0 {
        val suma = Vector0()
        for (i in arreglo.indices)
            suma.arreglo[i] = arreglo[i] + vector2.arreglo[i]
        return suma
    }

    // Resta componente a componente
    operator fun minus(vector2: Vector0): Vector0 {
        val resta = Vector0()
        for (i in arreglo.indices)
            resta.arreglo[i] = arreglo[i] - vector2.arreglo[i]
        return resta
    }

    // Multiplicación componente a componente
    operator fun times(vector2: Vector0): Vector0 {
        val producto = Vector0()
        for (i in arreglo.indices)
            producto.arreglo[i] = arreglo[i] * vector2.arreglo[i]
        return producto
    }

    // División componente a componente con validación de división por cero
    operator fun div(vector2: Vector0): Vector0 {
        val division = Vector0()
        for (i in arreglo.indices) {
            division.arreglo[i] = if (vector2.arreglo[i] != 0)
                arreglo[i] / vector2.arreglo[i]
            else
                0 // Valor por defecto si hay división por cero
        }
        return division
    }

    // Función adicional para mostrar estadísticas del vector
    fun mostrarEstadisticas(nombre: String) {
        val max = arreglo.maxOrNull() ?: 0
        val min = arreglo.minOrNull() ?: 0
        val promedio = arreglo.average()
        println("Estadísticas del $nombre:")
        println("  Máximo: $max")
        println("  Mínimo: $min")
        println("  Promedio: $promedio")
        println()
    }
}

// Función principal
fun main(args: Array<String>) {
    val vec1 = Vector0()
    val vec2 = Vector0()

    vec1.cargar()
    vec2.cargar()

    println("Vector 1:")
    vec1.imprimir()
    println("Vector 2:")
    vec2.imprimir()

    val vecSuma = vec1 + vec2
    println("\nSuma componente a componente:")
    vecSuma.imprimir()

    val vecResta = vec1 - vec2
    println("Resta componente a componente:")
    vecResta.imprimir()

    val vecProducto = vec1 * vec2
    println("Producto componente a componente:")
    vecProducto.imprimir()

    val vecDivision = vec1 / vec2
    println("División componente a componente (con control de división por 0):")
    vecDivision.imprimir()

    // Mostrar estadísticas
    println("\n--- Estadísticas ---")
    vec1.mostrarEstadisticas("Vector 1")
    vec2.mostrarEstadisticas("Vector 2")
}
