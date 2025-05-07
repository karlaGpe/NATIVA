// Función para cargar los sueldos en un arreglo
fun cargar(): IntArray {
    // Pedimos al usuario la cantidad de sueldos que desea ingresar
    print("¿Cuántos sueldos quiere cargar?:")
    val cantidad = readLine()!!.toInt()  // Leemos el valor ingresado y lo convertimos a entero

    // Creamos un arreglo de enteros con la cantidad especificada por el usuario
    val sueldos = IntArray(cantidad)

    // Bucle para cargar los sueldos en el arreglo
    for(i in sueldos.indices) {
        print("Ingrese sueldo:")  // Pedimos el valor del sueldo
        sueldos[i] = readLine()!!.toInt()  // Leemos y asignamos cada sueldo al arreglo
    }
    return sueldos  // Retornamos el arreglo con los sueldos cargados
}

// Función para imprimir todos los sueldos del arreglo
fun imprimir(sueldos: IntArray) {
    println("Listado de todos los sueldos")  // Imprimimos un título
    // Recorremos el arreglo y mostramos cada sueldo
    for(sueldo in sueldos)
        println(sueldo)  // Imprimimos cada elemento del arreglo (sueldo)
}

fun main(parametro: Array<String>) {
    // Llamamos a la función cargar para obtener los sueldos
    val sueldos = cargar()

    // Llamamos a la función imprimir para mostrar los sueldos
    imprimir(sueldos)
}
