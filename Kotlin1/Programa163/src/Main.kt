class Vector1 {
    val arreglo = IntArray(5) // Crea un arreglo de 5 enteros

    // Llena el arreglo con números aleatorios entre 1 y 11
    fun cargar() {
        for (i in arreglo.indices)
            arreglo[i] = (Math.random() * 11 + 1).toInt()
    }

    // Imprime los elementos del arreglo
    fun imprimir() {
        for (elemento in arreglo)
            print("$elemento ")
        println()
    }

    // Operador "times" para multiplicar cada elemento del vector por un valor
    operator fun times(valor: Int): Vector1 {
        val resultado = Vector1() // Crea un nuevo vector para almacenar el resultado
        for (i in arreglo.indices)
            resultado.arreglo[i] = arreglo[i] * valor
        return resultado
    }
}

fun main(args: Array<String>) {
    val vec1 = Vector1()
    vec1.cargar() // Llena el vector con valores aleatorios
    println("Vector original:")
    vec1.imprimir() // Imprime el vector original

    println("El producto de un vector con el número 10 es:")
    val vecProductoEnt = vec1 * 10 // Multiplica cada elemento por 10
    vecProductoEnt.imprimir() // Imprime el vector resultante
}
