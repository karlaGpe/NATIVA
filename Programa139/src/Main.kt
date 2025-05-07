//PROBLEMA PROPUESTO 139
/*Declarar una clase Dado que genere un valor aleatorio entre 1 y 6, mostrar su valor.
// Clase base Dado10 que simula el lanzamiento de un dado*/
open class Dado10 {
    protected var valor: Int = 1 // Variable que almacena el valor del dado, inicialmente es 1

    // Método para simular el lanzamiento de un dado, asignando un valor aleatorio entre 1 y 6
    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt() // Genera un valor aleatorio entre 1 y 6
    }

    // Método para imprimir el valor del dado en consola
    open fun imprimir() {
        println("$valor") // Muestra el valor del dado
    }
}

// Clase derivada DadoRecuadro que hereda de Dado10 y redefine el método imprimir
class DadoRecuadro : Dado10() {
    // Sobrescribe el método imprimir para mostrar el valor del dado dentro de un recuadro de asteriscos
    override fun imprimir() {
        println("***")  // Muestra la parte superior del recuadro
        println("*$valor*")  // Muestra el valor del dado dentro del recuadro
        println("***")  // Muestra la parte inferior del recuadro
    }
}

// Función principal
fun main(parametro: Array<String>) {
    // Crear una instancia de la clase Dado10
    val dado1 = Dado10()
    dado1.tirar()  // Lanza el dado generando un valor aleatorio
    dado1.imprimir()  // Muestra el valor del dado

    // Crear una instancia de la clase DadoRecuadro
    val dado2 = DadoRecuadro()
    dado2.tirar()  // Lanza el dado generando un valor aleatorio
    dado2.imprimir()  // Muestra el valor del dado dentro de un recuadro
}
