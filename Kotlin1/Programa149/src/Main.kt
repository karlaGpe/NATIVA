// Función operarr que recibe dos enteros (v1, v2) y una función (fn) que realiza una operación con esos enteros
fun operarr(v1: Int, v2: Int, fn: (Int, Int) -> Int): Int {
    return fn(v1, v2)  // Ejecuta la función fn pasando v1 y v2 como argumentos y devuelve el resultado
}

fun main(parametro: Array<String>) {
    // Suma de 2 y 3 usando una expresión lambda
    val suma = operarr(2, 3, { x, y -> x + y })  // La lambda toma x e y y devuelve la suma
    println(suma)  // Imprime el resultado de la suma (5)

    // Resta de 12 y 2 usando una expresión lambda
    val resta = operarr(12, 2, { x, y -> x - y })  // La lambda toma x e y y devuelve la resta
    println(resta)  // Imprime el resultado de la resta (10)

    // Elevar 2 a la cuarta potencia usando una expresión lambda
    var elevarCuarta = operarr(2, 4, { x, y ->
        var valor = 1  // Inicializamos la variable valor en 1
        for (i in 1..y)  // Hacemos un ciclo que va de 1 hasta y (en este caso 4)
            valor = valor * x  // Multiplicamos valor por x en cada iteración
        valor  // Al finalizar el ciclo, devolvemos el resultado final
    })
    println(elevarCuarta)  // Imprime 16 (2 elevado a la cuarta)
}
