// Definimos la clase Dado2 que simula el lanzamiento de un dado
class Dado2 {
    // Variable privada que almacena el valor actual del dado
    private var valor: Int = 1

    // Método que simula el lanzamiento del dado
    fun tirar() {
        // Genera un número aleatorio entre 1 y 6 (inclusive)
        valor = ((Math.random() * 6) + 1).toInt()
    }

    // Método para imprimir el valor actual del dado
    fun imprimir() {
        // Imprime un separador visual
        separador()
        // Muestra el valor del dado
        println("Valor del dado: $valor")
        // Imprime otro separador visual
        separador()
    }

    // Método privado que imprime una línea separadora
    private fun separador() = println("**************************************")
}

// Función principal del programa
fun main(parametro: Array<String>) {
    // Crea una instancia del dado
    val dado1 = Dado2()
    // Lanza el dado (genera un número aleatorio entre 1 y 6)
    dado1.tirar()
    // Imprime el valor del dado
    dado1.imprimir()
}
