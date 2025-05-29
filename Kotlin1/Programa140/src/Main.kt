// Clase abstracta Operacionn, que define la estructura básica para las operaciones
abstract class Operacionn(val valor1: Int, val valor2: Int) {
    protected var resultado: Int = 0  // Variable protegida para almacenar el resultado de la operación

    // Método abstracto operar() que debe ser implementado por las clases derivadas
    abstract fun operar()

    // Método imprimir() para mostrar el resultado de la operación
    fun imprimir() {
        println("Resultado: $resultado")
    }
}

// Clase Suma que hereda de Operacionn y realiza una operación de suma
class Suma(valor1: Int, valor2: Int): Operacionn(valor1, valor2) {
    // Implementación del método abstracto operar() que realiza la suma
    override fun operar() {
        resultado = valor1 + valor2
    }
}

// Clase Resta que hereda de Operacionn y realiza una operación de resta
class Resta(valor1: Int, valor2: Int): Operacionn(valor1, valor2) {
    // Implementación del método abstracto operar() que realiza la resta
    override fun operar() {
        resultado = valor1 - valor2
    }
}

// Función principal
fun main(parametro: Array<String>) {
    // Crear una instancia de Suma y realizar la operación
    val suma1 = Suma(10, 4)
    suma1.operar()  // Llamar al método operar para hacer la suma
    suma1.imprimir()  // Mostrar el resultado de la operación

    // Crear una instancia de Resta y realizar la operación
    val resta1 = Resta(20, 5)
    resta1.operar()  // Llamar al método operar para hacer la resta
    resta1.imprimir()  // Mostrar el resultado de la operación
}
