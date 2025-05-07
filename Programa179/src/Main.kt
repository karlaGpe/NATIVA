// PROBLEMA PROPUESTO 179
/*
Confeccionar una clase que represente un Empleado.
Definir como propiedades su nombre y su sueldo.
Definir una lista mutable con tres empleados.
Imprimir los datos de los empleados.
Calcular cuánto gasta la empresa en sueldos.
Agregar un nuevo empleado a la lista y calcular nuevamente el gasto en sueldos.
*/

// Definimos la clase Empleado0 con dos propiedades: nombre y sueldo
class Empleado0(var nombre: String, var sueldo: Double) {

    // Método para imprimir los datos del empleado
    fun imprimir() {
        println("$nombre tiene un sueldo de $sueldo")
    }
}

// Función para calcular el gasto total en sueldos
fun calcularGastos(empleados: MutableList<Empleado0>) {
    // sumByDouble suma todos los sueldos de la lista
    val suma = empleados.sumByDouble { it.sueldo }
    println("Total de gastos de la empresa: $suma")
}

fun main(args: Array<String>) {
    // Creamos una lista mutable con tres empleados
    val empleados: MutableList<Empleado0> = mutableListOf(
        Empleado0("Juan", 2000.0),
        Empleado0("Ana", 3500.0),
        Empleado0("Carlos", 1500.0)
    )

    // Imprimimos los datos de todos los empleados
    empleados.forEach { it.imprimir() }

    // Calculamos el gasto total de sueldos
    calcularGastos(empleados)

    // Agregamos un nuevo empleado a la lista
    empleados.add(Empleado0("Marcos", 3000.0))
    println("Gastos luego de ingresar un nuevo empleado que cobra 3000")

    // Volvemos a calcular el gasto total
    calcularGastos(empleados)
}
