// PROBLEMA PROPUESTO 104
/*
Realizar un programa que pida la carga de dos arreglos numéricos enteros de 4 elementos.
Obtener la suma de los dos arreglos elemento a elemento, dicho resultado guardarlo en un tercer arreglo del mismo tamaño.
*/

fun main(parametro: Array<String>) {
    // Declaración de dos arreglos de 4 elementos cada uno
    val arreglo1 = IntArray(4)
    val arreglo2 = IntArray(4)

    // Carga del primer arreglo
    println("Carga del primer arreglo")
    for(i in arreglo1.indices) {  // Recorremos los índices del arreglo1
        print("Ingrese elemento:")
        arreglo1[i] = readln().toInt()  // Leemos el valor y lo almacenamos en arreglo1
    }

    // Carga del segundo arreglo
    println("Carga del segundo arreglo")
    for(i in arreglo2.indices) {  // Recorremos los índices del arreglo2
        print("Ingrese elemento:")
        arreglo2[i] = readln().toInt()  // Leemos el valor y lo almacenamos en arreglo2
    }

    // Declaración del arreglo para guardar la suma de los elementos de arreglo1 y arreglo2
    val arregloSuma = IntArray(4)

    // Realizamos la suma elemento a elemento de arreglo1 y arreglo2, guardamos en arregloSuma
    for(i in arregloSuma.indices)
        arregloSuma[i] = arreglo1[i] + arreglo2[i]  // Suma de los elementos correspondientes

    // Imprimimos el arreglo resultante
    println("Arreglo resultante")
    for(elemento in arregloSuma)  // Recorremos los elementos de arregloSuma
        println(elemento)  // Mostramos cada elemento en consola
}
