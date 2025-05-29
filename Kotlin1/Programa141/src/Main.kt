// Clase abstracta Cuenta: Define las propiedades y métodos comunes entre las cuentas
abstract class Cuenta(val titular: String, val monto: Double) {
    // Método para imprimir los detalles comunes de la cuenta
    open fun imprimir() {
        println("Titular: $titular")  // Imprime el nombre del titular
        println("Monto: $monto")      // Imprime el monto de la cuenta
    }
}

// Clase CajaAhorro: Hereda de Cuenta y representa una cuenta de ahorro
class CajaAhorro(titular: String, monto: Double): Cuenta(titular, monto) {
    // Sobrescribe el método imprimir() para mostrar los detalles específicos de una caja de ahorro
    override fun imprimir() {
        println("Cuenta de caja de ahorro")  // Indica que es una cuenta de ahorro
        super.imprimir()  // Llama al método imprimir() de la clase base para mostrar los detalles comunes
    }
}

// Clase PlazoFijo: Hereda de Cuenta y representa una cuenta de plazo fijo con un interés y un plazo de imposición
class PlazoFijo(titular: String, monto: Double, val plazo: Int, val interes: Double): Cuenta(titular, monto) {
    // Sobrescribe el método imprimir() para mostrar los detalles específicos de un plazo fijo
    override fun imprimir() {
        println("Cuenta de plazo fijo")  // Indica que es una cuenta de plazo fijo
        println("Plazo en dias: $plazo") // Muestra el plazo de imposición en días
        println("Intereses: $interes")  // Muestra la tasa de interés aplicada al monto

        // Calcula el interés generado en base al monto y la tasa de interés
        val ganancia = monto * interes / 100
        println("Importe del interes: $ganancia") // Muestra el importe del interés generado

        // Llama al método imprimir() de la clase base para mostrar los detalles comunes de la cuenta
        super.imprimir()
    }
}

// Función main: Aquí se crean los objetos de las cuentas y se muestran sus detalles
fun main(parametro: Array<String>) {
    // Se crea un objeto de la clase CajaAhorro
    val cajaAhorro1 = CajaAhorro("juan", 10000.0)
    cajaAhorro1.imprimir()  // Se imprime la información de la caja de ahorro

    // Se crea un objeto de la clase PlazoFijo
    val plazoFijo1 = PlazoFijo("Ana", 5000.0, 30, 1.23)
    plazoFijo1.imprimir()  // Se imprime la información del plazo fijo
}
