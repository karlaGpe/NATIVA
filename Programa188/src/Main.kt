// Definimos la clase Fechaa para representar una fecha con día, mes y año
data class Fechaa(val dia: Int, val mes: Int, val año: Int)

fun main(args: Array<String>) {
    // Creamos un conjunto (Set) de fechas feriadas, en este caso con dos fechas: 1 de enero y 25 de diciembre de 2017
    var feriados: Set<Fechaa> = setOf(Fechaa(1, 1, 2017),
        Fechaa(25, 12, 2017))

    // Le pedimos al usuario que ingrese una fecha
    println("Ingrese una fecha")
    print("Ingrese el día:")  // Solicita el día
    val dia = readLine()!!.toInt()  // Lee el valor del día como entero
    print("Ingrese el mes:")  // Solicita el mes
    val mes = readLine()!!.toInt()  // Lee el valor del mes como entero
    print("Ingrese el año:")  // Solicita el año
    val año = readLine()!!.toInt()  // Lee el valor del año como entero

    // Comprobamos si la fecha ingresada está en el conjunto de feriados
    if (Fechaa(dia, mes, año) in feriados) {
        println("La fecha ingresada es feriado")  // Si la fecha está en el conjunto de feriados, mostramos que es feriado
    } else {
        println("La fecha ingresada no es feriado")  // Si la fecha no está en el conjunto de feriados, mostramos que no es feriado
    }
}
