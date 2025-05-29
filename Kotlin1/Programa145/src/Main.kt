// Definición de un data class llamado Articuloo con tres propiedades: código, descripción y precio
data class Articuloo(val codigo: Int, val descripcion: String, var precio: Float)

// Función para imprimir todos los artículos del array de tipo Articuloo
fun imprimir(articulos: Array<Articuloo>) {
    // Itera sobre cada artículo en el array y muestra su código, descripción y precio
    for(articulo in articulos)
        println("Código: ${articulo.codigo} - Descripción: ${articulo.descripcion} Precio: ${articulo.precio}")
}

// Función para aumentar el precio de todos los artículos en un 10%
fun aumentarPrecio(articulos: Array<Articuloo>) {
    // Itera sobre cada artículo en el array y aumenta su precio en un 10%
    for(articulo in articulos)
        articulo.precio = articulo.precio + (articulo.precio * 0.10f) // Aumenta el 10% al precio
}

// Función principal donde se crean los artículos y se ejecutan las funciones
fun main(parametro: Array<String>) {
    // Creación de un array de 4 artículos con su código, descripción y precio
    val articulos: Array<Articuloo> = arrayOf(
        Articuloo(1, "papas", 7.5f),     // Artículo con código 1, descripción "papas" y precio 7.5
        Articuloo(2, "manzanas", 23.2f), // Artículo con código 2, descripción "manzanas" y precio 23.2
        Articuloo(3, "naranjas", 12f),   // Artículo con código 3, descripción "naranjas" y precio 12
        Articuloo(4, "cebolla", 21f)     // Artículo con código 4, descripción "cebolla" y precio 21
    )

    // Mostrar el listado de precios actual
    println("Listado de precios actual")
    imprimir(articulos) // Llamar a la función imprimir para mostrar los artículos con sus precios actuales

    // Aumentar el precio de todos los artículos en un 10%
    aumentarPrecio(articulos)

    // Imprimir un salto de línea para separar las salidas
    println()

    // Mostrar el listado de precios con el aumento del 10%
    println("Listado de precios con aumento del 10%")
    imprimir(articulos) // Llamar nuevamente a la función imprimir para mostrar los artículos con los precios aumentados
}
