fun main(args: Array<String>) {
    // Declaración de una lista inmutable de tipo String con los días de la semana
    var lista1: List<String> = listOf("lunes", "martes", "miércoles", "jueves",
        "viernes", "sábado", "domingo")

    // Imprimir la lista completa como una cadena
    println("Imprimir la lista completa")
    println(lista1)

    // Imprimir el primer elemento usando el índice
    println("Imprimir el primer elemento de la lista")
    println(lista1[0])

    // Imprimir el primer elemento usando el método 'first()'
    println("Imprimir el primer elemento de la lista")
    println(lista1.first())

    // Imprimir el último elemento usando el método 'last()'
    println("Imprimir el último elemento de la lista")
    println(lista1.last())

    // Imprimir el último elemento usando el índice
    println("Imprimir el último elemento de la lista")
    println(lista1[lista1.size - 1])

    // Imprimir la cantidad de elementos que contiene la lista
    println("Imprimir la cantidad de elementos de la lista")
    println(lista1.size)

    // Recorrer la lista con un for-each e imprimir cada elemento
    println("Recorrer la lista completa con un for")
    for(elemento in lista1)
        print("$elemento ")  // Imprime todos los días separados por espacio
    println()

    // Imprimir cada elemento junto con su posición usando índices
    println("Imprimir el elemento y su posición")
    for(posicion in lista1.indices)
        print("[$posicion]${lista1[posicion]} ")  // Ejemplo: [0]lunes [1]martes ...
}
