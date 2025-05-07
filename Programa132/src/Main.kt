// Se define un enum class llamado TipoOperacionn que representa los tipos de operaciones aritméticas
enum class TipoOperacionn (val tipo: String) {
    SUMA("+"),               // Operación de suma
    RESTA("-"),              // Operación de resta
    MULTIPLICACION("*"),     // Operación de multiplicación
    DIVISION("/")            // Operación de división
}

// Se define una clase Operacion que realiza una operación entre dos valores según el tipo de operación proporcionado
class Operacion (val valor1: Int, val valor2: Int, val tipoOperacion: TipoOperacionn) {

    // Método para realizar la operación
    fun operar() {
        var resultado: Int = 0   // Variable para almacenar el resultado de la operación

        // Se utiliza un bloque 'when' para elegir la operación basada en el tipoOperacion
        when (tipoOperacion) {
            TipoOperacionn.SUMA -> resultado = valor1 + valor2   // Suma
            TipoOperacionn.RESTA -> resultado = valor1 - valor2  // Resta
            TipoOperacionn.MULTIPLICACION -> resultado = valor1 * valor2  // Multiplicación
            TipoOperacionn.DIVISION -> resultado = valor1 / valor2   // División
        }

        // Imprime el resultado de la operación
        println("$valor1 ${tipoOperacion.tipo} $valor2 es igual a $resultado")
    }
}

// Función principal donde se crean varias instancias de la clase Operacion y se realizan las operaciones
fun main(parametro: Array<String>) {
    // Se crea una operación de suma entre 10 y 4
    val operacion1 = Operacion(10, 4, TipoOperacionn.SUMA)
    // Se crea una operación de resta entre 10 y 4
    val operacion2 = Operacion(10, 4, TipoOperacionn.RESTA)
    // Se crea una operación de multiplicación entre 10 y 4
    val operacion3 = Operacion(10, 4, TipoOperacionn.MULTIPLICACION)
    // Se crea una operación de división entre 10 y 4
    val operacion4 = Operacion(10, 4, TipoOperacionn.DIVISION)

    // Se llama al método operar para cada una de las operaciones creadas
    operacion1.operar()
    operacion2.operar()
    operacion3.operar()
    operacion4.operar()
}
