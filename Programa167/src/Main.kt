class Dadoss() {
    val arreglo = IntArray(10)

    fun tirar() {
        for (i in arreglo.indices)
            arreglo[i] = ((Math.random() * 6) + 1).toInt()  // Genera números aleatorios entre 1 y 6
    }

    operator fun invoke(nro: Int): Int = arreglo[nro]  // Retorna el valor en el índice nro
}

fun main(args: Array<String>) {
    val dados = Dadoss()
    dados.tirar()  // Lanza los dados y llena el arreglo con números aleatorios entre 1 y 6

    // Accede a los valores de los dados usando el operador invoke
    println(dados(0))  // Muestra el valor en el primer dado
    println(dados(1))  // Muestra el valor en el segundo dado
    for (i in 2..9) {
        println(dados(i))  // Muestra los valores de los dados restantes
    }
}
