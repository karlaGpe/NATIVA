fun main(parametro: Array<String>) {
    // Crear un arreglo de 20 elementos, donde cada uno es un número aleatorio entre 0 y 10
    var arreglo = IntArray(20) { (Math.random() * 11).toInt() }

    // Imprimir el arreglo completo
    println("Listado completo del arreglo")
    for (elemento in arreglo)
        print("$elemento ")
    println()

    // Contar cuántos elementos son menores o iguales a 5
    val cant1 = arreglo.count { it <= 5 }
    println("Cantidad de elementos menores o iguales a 5: $cant1")

    // Verificar si todos los elementos son menores o iguales a 9
    if (arreglo.all { it <= 9 })
        println("Todos los elementos son menores o iguales a 9")
    else
        println("No todos los elementos son menores o iguales a 9")

    // Verificar si al menos uno de los elementos es un 10
    if (arreglo.any { it == 10 })
        println("Al menos uno de los elementos es un 10")
    else
        println("Todos los elementos son distintos a 10")
}
