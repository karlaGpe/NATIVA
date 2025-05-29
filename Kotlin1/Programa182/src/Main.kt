// Función para imprimir los productos y sus precios.
fun imprimir(productos: Map<String, Float>) {
    // Recorremos cada elemento del mapa (producto y precio).
    for((clave, valor) in productos) {
        // Imprimimos el nombre del producto y su precio con formato
        println("$clave tiene un precio $valor")
    }
    println() // Se añade una línea en blanco para separar la salida de la siguiente información.
}

// Función para contar cuántos productos tienen un precio mayor a 20.
fun cantidadPrecioMayor20(productos: Map<String, Float>) {
    // Usamos count para contar los productos cuyo valor (precio) es mayor a 20.
    val cant = productos.count { it.value > 20 }
    // Imprimimos la cantidad de productos con precio superior a 20.
    println("Cantidad de productos con un precio superior a 20: $cant")
}

fun main(args: Array<String>) {
    // Se define un mapa inmutable con productos y sus precios.
    val productos: Map<String, Float> = mapOf(
        "papas" to 12.5f,  // Producto 'papas' con precio 12.5
        "manzanas" to 26f,  // Producto 'manzanas' con precio 26.0
        "peras" to 31f,     // Producto 'peras' con precio 31.0
        "mandarinas" to 15f,// Producto 'mandarinas' con precio 15.0
        "pomelos" to 28f    // Producto 'pomelos' con precio 28.0
    )

    // Llamamos a la función imprimir para mostrar los productos y precios.
    imprimir(productos)

    // Llamamos a la función cantidadPrecioMayor20 para contar los productos con precio mayor a 20.
    cantidadPrecioMayor20(productos)
}
