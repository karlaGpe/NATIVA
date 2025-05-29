// Clase que representa a un Socio con su nombre y antigüedad en el club
class Socio(val nombre: String, val antiguedad: Int) {
    // Método para imprimir el nombre del socio y su antigüedad
    fun imprimir() {
        println("$nombre tiene una antiguedad de $antiguedad años")  // Muestra el nombre y la antigüedad
    }
}

// Clase que representa a un Club con tres socios
class Club {
    // Se definen tres objetos Socio con sus respectivos nombres y antigüedades
    val socio1 = Socio("Juan", 22)  // Socio Juan con 22 años de antigüedad
    val socio2 = Socio("Ana", 34)   // Socio Ana con 34 años de antigüedad
    val socio3 = Socio("Carlos", 1) // Socio Carlos con 1 año de antigüedad

    // Método para determinar e imprimir el nombre del socio con mayor antigüedad
    fun mayorAntiguedad() {
        // Imprime los datos de todos los socios
        socio1.imprimir()
        socio2.imprimir()
        socio3.imprimir()

        // Determina e imprime el socio con mayor antigüedad
        print("Socio con mayor antiguedad: ")
        when {
            // Si la antigüedad de Juan es mayor que la de Ana y Carlos, imprime el nombre de Juan
            socio1.antiguedad > socio2.antiguedad && socio1.antiguedad > socio3.antiguedad -> print(socio1.nombre)
            // Si la antigüedad de Ana es mayor que la de Carlos, imprime el nombre de Ana
            socio2.antiguedad > socio3.antiguedad -> print(socio2.nombre)
            // Si no, imprime el nombre de Carlos
            else -> print(socio3.nombre)
        }
    }
}

// Función principal que ejecuta el código del Club
fun main(parametro: Array<String>) {
    // Crea una instancia de la clase Club
    val club1 = Club()

    // Llama al método para imprimir el socio con mayor antigüedad
    club1.mayorAntiguedad()
}
