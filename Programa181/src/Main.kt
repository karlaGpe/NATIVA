fun main(args: Array<String>) {
    // Creamos un mapa inmutable con países y sus respectivas poblaciones
    val paises: Map<String, Int> = mapOf(
        Pair("argentina", 40000000),
        Pair("españa", 46000000),
        Pair("uruguay", 3400000)
    )

    // Imprimimos el mapa completo
    println("Listado completo del Map")
    println(paises)

    // Recorremos el mapa e imprimimos las claves y valores
    for ((clave, valor) in paises)
        println("Para la clave $clave tenemos almacenado $valor")

    // Imprimimos el tamaño del mapa
    println("La cantidad de elementos del mapa es ${paises.size}")

    // Buscamos la cantidad de habitantes de Argentina
    val cantHabitantes1: Int? = paises["argentina"]
    if (cantHabitantes1 != null)
        println("La cantidad de habitantes de argentina es $cantHabitantes1")

    // Intentamos buscar la cantidad de habitantes de Brasil, que no está en el mapa
    val cantHabitantes2: Int? = paises["brasil"]
    if (cantHabitantes2 != null)
        println("La cantidad de habitantes de brasil es $cantHabitantes2")
    else
        println("brasil no se encuentra cargado en el Map")

    // Calculamos la suma de la población de todos los países en el mapa
    var suma = 0
    paises.forEach { suma += it.value }

    // Imprimimos el total de habitantes sumados
    println("Cantidad total de habitantes de todos los paises es $suma")
}
