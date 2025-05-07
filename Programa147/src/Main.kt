// Definición de la función operar que recibe dos enteros y una función que toma dos enteros y devuelve un entero
fun operar(v1: Int, v2: Int, fn: (Int, Int) -> Int): Int {
    return fn(v1, v2) // Se llama a la función fn pasándole los dos valores v1 y v2
}

// Funciones para realizar operaciones básicas
fun sumar(x1: Int, x2: Int) = x1 + x2  // Suma de dos números
fun restar(x1: Int, x2: Int) = x1 - x2 // Resta de dos números
fun multiplicar(x1: Int, x2: Int) = x1 * x2 // Multiplicación de dos números
fun dividir(x1: Int, x2: Int) = x1 / x2 // División de dos números

// Función principal
fun main(parametro: Array<String>) {
    // Se realiza la operación de suma utilizando la función operar y el operador de suma
    val resu1 = operar(10, 5, ::sumar)
    println("La suma de 10 y 5 es $resu1") // Imprime el resultado de la suma

    // Se realiza otra operación de suma
    val resu2 = operar(5, 2, ::sumar)
    println("La suma de 5 y 2 es $resu2") // Imprime el resultado de la suma

    // Se realiza una operación de resta utilizando la función operar y el operador de resta
    println("La resta de 100 y 40 es ${operar(100, 40, ::restar)}") // Imprime el resultado de la resta

    // Se realiza una operación de multiplicación utilizando la función operar y el operador de multiplicación
    println("El producto entre 5 y 20 es ${operar(5, 20, ::multiplicar)}") // Imprime el resultado de la multiplicación

    // Se realiza una operación de división utilizando la función operar y el operador de división
    println("La división entre 10 y 5 es ${operar(10, 5, ::dividir)}") // Imprime el resultado de la división
}
