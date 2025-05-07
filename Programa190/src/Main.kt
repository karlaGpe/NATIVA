// Importamos el paquete 'matematica' para poder usar las funciones definidas allí.
import matematica.*

// Función principal donde se ejecuta el programa.
fun main(args: Array<String>) {
    // Llamamos a la función 'sumar' para obtener la suma de 5 y 7.
    val su = sumar(5, 7)
    // Imprimimos el resultado de la suma.
    println("La suma es $su")

    // Llamamos a la función 'restar' para obtener la resta de 10 y 3.
    val re = restar(10, 3)
    // Imprimimos el resultado de la resta.
    println("La resta es $re")
}
