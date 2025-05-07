// Clase que representa un Cliente con su nombre y monto
class Cliente(var nombre: String, var monto: Float) {
    // Método para depositar dinero en la cuenta del cliente
    fun depositar(monto: Float) {
        this.monto += monto  // Aumenta el monto del cliente por el valor depositado
    }

    // Método para extraer dinero de la cuenta del cliente
    fun extraer(monto: Float) {
        this.monto -= monto  // Disminuye el monto del cliente por el valor extraído
    }

    // Método para imprimir el estado de la cuenta del cliente
    fun imprimir() {
        println("$nombre tiene depositado la suma de $monto")  // Muestra el nombre del cliente y su saldo
    }
}

// Clase que representa un Banco que tiene clientes y realiza operaciones bancarias
class Banco {
    // Creación de tres objetos Cliente con nombre y saldo inicial de 0
    val cliente1: Cliente = Cliente("Juan", 0f)
    var cliente2: Cliente = Cliente("Ana", 0f)
    var cliente3: Cliente = Cliente("Luis", 0f)

    // Método que realiza operaciones bancarias para los clientes
    fun operar() {
        // Realiza los depósitos de dinero en las cuentas de los clientes
        cliente1.depositar(100f)  // Juan deposita 100
        cliente2.depositar(150f)  // Ana deposita 150
        cliente3.depositar(200f)  // Luis deposita 200
        cliente3.extraer(150f)    // Luis extrae 150 de su cuenta
    }

    // Método que calcula y muestra el total de los depósitos en el banco
    fun depositosTotales() {
        // Calcula el total de dinero en el banco sumando los saldos de los tres clientes
        val total = cliente1.monto + cliente2.monto + cliente3.monto
        println("El total de dinero del banco es: $total")  // Imprime el total de dinero en el banco

        // Imprime los saldos individuales de cada cliente
        cliente1.imprimir()  // Muestra el saldo de Juan
        cliente2.imprimir()  // Muestra el saldo de Ana
        cliente3.imprimir()  // Muestra el saldo de Luis
    }
}

// Función principal que ejecuta las operaciones del banco
fun main(parametro: Array<String>) {
    val banco1 = Banco()  // Crea un objeto Banco
    banco1.operar()       // Realiza las operaciones de depósito y extracción
    banco1.depositosTotales()  // Muestra el total de dinero en el banco y los saldos de los clientes
}
