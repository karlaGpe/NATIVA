// Definición de la clase Triangulo2 con un constructor primario que recibe tres lados
class Triangulo2 (var lado1: Int, var lado2: Int, var lado3: Int){

    // Constructor secundario sin parámetros, que pide los valores por teclado
    constructor():this(0, 0, 0) { // Se llama al constructor principal con valores por defecto
        // Solicita al usuario que ingrese el valor del primer lado
        print("Ingrese primer lado:")
        lado1 = readLine()!!.toInt()
        // Solicita el segundo lado
        print("Ingrese segundo lado:")
        lado2 = readLine()!!.toInt()
        // Solicita el tercer lado
        print("Ingrese tercer lado:")
        lado3 = readLine()!!.toInt()
    }

    // Método que muestra cuál de los tres lados es el mayor
    fun ladoMayor() {
        print("Lado mayor:")
        when {
            // Si lado1 es mayor que lado2 y lado3, se imprime lado1
            lado1 > lado2 && lado1 > lado3 -> println(lado1)
            // Si no, se compara lado2 con lado3
            lado2 > lado3 -> println(lado2)
            // Si ninguno de los anteriores, lado3 es el mayor (o hay empate)
            else -> println(lado3)
        }
    }

    // Método que indica si el triángulo es equilátero
    fun esEquilatero() {
        // Si los tres lados son iguales, se informa que es equilátero
        if (lado1 == lado2 && lado1 == lado3)
            println("Es un triángulo equilátero")
        else
        // Caso contrario, no lo es
            println("No es un triángulo equilátero")
    }
}

// Función principal del programa
fun main(parametro: Array<String>) {
    // Se crea un objeto de Triangulo2 usando el constructor sin parámetros (solicita datos por teclado)
    val triangulo1 = Triangulo2()
    // Se muestra el lado mayor del primer triángulo
    triangulo1.ladoMayor()
    // Se indica si el primer triángulo es equilátero
    triangulo1.esEquilatero()

    // Se crea un segundo objeto con lados predefinidos (6, 6, 6)
    val triangulo2 = Triangulo2(6, 6, 6)
    // Se muestra el lado mayor del segundo triángulo
    triangulo2.ladoMayor()
    // Se indica si el segundo triángulo es equilátero
    triangulo2.esEquilatero()
}
