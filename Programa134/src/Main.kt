// Definición de un objeto llamado 'Matematica' que contiene constantes y funciones relacionadas con matemáticas
object Matematica {
    // Propiedad constante que almacena el valor de PI
    val PI = 3.1416

    // Función 'aleatorio' que recibe un valor mínimo y un valor máximo, y genera un número aleatorio en ese rango
    fun aleatorio(minimo: Int, maximo: Int) =
        // Math.random() genera un número aleatorio entre 0 y 1, que se escala al rango entre 'minimo' y 'maximo'
        ((Math.random() * (maximo + 1 - minimo)) + minimo).toInt()  // Convierte el número aleatorio a un valor entero
}

// Función principal
fun main(parametro: Array<String>) {
    // Imprime el valor de PI usando la propiedad del objeto 'Matematica'
    println("El valor de Pi es ${Matematica.PI}")

    // Imprime un mensaje seguido de un número aleatorio entre 5 y 10 usando la función 'aleatorio' del objeto 'Matematica'
    print("Un valor aleatorio entre 5 y 10: ")
    println(Matematica.aleatorio(5, 10))
}
