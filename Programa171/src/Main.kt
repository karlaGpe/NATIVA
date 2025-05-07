// Se define una enumeración llamada Operacioon que contiene dos tipos de operación: SUMA y PROMEDIO
enum class Operacioon {
    SUMA,
    PROMEDIO
}

// Función que recibe un tipo de operación y una cantidad variable de enteros (vararg arreglo)
fun operar(tipoOperacion: Operacioon, vararg arreglo: Int): Int {
    // Dependiendo del tipo de operación, se ejecuta la lógica correspondiente
    when (tipoOperacion) {
        // Si la operación es SUMA, se retorna la suma de todos los valores del arreglo
        Operacioon.SUMA -> return arreglo.sum()
        // Si la operación es PROMEDIO, se calcula el promedio y se convierte a entero
        Operacioon.PROMEDIO -> return arreglo.average().toInt()
    }
}

// Función principal
fun main(args: Array<String>) {
    // Llamamos a la función operar con el tipo de operación SUMA
    val resultado1 = operar(Operacioon.SUMA, 10, 20, 30)
    println("La suma es $resultado1") // Imprime: La suma es 60

    // Llamamos a la función operar con el tipo de operación PROMEDIO
    val resultado2 = operar(Operacioon.PROMEDIO, 10, 20, 30)
    println("El promedio es $resultado2") // Imprime: El promedio es 20
}
