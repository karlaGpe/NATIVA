// Se define un data class llamado Dados con una única propiedad llamada 'valor'
data class Dados (var valor: Int) {

    // Se sobrescribe el método toString para personalizar la salida al imprimir el objeto
    override fun toString(): String {
        var cadena = ""  // Se declara una variable para construir la cadena de asteriscos
        for(i in 1..valor)  // Se repite el ciclo desde 1 hasta el valor almacenado
            cadena = cadena + "*"  // Se añade un asterisco por cada iteración
        return cadena  // Se retorna la cadena resultante
    }
}

// Función principal
fun main(parametro: Array<String>) {
    val dado1 = Dados(4)  // Se crea un dado con valor 4
    val dado2 = Dados(6)  // Se crea un dado con valor 6
    val dado3 = Dados(1)  // Se crea un dado con valor 1
    println(dado1)  // Se imprime el dado1 → ****
    println(dado2)  // Se imprime el dado2 → ******
    println(dado3)  // Se imprime el dado3 → *
}
