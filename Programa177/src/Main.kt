// Definimos una clase llamada Persona00 con dos propiedades: nombre y edad
class Persona00(var nombre: String, var edad: Int) {

    // Método para imprimir los datos de la persona
    fun imprimir() {
        println("Nombre: $nombre y tiene una edad de $edad")
    }

    // Método para verificar si la persona es mayor de edad
    fun esMayorEdad() {
        if (edad >= 18)
            println("Es mayor de edad $nombre")
        else
            println("No es mayor de edad $nombre")
    }
}

fun main(args: Array<String>) {
    // Creamos una lista mutable de personas con tres objetos Persona00
    val personas: MutableList<Persona00>
    personas = mutableListOf(
        Persona00("Juan", 22),
        Persona00("Ana", 19),
        Persona00("Marcos", 12)
    )

    // Mostramos el mensaje de listado
    println("Listado de todas las personas")

    // Recorremos la lista y llamamos al método imprimir de cada persona
    personas.forEach { it.imprimir() }

    // Contamos cuántas personas son mayores de edad (edad >= 18)
    val cant = personas.count { it.edad >= 18 }

    // Imprimimos la cantidad de personas mayores de edad
    println("La cantidad de personas mayores de edad es $cant")
}
