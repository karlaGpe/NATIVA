// Función sumar que recibe un número variable de argumentos enteros (vararg)
fun sumar(vararg numeros: Int): Int {
    var suma = 0 // Variable para almacenar la suma de los números
    // Recorre cada número en los parámetros vararg y los suma
    for (elemento in numeros)
        suma += elemento // Suma el valor de cada elemento
    return suma // Devuelve la suma total
}

fun main(args: Array<String>) {
    // Llamada a la función sumar con varios argumentos y almacena el resultado en total
    val total = sumar(10, 20, 30, 40, 50)

    // Imprime el total de la suma
    println(total) // Salida esperada: 150
}
