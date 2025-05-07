// Función para cargar el arreglo con elementos proporcionados por el usuario
fun cargarA(): IntArray {
    print("¿Cuántos elementos tendrá el arreglo?:")
    val cantidad = readln().toInt()  // Leemos el tamaño del arreglo
    val arreglo = IntArray(cantidad)  // Creamos un arreglo de la cantidad de elementos
    for(i in arreglo.indices) {
        print("Ingrese elemento:")  // Pedimos al usuario ingresar cada valor
        arreglo[i] = readln().toInt()  // Leemos y asignamos el valor al arreglo
    }
    return arreglo  // Retornamos el arreglo cargado
}

// Función para imprimir el contenido del arreglo
fun imprimirA(arreglo: IntArray) {
    println("Listado completo del arreglo")
    for(elemento in arreglo)
        println(elemento)  // Imprimimos cada valor del arreglo
}

// Función para encontrar el menor valor del arreglo
fun menor(arreglo: IntArray): Int {
    var men = arreglo[0]  // Inicializamos con el primer elemento
    for(elemento in arreglo) {
        if (elemento < men)  // Comparamos y actualizamos el menor valor
            men = elemento
    }
    return men  // Retornamos el menor valor encontrado
}

// Función para verificar si el valor se repite en el arreglo
fun repite(arreglo: IntArray, buscar: Int): Boolean {
    var cant = 0  // Contador de ocurrencias del valor
    for(elemento in arreglo) {
        if (elemento == buscar)  // Si encontramos el valor
            cant++
    }
    return cant > 1  // Si ocurre más de una vez, retorna true
}

fun main(parametro: Array<String>) {
    val arreglo = cargarA()  // Cargamos el arreglo
    imprimirA(arreglo)  // Imprimimos el arreglo

    val menorElemento = menor(arreglo)  // Encontramos el menor valor del arreglo
    println("El elemento menor es $menorElemento")  // Imprimimos el menor valor

    if (repite(arreglo, menorElemento))  // Verificamos si el menor valor se repite
        println("Se repite el menor en el arreglo")
    else
        println("No se repite el menor en el arreglo")
}
