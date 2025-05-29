class Persona0(val nombre: String, val edad: Int) {
    // Método para imprimir los detalles de la persona
    fun imprimir() {
        println("Nombre: $nombre y tiene una edad de $edad")
    }

    // Sobrecarga del operador compareTo para comparar las edades
    operator fun compareTo(per2: Persona0): Int {
        return when {
            edad < per2.edad -> -1  // Si esta persona es más joven
            edad > per2.edad -> 1   // Si esta persona es mayor
            else -> 0               // Si tienen la misma edad
        }
    }
}

fun main(parametro: Array<String>) {
    // Creación de dos objetos de tipo Persona0
    val persona1 = Persona0("Juan", 30)
    persona1.imprimir()

    val persona2 = Persona0("Ana", 30)
    persona2.imprimir()

    println("Persona mayor:")

    // Comparación usando el operador 'compareTo' en un bloque when
    when {
        persona1 > persona2 -> persona1.imprimir()  // persona1 es mayor
        persona1 < persona2 -> persona2.imprimir()  // persona2 es mayor
        else -> println("Tienen la misma edad")     // Ambas personas tienen la misma edad
    }
}
