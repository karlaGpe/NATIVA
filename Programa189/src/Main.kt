// Función que genera un cartón de lotería con 6 números aleatorios entre 1 y 50
fun generarCarton(carton: MutableSet<Int>) {
    // Continuar generando números aleatorios hasta que el cartón tenga 6 números distintos
    do {
        // Generar un número aleatorio entre 1 y 50
        val valor = ((Math.random() * 50) + 1).toInt()
        // Añadir el número al cartón de lotería (si ya existe, no se añade por ser un set)
        carton.add(valor)
    } while (carton.size != 6) // Mientras el tamaño del set no sea 6, seguir generando números
}

// Función que genera un bolillero con los números del 1 al 50
fun generarBolillero(bolillero: MutableSet<Int>) {
    // Se añaden los números del 1 al 50 al bolillero
    do {
        val valor = ((Math.random() * 50) + 1).toInt()
        bolillero.add(valor) // Añadir el número al bolillero (si ya existe, no se añade por ser un set)
    } while (bolillero.size != 50) // Repetir hasta que el bolillero tenga todos los números de 1 a 50
}

// Función que simula el proceso de sortear bolillas y verifica cuántas se necesitan para completar el cartón
fun verificarTriunfo(carton: MutableSet<Int>, bolillero: MutableSet<Int>) {
    var aciertos = 0 // Contador de aciertos (números sorteados que están en el cartón)
    var cantBolillas = 0 // Contador de la cantidad de bolillas sorteadas
    var intentos = 0 // Número de bolillas necesarias para completar el cartón

    // Recorrer cada bolilla extraída del bolillero
    for (bolilla in bolillero) {
        cantBolillas++ // Aumentar el contador de bolillas sorteadas
        // Si la bolilla está en el cartón, incrementar los aciertos
        if (bolilla in carton) {
            aciertos++
            // Si se alcanzaron los 6 aciertos, finalizar el sorteo
            if (aciertos == 6) {
                intentos = cantBolillas
                break // Salir del ciclo ya que el cartón está completo
            }
        }
    }

    // Mostrar el número de bolillas sorteadas hasta completar el cartón
    println("Se sacaron $intentos bolillas hasta que el cartón ganó.")
}

fun main(args: Array<String>) {
    // Crear el cartón de lotería vacío
    val carton: MutableSet<Int> = mutableSetOf()
    // Llamar a la función para generar un cartón de lotería con 6 números aleatorios
    generarCarton(carton)
    println("Carton de lotería generado")
    println(carton) // Imprimir el cartón generado

    // Crear el bolillero vacío
    val bolillero: MutableSet<Int> = mutableSetOf()
    // Llamar a la función para generar un bolillero con los números del 1 al 50
    generarBolillero(bolillero)
    println("Numeros del bolillero")
    println(bolillero) // Imprimir los números del bolillero

    // Llamar a la función para verificar cuántas bolillas se sacaron hasta completar el cartón
    verificarTriunfo(carton, bolillero)
}
