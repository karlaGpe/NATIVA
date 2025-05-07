// PROBLEMA PROPUESTO 103
/*
Desarrollar un programa que permita ingresar un arreglo de 8 elementos enteros, e informe:
- El valor acumulado de todos los elementos.
- El valor acumulado de los elementos que sean mayores a 36.
- Cantidad de valores mayores a 50.
(Definir dos for, en el primero realizar la carga y en el segundo proceder a analizar cada elemento)
*/

fun main(parametro: Array<String>) {
    // Declaramos un arreglo de 8 enteros
    val arreglo = IntArray(8)

    // Primer bucle: carga de los elementos por teclado
    for(i in arreglo.indices) {
        print("Ingrese elemento: ")
        arreglo[i] = readln().toInt() // Leemos y convertimos a entero cada valor
    }

    // Variables auxiliares para las estadísticas solicitadas
    var suma = 0             // Acumulador total
    var sumaMayor36 = 0      // Acumulador de valores mayores a 36
    var cantMayor50 = 0      // Contador de valores mayores a 50

    // Segundo bucle: análisis de los valores
    for(elemento in arreglo) {
        suma += elemento // Sumar todos los elementos

        if (elemento > 36)        // Verifica si el valor es mayor a 36
            sumaMayor36 += elemento

        if (elemento > 50)        // Verifica si el valor es mayor a 50
            cantMayor50++
    }

    // Mostrar resultados
    println("Valor acumulado del arreglo: $suma")
    println("Valor acumulado de los elementos mayores a 36: $sumaMayor36")
    println("Cantidad de elementos mayores a 50: $cantMayor50")
}
