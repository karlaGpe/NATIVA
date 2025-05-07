// PROBLEMA PROPUESTO 126
/* Confeccionar una clase que represente un Empleado.
   Definir como propiedades su nombre y su sueldo.
   No permitir que se cargue un valor negativo en su sueldo.
   Codificar el método imprimir en la clase.
*/

// Definición de la clase Empleado
class Empleado(var nombre: String, sueldo: Double) {

    // Propiedad 'sueldo' con setter personalizado para evitar valores negativos
    var sueldo: Double = 0.0
        set(valor) {
            // Si el sueldo es negativo, se asigna 0.0
            if (valor < 0)
                field = 0.0
            else
                field = valor
        }

    // Bloque init que se ejecuta al crear el objeto
    init {
        // Se usa el setter para validar el sueldo al crear el objeto
        this.sueldo = sueldo
    }

    // Método para imprimir los datos del empleado
    fun imprimir() {
        println("$nombre tiene un sueldo de $sueldo")
    }
}

// Función principal
fun main(parametro: Array<String>) {
    val empleado1 = Empleado("Juan", 12000.50) // Sueldo válido
    empleado1.imprimir() // Imprime: Juan tiene un sueldo de 12000.5

    val empleado2 = Empleado("Ana", -1200.0) // Sueldo negativo, se ajusta a 0.0
    empleado2.imprimir() // Imprime: Ana tiene un sueldo de 0.0
}
