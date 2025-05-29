// Función para cargar un arreglo con elementos proporcionados por el usuario
fun cargarArra(): IntArray {
    // Pedimos al usuario la cantidad de elementos que tendrá el arreglo
    print("¿Cuántos elementos tendrá el arreglo?:")
    val cantidad = readln().toInt()  // Leemos la cantidad y la convertimos a entero

    // Creamos un arreglo de enteros con la cantidad proporcionada
    val arreglo = IntArray(cantidad)

    // Bucle para cargar cada elemento en el arreglo
    for(i in arreglo.indices) {
        print("Ingrese elemento:")  // Pedimos al usuario que ingrese un valor
        arreglo[i] = readln().toInt()  // Leemos y asignamos el valor al arreglo
    }
    return arreglo  // Retornamos el arreglo cargado
}

// Función para imprimir los elementos del arreglo
fun imprimirArra(arreglo: IntArray) {
    println("Listado completo del arreglo")  // Imprimimos un encabezado
    // Recorremos el arreglo y mostramos cada elemento
    for(elemento in arreglo)
        println(elemento)  // Imprimimos cada elemento del arreglo
}

// Función para sumar todos los elementos del arreglo
fun sumarArra(arreglo: IntArray): Int {
    var suma = 0  // Variable para almacenar la suma de los elementos
    // Recorremos el arreglo y sumamos sus elementos
    for(elemento in arreglo)
        suma += elemento  // Sumamos cada elemento al total
    return suma  // Retornamos la suma total
}

fun main(parametro: Array<String>) {
    // Llamamos a la función cargarArra para obtener el arreglo cargado por el usuario
    val arreglo = cargarArra()

    // Llamamos a la función imprimirArra para mostrar el arreglo
    imprimirArra(arreglo)

    // Llamamos a la función sumarArra para obtener la suma de los elementos del arreglo
    // E imprimimos la suma en la consola
    println("La suma de todos sus elementos es ${sumarArra(arreglo)}")
}
