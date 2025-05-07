// PROBLEMA PROPUESTO 127
/* Plantear una clase llamada Dado.
   Definir una propiedad llamada valor que permita cargar un valor comprendido entre 1 y 6.
   Si llega un valor que no está comprendido en este rango, se debe cargar un 1.
   Definir dos métodos:
   - Uno que genere un número aleatorio entre 1 y 6.
   - Otro que lo imprima.
   Al constructor llega el valor inicial que debe tener el dado (tratar de enviarle el número 7).
*/

// Definición de la clase Dado4
class Dado4(valor: Int) {

    // Propiedad 'valor' con validación en el setter
    var valor: Int = 1
        set(valor) {
            // Solo se acepta el valor si está entre 1 y 6
            if (valor >= 1 && valor <= 6)
                field = valor
            else
                field = 1 // Si es inválido, se asigna 1 por defecto
        }

    // Bloque init: se ejecuta al crear una instancia de la clase
    init {
        // Se asigna el valor inicial al dado utilizando el setter (lo valida)
        this.valor = valor
    }

    // Método para "tirar" el dado: asigna un valor aleatorio entre 1 y 6
    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    // Método para imprimir el valor actual del dado
    fun imprimir() = println("Valor del dado: $valor")
}

// Función principal para probar la clase
fun main(parametro: Array<String>) {
    val dado1 = Dado4(7) // Se le pasa el número 7, fuera del rango válido
    dado1.imprimir()     // Debería imprimir 1 por la validación
    dado1.tirar()        // Se tira el dado y se genera un número aleatorio entre 1 y 6
    dado1.imprimir()     // Se imprime el nuevo valor aleatorio
}
