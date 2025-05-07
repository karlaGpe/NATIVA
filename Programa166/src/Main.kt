class TaTeTi {
    val tablero = IntArray(9)  // El tablero se representa como un arreglo de 9 celdas

    // Imprime el tablero
    fun imprimir() {
        for (fila in 0..2) {
            for (columna in 0..2)
                print("${this[fila, columna]} ")
            println()
        }
        println()
    }

    // Operador set para colocar un valor en la fila y columna especificadas
    operator fun set(fila: Int, columna: Int, valor: Int) {
        tablero[fila * 3 + columna] = valor
    }

    // Operador get para obtener el valor de la fila y columna especificadas
    operator fun get(fila: Int, columna: Int): Int {
        return tablero[fila * 3 + columna]
    }

    // Función para verificar si hay un ganador
    fun verificarGanador(): Int {
        // Combinaciones ganadoras en un tablero 3x3 (índices de las celdas)
        val combinaciones = arrayOf(
            arrayOf(0, 1, 2), // Primera fila
            arrayOf(3, 4, 5), // Segunda fila
            arrayOf(6, 7, 8), // Tercera fila
            arrayOf(0, 3, 6), // Primera columna
            arrayOf(1, 4, 7), // Segunda columna
            arrayOf(2, 5, 8), // Tercera columna
            arrayOf(0, 4, 8), // Diagonal
            arrayOf(2, 4, 6)  // Diagonal
        )

        // Comprobamos cada combinación ganadora
        for (combinacion in combinaciones) {
            val (a, b, c) = combinacion
            if (tablero[a] != 0 && tablero[a] == tablero[b] && tablero[a] == tablero[c]) {
                return tablero[a]  // Retorna el jugador ganador (1 o 2)
            }
        }
        return 0  // Si no hay ganador
    }

    // Función para verificar si el tablero está lleno (empate)
    fun verificarEmpate(): Boolean {
        return !tablero.contains(0)  // Si no hay celdas vacías, es empate
    }
}

fun main(args: Array<String>) {
    val juego = TaTeTi()

    // Movimientos del juego (jugador 1 usa "1" y jugador 2 usa "2")
    juego[0, 0] = 1
    juego[0, 2] = 2
    juego[2, 0] = 1
    juego[1, 2] = 2
    juego[1, 0] = 1
    juego.imprimir()  // Mostrar el estado del tablero

    // Verificar si hay un ganador o empate
    val ganador = juego.verificarGanador()
    if (ganador != 0) {
        println("El ganador es el jugador $ganador")
    } else if (juego.verificarEmpate()) {
        println("El juego ha terminado en empate")
    } else {
        println("El juego continúa")
    }
}
