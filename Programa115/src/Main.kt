// Definición de la clase Alumno3 con dos propiedades: nombre y nota
class Alumno3 (val nombre: String, val nota: Int){

    // Método que imprime el nombre del alumno y su nota
    fun imprimir() {
        println("Alumno: $nombre tiene una nota de $nota")
    }

    // Método que muestra si el alumno está en estado regular (nota mayor o igual a 4)
    fun mostrarEstado () {
        if (nota >= 4)
            println("$nombre se encuentra en estado REGULAR") // Si la nota es 4 o más, está regular
        else
            println("$nombre no está REGULAR") // Si la nota es menor a 4, no está regular
    }
}

// Función principal del programa
fun main(parametros: Array<String>) {
    // Se crea un objeto alumno1 con nombre "Ana" y nota 7
    val alumno1 = Alumno3("Ana", 7)
    alumno1.imprimir()         // Se imprime la información del alumno1
    alumno1.mostrarEstado()    // Se muestra si está regular o no

    // Se crea un objeto alumno2 con nombre "Carlos" y nota 2
    val alumno2 = Alumno3("Carlos", 2)
    alumno2.imprimir()         // Se imprime la información del alumno2
    alumno2.mostrarEstado()    // Se muestra si está regular o no
}
