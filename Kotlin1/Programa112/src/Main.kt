// Definición de la clase Persona2 con constructor primario
class Persona2 constructor(nombre: String, edad: Int) {
    var nombre: String = nombre  // Se asigna el parámetro del constructor a la propiedad de la clase
    var edad: Int = edad         // Igual que arriba

    // Método que imprime el nombre y edad de la persona
    fun imprimir() {
        println("Nombre: $nombre y tiene una edad de $edad")
    }

    // Método que indica si la persona es mayor de edad
    fun esMayorEdad() {
        if (edad >= 18)
            println("Es mayor de edad $nombre")
        else
            println("No es mayor de edad $nombre")
    }
}

// Función main para ejecutar el código
fun main(parametro: Array<String>) {
    val persona1 = Persona2("Juan", 12)  // Se crea un objeto con nombre "Juan" y edad 12
    persona1.imprimir()                  // Se llama al método para imprimir datos
    persona1.esMayorEdad()              // Se verifica si es mayor de edad
}
