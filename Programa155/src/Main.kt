fun main(parametro: Array<String>) {
    // Crear un arreglo de 10 elementos de tipo Int
    val arreglo1 = IntArray(10)

    // Llenar el arreglo con números aleatorios del 0 al 99
    for (i in arreglo1.indices)
        arreglo1[i] = ((Math.random() * 100)).toInt()

    // Imprimir todos los elementos del arreglo
    println("Impresion de todo el arreglo")
    for (elemento in arreglo1)
        print("$elemento ")  // Imprime cada elemento seguido de un espacio
    println() // Salto de línea

    // Contar cuántos elementos son múltiplos de 3
    var cantidad = 0
    arreglo1.forEach {
        if (it % 3 == 0)
            cantidad++  // Si el número es divisible entre 3, incrementa el contador
    }
    println("La cantidad de elementos múltiplos de 3 son $cantidad")

    // Sumar los elementos mayores a 50
    var suma = 0
    arreglo1.forEach {
        if (it > 50)
            suma += it  // Si el número es mayor a 50, se suma al acumulador
    }
    println("La suma de todos los elementos mayores a 50 es $suma")
}
