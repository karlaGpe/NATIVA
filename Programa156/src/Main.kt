// Definición de la clase Personaaaa
class Personaaaa(val nombre: String, val edad: Int) {

    // Método para imprimir los datos de la persona
    fun imprimir() {
        println("Nombre: $nombre Edad: $edad")
    }

    // Método que retorna true si la persona es mayor de edad (18 o más), false en caso contrario
    fun esMayor() = if (edad >= 18) true else false
}

// Función principal del programa
fun main(parametro: Array<String>) {
    // Crear un arreglo de objetos Personaaaa con datos predefinidos
    val personas: Array<Personaaaa> = arrayOf(
        Personaaaa("ana", 22),
        Personaaaa("juan", 13),
        Personaaaa("carlos", 6),
        Personaaaa("maria", 72)
    )

    // Imprimir el listado de personas
    println("Listado de personas")
    for (per in personas)
        per.imprimir()  // Se llama al método imprimir() de cada objeto

    // Contar cuántas personas son mayores de edad
    var cant = 0
    personas.forEach {
        if (it.esMayor())  // Si la persona es mayor de edad
            cant++         // Aumentar el contador
    }

    // Mostrar la cantidad de personas mayores de edad
    println("Cantidad de personas mayores de edad: $cant")
}
