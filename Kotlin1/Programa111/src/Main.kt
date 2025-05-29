// PROBLEMA PROPUESTO 111
/*Implementar una clase llamada Alumno que tenga como propiedades su nombre y su nota.
Definir los métodos para inicializar sus propiedades por teclado, imprimirlos y mostrar un mensaje si está regular
(nota mayor o igual a 4). Definir dos objetos de la clase Alumno.*/

// Definición de la clase Alumno
class Alumno {
    // Propiedades de la clase: nombre del alumno y su nota
    var nombre: String = ""
    var nota: Int = 0

    // Método para inicializar las propiedades ingresando los valores desde teclado
    fun inicializar() {
        print("Ingrese el nombre del alumno:")
        nombre = readln().toString() // Se lee el nombre como texto desde consola
        print("Ingrese su nota:")
        nota = readln().toInt() // Se lee la nota como entero desde consola
    }

    // Método para imprimir el nombre del alumno y su nota
    fun imprimir() {
        println("Alumno: $nombre tiene una nota de $nota")
    }

    // Método que evalúa si el alumno está en estado regular (nota >= 4)
    fun mostrarEstado () {
        if (nota >= 4)
            println("$nombre se encuentra en estado REGULAR") // Si la nota es 4 o más, está regular
        else
            println("$nombre no está REGULAR") // Si la nota es menor a 4, no está regular
    }
}

// Función principal
fun main(parametros: Array<String>) {
    // Se crea el primer objeto de tipo Alumno
    val alumno1 = Alumno()
    alumno1.inicializar()     // Se inicializa con datos ingresados por el usuario
    alumno1.imprimir()        // Se imprime el nombre y la nota
    alumno1.mostrarEstado()   // Se evalúa si está regular o no

    // Se crea el segundo objeto de tipo Alumno
    val alumno2 = Alumno()
    alumno2.inicializar()     // Se inicializa con nuevos datos ingresados por el usuario
    alumno2.imprimir()        // Se imprime el nombre y la nota
    alumno2.mostrarEstado()   // Se evalúa si está regular o no
}
