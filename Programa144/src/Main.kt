// Definición de la clase Personaaa, que tiene dos propiedades: nombre (String) y edad (Int).
class Personaaa(val nombre: String, val edad: Int) {

    // Método para imprimir el nombre y la edad de la persona.
    fun imprimir() {
        println("Nombre: $nombre Edad: $edad")
    }

    // Método para determinar si la persona es mayor de edad (18 o más años).
    // Devuelve true si la persona es mayor de edad, de lo contrario false.
    fun esMayor() = if (edad >= 18) true else false
}

// Función principal donde se crean los objetos y se realizan las acciones.
fun main(parametro: Array<String>) {

    // Creación de un array de objetos Personaaa con diferentes nombres y edades.
    val personas: Array<Personaaa> = arrayOf(
        Personaaa("ana", 22),   // Persona de 22 años
        Personaaa("juan", 13),  // Persona de 13 años
        Personaaa("carlos", 6), // Persona de 6 años
        Personaaa("maria", 72)  // Persona de 72 años
    )

    // Imprimir el encabezado "Listado de personas"
    println("Listado de personas")

    // Iterar sobre cada persona en el array y llamar al método imprimir para mostrar sus datos.
    for(per in personas)
        per.imprimir()

    // Variable para contar la cantidad de personas mayores de edad
    var cant = 0

    // Iterar nuevamente sobre las personas y contar cuántas son mayores de edad.
    for(per in personas)
        if (per.esMayor())  // Si la persona es mayor de edad
            cant++  // Aumentar el contador

    // Imprimir la cantidad de personas mayores de edad
    println("Cantidad de personas mayores de edad: $cant")
}
