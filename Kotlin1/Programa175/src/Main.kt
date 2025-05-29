fun main(args: Array<String>) {
    // Creamos una lista mutable de enteros con algunas edades
    val edades: MutableList<Int> = mutableListOf(23, 67, 12, 35, 12)

    println("Lista de edades")
    println(edades)  // Imprime la lista inicial

    // Modificamos el primer valor de la lista (posición 0)
    edades[0] = 60
    println("Lista completa después de modificar la primer edad")
    println(edades)

    // Imprimimos el primer elemento de la lista
    println("Primera edad almacenada en la lista")
    println(edades[0])

    // Calculamos e imprimimos el promedio de edades
    println("Promedio de edades")
    println(edades.average())

    // Agregamos un nuevo valor al final de la lista
    println("Agregamos una edad al final de la lista:")
    edades.add(50)
    println("Lista de edades")
    println(edades)

    // Agregamos un valor al inicio de la lista (posición 0)
    println("Agregamos una edad al principio de la lista:")
    edades.add(0, 17)
    println("Lista de edades")
    println(edades)

    // Eliminamos el primer elemento de la lista
    println("Eliminamos la primer edad de la lista:")
    edades.removeAt(0)
    println("Lista de edades")
    println(edades)

    // Contamos cuántos elementos son mayores o iguales a 18
    print("Cantidad de personas mayores de edad:")
    val cant = edades.count { it >= 18 }
    println(cant)

    // Eliminamos todas las edades que sean exactamente 12
    edades.removeAll { it == 12 }
    println("Lista de edades después de borrar las que tienen 12 años")
    println(edades)

    // Limpiamos completamente la lista
    edades.clear()
    println("Lista de edades luego de borrar la lista en forma completa")
    println(edades)

    // Verificamos si la lista está vacía
    if (edades.isEmpty())
        println("No hay edades almacenadas en la lista")
}
