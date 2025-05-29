// Función que recorre todo el arreglo y aplica la función 'fn' a cada elemento.
// No retorna nada, ya que 'fn' es una función de tipo Unit (sin retorno).
fun recorrerTodo(arreglo: IntArray, fn:(Int) -> Unit) {
    for (elemento in arreglo)
        fn(elemento)  // Ejecuta la función pasada como parámetro para cada elemento.
}

fun main(parametro: Array<String>) {
    // Crear un arreglo de enteros con 10 elementos
    val arreglo1 = IntArray(10)

    // Llenar el arreglo con valores aleatorios del 0 al 99
    for (i in arreglo1.indices)
        arreglo1[i] = ((Math.random() * 100)).toInt()

    // Imprimir todos los valores generados en el arreglo
    println("Impresion de todo el arreglo")
    for (elemento in arreglo1)
        print("$elemento ")
    println()

    // Contar cuántos elementos del arreglo son múltiplos de 3
    var cantidad = 0
    recorrerTodo(arreglo1) {
        if (it % 3 == 0)
            cantidad++  // Incrementa el contador si el número es múltiplo de 3
    }
    println("La cantidad de elementos múltiplos de 3 son $cantidad")

    // Sumar todos los elementos del arreglo que son mayores a 50
    var suma = 0
    recorrerTodo(arreglo1) {
        if (it > 50)
            suma += it  // Acumula la suma si el número es mayor a 50
    }
    println("La suma de todos los elementos mayores a 50 es $suma")
}
