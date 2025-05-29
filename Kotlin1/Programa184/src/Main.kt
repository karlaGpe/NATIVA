// Definición de la clase Producto que tiene tres propiedades: nombre, precio y cantidad.
data class Producto(val nombre: String, val precio: Float, val cantidad: Int)

// Función que carga productos en el diccionario (MutableMap).
fun cargar(productos: MutableMap<Int, Producto>) {
    // Cargamos productos con código, nombre, precio y cantidad en el mapa.
    productos[1] = Producto("Papas", 13.15f, 200)
    productos[15] = Producto("Manzanas", 20f, 0)
    productos[20] = Producto("Peras", 3.50f, 0)
}

// Función para imprimir el listado completo de productos en el diccionario.
fun listadoCompleto(productos: MutableMap<Int, Producto>) {
    println("Listado completo de productos")
    // Recorremos todos los productos en el diccionario e imprimimos sus detalles.
    for((codigo, producto) in productos)
    // Mostramos el código, nombre, precio y cantidad en stock de cada producto.
        println("Código: $codigo Descripción ${producto.nombre} Precio: ${producto.precio} Stock Actual: ${producto.cantidad}")
    println() // Línea vacía para separar la salida.
}

// Función que permite consultar un producto por su código.
fun consultaProducto(productos: MutableMap<Int, Producto>) {
    // Solicitamos al usuario que ingrese un código de producto.
    print("Ingrese el código de un producto:")
    val codigo = readLine()!!.toInt() // Leemos la entrada y la convertimos a entero.

    // Verificamos si el código ingresado está presente en el diccionario de productos.
    if (codigo in productos)
    // Si el producto existe, mostramos su nombre, precio y cantidad.
        println("Nombre: ${productos[codigo]?.nombre} Precio: ${productos[codigo]?.precio} Stock: ${productos[codigo]?.cantidad}")
    else
    // Si el producto no existe, informamos al usuario.
        println("No existe un producto con dicho código")
}

// Función que cuenta la cantidad de productos sin stock (cantidad == 0).
fun sinStock(productos: MutableMap<Int, Producto>) {
    // Contamos los productos cuyo stock sea 0.
    val cant = productos.count { it.value.cantidad == 0 }
    // Imprimimos el resultado.
    println("Cantidad de artículos sin stock: $cant")
}

// Función principal donde se coordinan las acciones.
fun main(args: Array<String>) {
    // Creamos un mapa mutable para almacenar los productos, con claves de tipo Int (código del producto) y valores de tipo Producto.
    val productos: MutableMap<Int, Producto> = mutableMapOf()

    // Llamamos a la función cargar para agregar productos al mapa.
    cargar(productos)

    // Llamamos a la función listadoCompleto para imprimir todos los productos.
    listadoCompleto(productos)

    // Llamamos a la función consultaProducto para permitir que el usuario consulte un producto por su código.
    consultaProducto(productos)

    // Llamamos a la función sinStock para mostrar cuántos productos están sin stock.
    sinStock(productos)
}
