// Definición de la clase Triangulos con tres propiedades: lado1, lado2 y lado3
class Triangulos (var lado1: Int, var lado2: Int, var lado3: Int){

    // Método para identificar cuál es el lado mayor del triángulo
    fun ladoMayor() {
        print("Lado mayor:")
        when {
            // Si lado1 es mayor que los otros dos, se imprime lado1
            lado1 > lado2 && lado1 > lado3 -> println(lado1)
            // Si no, se compara lado2 con lado3; si lado2 es mayor, se imprime
            lado2 > lado3 -> println(lado2)
            // En cualquier otro caso, lado3 es el mayor o hay empate entre varios
            else -> println(lado3)
        }
    }

    // Método para verificar si el triángulo es equilátero (los tres lados iguales)
    fun esEquilatero() {
        // Si los tres lados son iguales, es equilátero
        if (lado1 == lado2 && lado1 == lado3)
            print("Es un triángulo equilátero")
        else
        // Si no, se indica que no es equilátero
            print("No es un triángulo equilátero")
    }
}

// Función principal del programa
fun main(parametro: Array<String>) {
    // Se crea un objeto de tipo Triangulos con lados 12, 45 y 24
    val triangulo1 = Triangulos(12, 45, 24)

    // Se llama al método que muestra el lado mayor
    triangulo1.ladoMayor()

    // Se llama al método que indica si el triángulo es equilátero
    triangulo1.esEquilatero()
}
