// archivo: main.kt

// Importamos el paquete 'entradateclado' que contiene la función 'retornarInt'.
import entradateclado.*

fun main(args: Array<String>) {
    // Solicitamos el primer valor al usuario y lo almacenamos en la variable 'numero1'.
    val numero1 = retornarInt("Ingrese primer valor:")

    // Solicitamos el segundo valor al usuario y lo almacenamos en la variable 'numero2'.
    val numero2 = retornarInt("Ingrese segundo valor:")

    // Imprimimos la suma de los dos números ingresados.
    println("La suma es ${numero1 + numero2}")
}
