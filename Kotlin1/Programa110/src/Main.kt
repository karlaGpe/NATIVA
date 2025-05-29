// Definición de la clase Triangulo
class Triangulo {
    // Variables para almacenar los lados del triángulo
    var lado1: Int = 0
    var lado2: Int = 0
    var lado3: Int = 0

    // Método para inicializar los lados del triángulo solicitando al usuario que ingrese los valores
    fun inicializar() {
        print("Ingrese lado 1:")
        lado1 = readLine()!!.toInt() // Se lee el valor del lado 1 desde consola y se convierte a entero
        print("Ingrese lado 2:")
        lado2 = readLine()!!.toInt() // Se lee el valor del lado 2 desde consola y se convierte a entero
        print("Ingrese lado 3:")
        lado3 = readLine()!!.toInt() // Se lee el valor del lado 3 desde consola y se convierte a entero
    }

    // Método que determina y muestra cuál de los tres lados es el mayor
    fun ladoMayor() {
        print("Lado mayor:")
        // Se usa una estructura when para comparar los tres lados
        when {
            lado1 > lado2 && lado1 > lado3 -> println(lado1) // lado1 es el mayor
            lado2 > lado3 -> println(lado2) // lado2 es mayor que lado3 (y no mayor que lado1)
            else -> println(lado3) // lado3 es el mayor o al menos igual a los demás
        }
    }

    // Método que determina si el triángulo es equilátero (todos los lados iguales)
    fun esEquilatero() {
        if (lado1 == lado2 && lado1 == lado3)
            print("Es un triángulo equilátero") // Si los tres lados son iguales, se informa que es equilátero
        else
            print("No es un triángulo equilátero") // Si hay al menos un lado distinto, no es equilátero
    }
}

// Función principal que crea un objeto de tipo Triangulo y llama a sus métodos
fun main(parametro: Array<String>) {
    val triangulo1 = Triangulo() // Se crea una instancia de la clase Triangulo
    triangulo1.inicializar() // Se cargan los lados del triángulo
    triangulo1.ladoMayor() // Se muestra el lado mayor
    triangulo1.esEquilatero() // Se determina si el triángulo es equilátero
}
