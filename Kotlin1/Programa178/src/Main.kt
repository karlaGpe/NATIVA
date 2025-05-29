// PROBLEMA PROPUESTO 178
/*
Crear una lista inmutable de 100 elementos enteros con valores aleatorios comprendidos entre 0 y 20.
Contar cuántos hay comprendidos entre:
- 1 y 4
- 5 y 8
- 10 y 13
Imprimir si el valor 20 está presente en la lista.
*/

fun main(args: Array<String>) {
    // Creamos una lista inmutable de 100 elementos con valores aleatorios entre 0 y 20
    val lista1 = List(100) { ((Math.random() * 21)).toInt() }

    // Imprimimos la lista generada
    println(lista1)

    // Inicializamos contadores
    var cant1 = 0 // Contador para valores entre 1 y 4
    var cant2 = 0 // Contador para valores entre 5 y 8
    var cant3 = 0 // Contador para valores entre 10 y 13

    // Recorremos la lista con un forEach y usamos un when para clasificar
    lista1.forEach {
        when(it) {
            in 1..4 -> cant1++
            in 5..8 -> cant2++
            in 10..13 -> cant3++
        }
    }

    // Mostramos los resultados de los conteos
    println("Cantidad de valores comprendidos entre 1..4: $cant1")
    println("Cantidad de valores comprendidos entre 5..8: $cant2")
    println("Cantidad de valores comprendidos entre 10..13: $cant3") // Aquí estaba el error

    // Verificamos si el valor 20 está presente en la lista
    if (lista1.contains(20))
        println("La lista contiene el 20")
    else
        println("La lista no contiene el 20")
}
