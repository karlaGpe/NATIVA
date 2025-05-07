// Clase Dado0 que representa un dado con un valor del 1 al 6
class Dado0(var valor: Int = 1) {

    // Método que simula lanzar el dado, generando un valor aleatorio entre 1 y 6
    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    // Método para imprimir el valor actual del dado
    fun imprimir() {
        println("Valor del dado: $valor")
    }
}

// Función principal donde se ejecuta la lógica del programa
fun main(parametro: Array<String>) {

    // Crear un arreglo de 5 objetos Dado0
    var dados: Array<Dado0> = arrayOf(Dado0(), Dado0(), Dado0(), Dado0(), Dado0())

    // Lanzar cada uno de los 5 dados
    for (dado in dados)
        dado.tirar()

    // Imprimir el valor de cada dado después de tirarlo
    for (dado in dados)
        dado.imprimir()

    // Variables para contar cuántas veces sale cada número del 1 al 6
    var cant1 = 0
    var cant2 = 0
    var cant3 = 0
    var cant4 = 0
    var cant5 = 0
    var cant6 = 0

    // Contar los valores obtenidos en los dados
    dados.forEach {
        when (it.valor) {
            1 -> cant1++
            2 -> cant2++
            3 -> cant3++
            4 -> cant4++
            5 -> cant5++
            6 -> cant6++
        }
    }

    // Imprimir la cantidad de veces que salió cada número
    println("Cantidad de dados que tienen el valor 1: $cant1")
    println("Cantidad de dados que tienen el valor 2: $cant2")
    println("Cantidad de dados que tienen el valor 3: $cant3")
    println("Cantidad de dados que tienen el valor 4: $cant4")
    println("Cantidad de dados que tienen el valor 5: $cant5")
    println("Cantidad de dados que tienen el valor 6: $cant6")
}
