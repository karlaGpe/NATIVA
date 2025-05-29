fun main(parametro: Array<String>) {
    // Declaramos un arreglo de 10 elementos tipo entero
    val arreglo = IntArray(10)

    // Usamos 'indices' para recorrer cada posición del arreglo (del 0 al 9)
    for (i in arreglo.indices) {
        print("Ingrese elemento: ")
        arreglo[i] = readLine()!!.toInt() // Leemos y almacenamos cada número ingresado
    }

    // Mostramos el primer valor del arreglo (posición 0)
    println("Primera componente del arreglo: ${arreglo[0]}")

    // Mostramos el último valor del arreglo usando 'lastIndex' que devuelve el último índice válido
    println("Última componente del arreglo: ${arreglo[arreglo.lastIndex]}")
}
