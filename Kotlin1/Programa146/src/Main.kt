// Definición de la clase Dadoo, que tiene una propiedad valor que guarda el valor del dado
class Dadoo(var valor: Int = 1) { // Valor inicial del dado es 1

    // Método para simular tirar el dado, generando un número aleatorio entre 1 y 6
    fun tirar() {
        // Math.random() genera un valor entre 0 y 1, multiplicado por 6 y sumado 1 para obtener un rango entre 1 y 6
        valor = ((Math.random() * 6) + 1).toInt() // El valor es convertido a entero
    }

    // Método para imprimir el valor actual del dado
    fun imprimir() {
        println("Valor del dado: $valor")
    }
}

// Función principal donde se crean los dados, se tiran y se imprimen sus valores
fun main(parametro: Array<String>) {
    // Crear un array de 5 objetos Dadoo
    var dados: Array<Dadoo> = arrayOf(Dadoo(), Dadoo(), Dadoo(), Dadoo(), Dadoo())

    // Tirar todos los dados, es decir, asignarles un valor aleatorio
    for (dado in dados)
        dado.tirar() // Llama al método tirar() de cada dado para asignar un nuevo valor aleatorio

    // Imprimir los valores obtenidos de cada dado
    for (dado in dados)
        dado.imprimir() // Llama al método imprimir() de cada dado para mostrar su valor
}
