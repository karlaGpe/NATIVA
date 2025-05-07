// Función para cargar los elementos en un arreglo
fun cargar(arreglo: IntArray) {
    // Recorremos el arreglo por sus índices para cargar sus elementos
    for(i in arreglo.indices) {
        print("Ingrese elemento:")  // Solicitamos al usuario que ingrese un valor
        arreglo[i] = readLine()!!.toInt()  // Leemos el valor, lo convertimos a entero y lo asignamos al arreglo
    }
}

// Función para imprimir todos los elementos del arreglo
fun imprimirArr(arreglo: IntArray) {
    // Recorremos el arreglo y mostramos cada uno de sus elementos
    for(elemento in arreglo)
        println(elemento)  // Imprimimos cada elemento del arreglo
}

fun main(parametro: Array<String>) {
    // Creamos un arreglo de 5 enteros
    val arre = IntArray(5)

    // Llamamos a la función cargar para cargar los valores en el arreglo
    cargar(arre)

    // Llamamos a la función imprimirArr para imprimir los valores del arreglo
    imprimirArr(arre)
}
