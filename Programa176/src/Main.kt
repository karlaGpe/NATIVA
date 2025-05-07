fun main(args: Array<String>) {
    // Creamos una lista mutable de 20 enteros. Cada número es aleatorio entre 1 y 6
    val lista: MutableList<Int> = MutableList(20) { ((Math.random() * 6) + 1).toInt() }

    // Mostramos la lista completa
    println("Lista completa")
    println(lista)

    // Contamos cuántos elementos tienen el valor 1
    val cant = lista.count { it == 1 }
    println("Cantidad de elementos con el valor 1: $cant")

    // Eliminamos todos los elementos cuyo valor sea 6
    lista.removeAll { it == 6 }

    // Mostramos la lista después de borrar los elementos con el valor 6
    println("Lista luego de borrar los elementos con el valor 6")
    println(lista)
}
