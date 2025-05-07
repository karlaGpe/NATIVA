// Se define un enum class llamado TipoCarta que representa los diferentes tipos de cartas
enum class TipoCarta{
    DIAMANTE,   // Tipo de carta DIAMANTE
    TREBOL,     // Tipo de carta TREBOL
    CORAZON,    // Tipo de carta CORAZON
    PICA        // Tipo de carta PICA
}

// Se define una clase Carta que tiene dos propiedades: tipo y valor
class Carta(val tipo: TipoCarta, val valor: Int) {

    // Método para imprimir la carta en formato adecuado
    fun imprimir() {
        println("Carta: $tipo y su valor es $valor")  // Imprime el tipo de carta y su valor
    }
}

// Función principal
fun main(parametro: Array<String>) {
    val carta1 = Carta(TipoCarta.TREBOL, 4)  // Se crea una instancia de Carta con tipo TREBOL y valor 4
    carta1.imprimir()  // Se llama al método imprimir para mostrar la carta creada
}
