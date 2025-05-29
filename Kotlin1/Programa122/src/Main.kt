// Clase que define operaciones matemáticas con dos valores
class Operaciones2 {
    // Variables privadas para almacenar los dos valores ingresados
    private var valor1: Int = 0
    private var valor2: Int = 0

    // Método para cargar los valores ingresados por el usuario
    fun cargar() {
        // Solicita y lee el primer valor ingresado por el usuario
        print("Ingrese primer valor:")
        valor1 = readLine()!!.toInt()

        // Solicita y lee el segundo valor ingresado por el usuario
        print("Ingrese segundo valor:")
        valor2 = readLine()!!.toInt()

        // Llama a los métodos para realizar las operaciones
        sumar()
        restar()
    }

    // Método privado para realizar la suma de los dos valores
    private fun sumar() {
        val suma = valor1 + valor2
        // Imprime el resultado de la suma
        println("La suma de $valor1 y $valor2 es $suma")
    }

    // Método privado para realizar la resta de los dos valores
    private fun restar() {
        val resta = valor1 - valor2
        // Imprime el resultado de la resta
        println("La resta de $valor1 y $valor2 es $resta")
    }
}

// Función principal que crea un objeto de la clase Operaciones2 y ejecuta el método cargar
fun main(parametro: Array<String>) {
    // Crea una instancia de la clase Operaciones2
    val operaciones1 = Operaciones2()
    // Llama al método cargar para ingresar los valores y realizar las operaciones
    operaciones1.cargar()
}
