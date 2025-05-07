// Definición de la clase Fecha que contiene día, mes y año
data class Fecha(val dia: Int, val mes: Int, val año: Int)

// Función para cargar datos en la agenda
fun cargar(agenda: MutableMap<Fecha, String>) {
    do {
        // Solicita la fecha al usuario
        println("Ingrese fecha")
        print("Ingrese el día:")
        val dia = readln().toInt() // Lee el día de la fecha
        print("Ingrese el mes:")
        val mes = readln().toInt() // Lee el mes de la fecha
        print("Ingrese el año:")
        val año = readln().toInt() // Lee el año de la fecha

        // Solicita las actividades correspondientes a esa fecha
        print("Ingrese todas las actividades para ese día:")
        val actividades = readln() // Lee las actividades

        // Almacena las actividades en el mapa de agenda usando la fecha como clave
        agenda[Fecha(dia, mes, año)] = actividades

        // Pregunta al usuario si quiere continuar ingresando más fechas
        print("Ingrese otra fecha (si/no):")
        val opcion = readln() // Lee la opción para continuar

    } while (opcion == "si") // Continúa el ciclo si la opción es "si"
}

// Función para imprimir el listado completo de la agenda
fun imprimir(agenda: MutableMap<Fecha, String>) {
    // Recorre el mapa de agenda e imprime cada fecha y sus actividades
    for((fecha, actividad) in agenda) {
        println("Fecha ${fecha.dia}/${fecha.mes}/${fecha.año}") // Muestra la fecha
        println("Actividades: $actividad") // Muestra las actividades del día
        println() // Imprime una línea en blanco para separar los resultados
    }
}

// Función para consultar las actividades de una fecha específica
fun consultaFecha(agenda: MutableMap<Fecha, String>) {
    // Solicita la fecha a consultar
    println("Ingrese una fecha a consultar")
    print("Ingrese el día:")
    val dia = readln().toInt() // Lee el día
    print("Ingrese el mes:")
    val mes = readln().toInt() // Lee el mes
    print("Ingrese el año:")
    val año = readln().toInt() // Lee el año

    // Crea un objeto Fecha con los valores ingresados
    val fecha = Fecha(dia, mes, año)

    // Verifica si la fecha existe en la agenda
    if (fecha in agenda) {
        println("Actividades: ${agenda[fecha]}") // Muestra las actividades de la fecha
    } else {
        println("No existen actividades registradas para dicha fecha") // Mensaje de error si la fecha no existe
    }
}

// Función principal donde se orquesta todo el programa
fun main(args: Array<String>) {
    // Creamos un mapa mutable para la agenda donde la clave es la fecha y el valor es un String de actividades
    val agenda: MutableMap<Fecha, String> = mutableMapOf()

    // Llamamos a la función cargar para ingresar las actividades
    cargar(agenda)

    // Llamamos a la función imprimir para mostrar el listado completo de la agenda
    imprimir(agenda)

    // Llamamos a la función consultaFecha para permitir la consulta de actividades por fecha
    consultaFecha(agenda)
}
