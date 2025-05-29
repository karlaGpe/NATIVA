// Definición de la clase Operaciones
class Operaciones {
    // Variables que almacenarán los valores ingresados por el usuario
    var valor1: Int = 0
    var valor2: Int = 0

    // Método para cargar los valores desde el teclado y realizar las operaciones
    fun cargar() {
        print("Ingrese primer valor:")                     // Solicita al usuario que ingrese el primer valor
        valor1 = readLine()!!.toInt()                      // Lee el valor ingresado y lo convierte a entero
        print("Ingrese segundo valor:")                    // Solicita al usuario que ingrese el segundo valor
        valor2 = readLine()!!.toInt()                      // Lee el segundo valor ingresado y lo convierte a entero
        sumar()                                             // Llama al método sumar
        restar()                                            // Llama al método restar
    }

    // Método que suma los dos valores y muestra el resultado
    fun sumar() {
        val suma = valor1 + valor2                         // Realiza la suma de los dos valores
        println("La suma de $valor1 y $valor2 es $suma")   // Muestra el resultado de la suma
    }

    // Método que resta el segundo valor al primero y muestra el resultado
    fun restar() {
        val resta = valor1 - valor2                        // Realiza la resta entre los dos valores
        println("La resta de $valor1 y $valor2 es $resta") // Muestra el resultado de la resta
    }
}

// Función principal del programa
fun main(parametro: Array<String>) {
    val operaciones1 = Operaciones()                       // Crea un objeto de la clase Operaciones
    operaciones1.cargar()                                  // Llama al método cargar para iniciar el proceso
}
