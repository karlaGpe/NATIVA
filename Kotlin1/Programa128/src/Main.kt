// Se define una clase de datos llamada Articulo con 3 propiedades: código, descripción y precio
data class Articulo(var codigo: Int, var descripcion: String, var precio: Float)

fun main(parametro: Array<String>) {
    // Se crea un objeto de tipo Articulo con valores iniciales
    val articulo1 = Articulo(1, "papas", 34f)

    // Se crea otro objeto Articulo con valores distintos
    var articulo2 = Articulo(2, "manzanas", 24f)

    // Se imprime articulo1 y articulo2 (gracias a que es data class, imprime bonito con toString automático)
    println(articulo1) // Articulo(codigo=1, descripcion=papas, precio=34.0)
    println(articulo2) // Articulo(codigo=2, descripcion=manzanas, precio=24.0)

    // Se crea una referencia (puntero) que apunta al mismo objeto que articulo1
    val puntero = articulo1

    // Se modifica el precio usando el puntero
    puntero.precio = 100f

    // Se imprime articulo1, y como puntero apunta al mismo objeto, refleja el cambio
    println(articulo1) // Articulo(codigo=1, descripcion=papas, precio=100.0)

    // Se crea una copia de articulo1 en articulo3 (nuevo objeto con mismos valores)
    var articulo3 = articulo1.copy()

    // Se cambia el precio de articulo1, pero esto no afecta a articulo3
    articulo1.precio = 200f

    // Se imprime articulo1 y articulo3 para ver la diferencia
    println(articulo1) // Articulo(codigo=1, descripcion=papas, precio=200.0)
    println(articulo3) // Articulo(codigo=1, descripcion=papas, precio=100.0)

    // Se comparan los objetos (compara sus valores, no sus referencias)
    if (articulo1 == articulo3)
        println("Son iguales $articulo1 y $articulo3")
    else
        println("Son distintos $articulo1 y $articulo3") // Esta línea se imprime

    // Se igualan los precios para que ambos objetos tengan exactamente los mismos valores
    articulo3.precio = 200f

    // Se comparan de nuevo
    if (articulo1 == articulo3)
        println("Son iguales $articulo1 y $articulo3") // Esta línea se imprime ahora
    else
        println("Son distintos $articulo1 y $articulo3")
}
