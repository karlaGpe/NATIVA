// Función que solicita al usuario ingresar un valor entero desde teclado
fun cargaar(): Int {
    print("Ingrese un entero: ")  // Muestra un mensaje en consola
    val valor = readLine()!!.toInt()  // Lee una línea del usuario y la convierte a entero (asume que no es nula)
    return valor  // Devuelve el valor ingresado
}

fun main(args: Array<String>) {
    // Crea una lista inmutable de 5 elementos, usando la función cargaar() para llenar cada posición
    var lista1: List<Int> = List(5, { cargaar() })

    // Imprime la lista completa en consola
    println(lista1)
}
