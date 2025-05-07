// PROBLEMA PROPUESTO 180
/*
Cargar por teclado y almacenar en una lista inmutable las alturas de 5 personas (valores Float).
Obtener el promedio de las mismas. Contar cuántas personas son más altas que el promedio y cuántas más bajas.
*/

// Función que solicita al usuario una altura y la devuelve como Float
fun cargaaar(): Float {
    print("Ingrese la altura de la persona (Ej. 1.92): ")
    val valor = readln().toFloat()
    return valor
}

fun main(args: Array<String>) {
    // Lista inmutable de 5 alturas ingresadas por el usuario
    val lista1: List<Float> = List(5) { cargaaar() }

    // Cálculo del promedio (average devuelve Double, lo convertimos a Float si queremos consistencia)
    val promedio = lista1.average().toFloat()
    println("La altura promedio de las personas es: $promedio")

    // Contamos cuántas personas tienen altura mayor y menor al promedio
    val altos = lista1.count { it > promedio }
    val bajos = lista1.count { it < promedio }

    println("La cantidad de personas más altas que el promedio es: $altos")
    println("La cantidad de personas más bajas que el promedio es: $bajos")
}
