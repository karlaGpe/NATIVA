fun main(parametro: Array<String>) {
    // Crear un arreglo de tipo FloatArray con 10 elementos
    val arreglo = FloatArray(10)

    // Solicitar al usuario que ingrese los 10 elementos del arreglo
    for (i in arreglo.indices) {
        print("Ingrese elemento: ")
        arreglo[i] = readln().toFloat()  // Leer un valor flotante y almacenarlo en el arreglo
    }

    // Imprimir el arreglo completo
    println("Listado completo del arreglo")
    for (elemento in arreglo)
        print("$elemento ")  // Imprimir cada elemento seguido de un espacio
    println()  // Salto de línea al final del listado

    // Contar cuántos valores son menores a 50
    val cant = arreglo.count { it < 50 }
    println("Cantidad de valores ingresados menores a 50: $cant")

    // Verificar si todos los valores son menores a 50
    if (arreglo.all { it < 50 })
        println("Todos los valores son menores a 50")
    else
        println("No todos los valores son menores a 50")
}
