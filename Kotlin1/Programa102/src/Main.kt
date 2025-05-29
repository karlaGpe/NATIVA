fun main(parametro: Array<String>) {
    // Declaramos un arreglo de 5 elementos de tipo entero
    val arreglo = IntArray(5)

    // Recorremos los índices del arreglo para cargar los valores desde teclado
    for(i in arreglo.indices) {
        print("Ingrese elemento: ")
        arreglo[i] = readLine()!!.toInt() // Convertimos el valor ingresado a entero y lo asignamos al arreglo
    }

    // Recorremos el arreglo directamente por sus elementos y los mostramos uno a uno
    for(elemento in arreglo)
        println(elemento)
}
