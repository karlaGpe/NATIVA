// Definición de la clase Punto, que representa una coordenada en el plano con valores x e y
class Punto (val x: Int, val y: Int) {

    // Método que retorna un String indicando en qué cuadrante se encuentra el punto
    fun retornarCuadrante() = when {
        x > 0 && y > 0 -> "Primer cuadrante"       // Si x > 0 y y > 0 -> 1º cuadrante
        x < 0 && y > 0 -> "Segundo cuadrante"      // Si x < 0 y y > 0 -> 2º cuadrante
        x < 0 && y < 0 -> "Tercer cuadrante"       // Si x < 0 y y < 0 -> 3º cuadrante
        x > 0 && y < 0 -> "Cuarto cuadrante"       // Si x > 0 y y < 0 -> 4º cuadrante
        else -> "Un eje"                           // Si x == 0 o y == 0 -> el punto está sobre un eje
    }
}

// Función principal del programa
fun main(parametro: Array<String>) {
    // Punto en el primer cuadrante
    val punto1 = Punto(12, 3)
    println("La coordenada ${punto1.x}, ${punto1.y} se encuentra en ${punto1.retornarCuadrante()}")

    // Punto en el segundo cuadrante
    val punto2 = Punto(-4, 3)
    println("La coordenada ${punto2.x}, ${punto2.y} se encuentra en ${punto2.retornarCuadrante()}")

    // Punto en el tercer cuadrante
    val punto3 = Punto(-2, -2)
    println("La coordenada ${punto3.x}, ${punto3.y} se encuentra en ${punto3.retornarCuadrante()}")

    // Punto en el cuarto cuadrante
    val punto4 = Punto(12, -5)
    println("La coordenada ${punto4.x}, ${punto4.y} se encuentra en ${punto4.retornarCuadrante()}")

    // Punto sobre un eje (x == 0)
    val punto5 = Punto(0, -5)
    println("La coordenada ${punto5.x}, ${punto5.y} se encuentra en ${punto5.retornarCuadrante()}")
}
