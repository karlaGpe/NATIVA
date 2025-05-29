class Persona {
    var nombre: String = ""
    var edad: Int = 0

    // Inicializa los valores de la persona
    fun inicializar(nombre: String, edad: Int) {
        this.nombre = nombre
        this.edad = edad
    }

    // Imprime el nombre y la edad de la persona
    fun imprimir() {
        println("Nombre: $nombre y tiene una edad de $edad")
    }

    // Verifica si la persona es mayor de edad
    fun esMayorEdad() {
        if (edad >= 18)
            println("Es mayor de edad $nombre")
        else
            println("No es mayor de edad $nombre")
    }
}

fun main(parametro: Array<String>) {
    // Creación e inicialización de la primera persona
    val persona1 = Persona().apply {
        inicializar("Juan", 12)
    }
    persona1.imprimir()
    persona1.esMayorEdad()

    // Creación e inicialización de la segunda persona
    val persona2 = Persona().apply {
        inicializar("Ana", 50)
    }
    persona2.imprimir()
    persona2.esMayorEdad()
}
