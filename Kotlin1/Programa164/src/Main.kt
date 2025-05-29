class Vector3 {
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

    // Sobrecarga del operador ++ (incrementa cada elemento del arreglo en 1)
    operator fun inc(): Vector3 {
        val incremento = Vector3() // Crea un nuevo vector para almacenar el resultado
        for (i in arreglo.indices)
            incremento.arreglo[i] = arreglo[i] + 1
        return incremento
    }

    // Sobrecarga del operador -- (decrementa cada elemento del arreglo en 1)
    operator fun dec(): Vector3 {
        val decremento = Vector3() // Crea un nuevo vector para almacenar el resultado
        for (i in arreglo.indices)
            decremento.arreglo[i] = arreglo[i] - 1
        return decremento
    }
}

fun main(args: Array<String>) {
    var vec1 = Vector3()
    vec1.cargar() // Llena el vector con valores aleatorios
    println("Vector original:")
    vec1.imprimir() // Imprime el vector original

    vec1 = vec1++ // Llama al operador ++ (incrementa cada elemento) y reasigna el valor a vec1
    println("Luego de llamar al operador ++:")
    vec1.imprimir() // Imprime el vector después del incremento

    vec1 = vec1-- // Llama al operador -- (decrementa cada elemento) y reasigna el valor a vec1
    println("Luego de llamar al operador --:")
    vec1.imprimir() // Imprime el vector después de la decrementación
}
