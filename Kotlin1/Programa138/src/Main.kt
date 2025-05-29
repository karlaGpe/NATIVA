// Clase base 'Calculadora', que tiene operaciones básicas como sumar, restar, multiplicar y dividir
open class Calculadora(val valor1: Double, val valor2: Double) {
    var resultado: Double = 0.0 // Variable para almacenar el resultado de las operaciones

    // Método para sumar los dos valores
    fun sumar() {
        resultado = valor1 + valor2 // Almacena la suma de los valores en la variable 'resultado'
    }

    // Método para restar el segundo valor del primero
    fun restar() {
        resultado = valor1 - valor2 // Almacena la resta de los valores en 'resultado'
    }

    // Método para multiplicar los dos valores
    fun multiplicar() {
        resultado = valor1 * valor2 // Almacena el producto de los valores en 'resultado'
    }

    // Método para dividir el primer valor por el segundo
    fun dividir() {
        resultado = valor1 / valor2 // Almacena el cociente de los valores en 'resultado'
    }

    // Método para imprimir el resultado de la operación
    fun imprimir() {
        println("Resultado: $resultado") // Imprime el valor almacenado en 'resultado'
    }
}

// Clase derivada 'CalculadoraCientifica' que hereda de 'Calculadora' y añade funcionalidades científicas
class CalculadoraCientifica(valor1: Double, valor2: Double): Calculadora(valor1, valor2) {
    // Método para calcular el cuadrado del primer valor
    fun cuadrado() {
        resultado = valor1 * valor1 // Almacena el cuadrado de 'valor1' en 'resultado'
    }

    // Método para calcular la raíz cuadrada del primer valor
    fun raiz() {
        resultado = Math.sqrt(valor1) // Almacena la raíz cuadrada de 'valor1' en 'resultado'
    }
}

// Función principal donde se crean las instancias de las calculadoras y se prueban sus métodos
fun main(parametro: Array<String>) {
    // Se crea una instancia de la clase 'Calculadora' con los valores 10.0 y 2.0
    println("Prueba de la clase Calculadora (suma de dos números)")
    val calculadora1 = Calculadora(10.0, 2.0)
    calculadora1.sumar()  // Realiza la suma de los valores
    calculadora1.imprimir()  // Imprime el resultado de la suma

    // Se crea una instancia de la clase 'CalculadoraCientifica' con los valores 10.0 y 2.0
    println("Prueba de la clase Calculadora Científica (suma de dos números y el cuadrado y la raíz del primero)")
    val calculadoraCientifica1 = CalculadoraCientifica(10.0, 2.0)
    calculadoraCientifica1.sumar()  // Realiza la suma de los valores
    calculadoraCientifica1.imprimir()  // Imprime el resultado de la suma

    calculadoraCientifica1.cuadrado()  // Realiza el cálculo del cuadrado de 10.0
    calculadoraCientifica1.imprimir()  // Imprime el resultado del cuadrado

    calculadoraCientifica1.raiz()  // Realiza el cálculo de la raíz cuadrada de 10.0
    calculadoraCientifica1.imprimir()  // Imprime el resultado de la raíz cuadrada
}
