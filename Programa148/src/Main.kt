// Definición de la clase Personaa que tiene nombre y edad
class Personaa(val nombre: String, val edad: Int) {

    // Método esMayor que recibe una función fn como parámetro para determinar si una persona es mayor de edad
    fun esMayor(fn: (Int) -> Boolean): Boolean {
        return fn(edad)  // Llama a la función fn con la edad de la persona y devuelve el resultado
    }
}

// Función para determinar si una persona es mayor de edad en Estados Unidos (mayoría de edad a los 21 años)
fun mayorEstadosUnidos(edad: Int): Boolean {
    if (edad >= 21)
        return true  // Si la edad es mayor o igual a 21, la persona es mayor en Estados Unidos
    else
        return false  // Si no, la persona no es mayor en Estados Unidos
}

// Función para determinar si una persona es mayor de edad en Argentina (mayoría de edad a los 18 años)
fun mayorArgentina(edad: Int): Boolean {
    if (edad >= 18)
        return true  // Si la edad es mayor o igual a 18, la persona es mayor en Argentina
    else
        return false  // Si no, la persona no es mayor en Argentina
}

fun main(parametro: Array<String>) {
    // Se crea una instancia de Personaa con nombre "juan" y edad 18
    val persona1 = Personaa("juan", 18)

    // Se verifica si la persona es mayor de edad en Argentina
    if (persona1.esMayor(::mayorArgentina))
        println("${persona1.nombre} es mayor si vive en Argentina")  // Si la persona es mayor según la ley argentina, se imprime
    else
        println("${persona1.nombre} no es mayor si vive en Argentina")  // Si no, se imprime lo contrario

    // Se verifica si la persona es mayor de edad en Estados Unidos
    if (persona1.esMayor(::mayorEstadosUnidos))
        println("${persona1.nombre} es mayor si vive en Estados Unidos")  // Si la persona es mayor según la ley estadounidense, se imprime
    else
        println("${persona1.nombre} no es mayor si vive en Estados Unidos")  // Si no, se imprime lo contrario
}
// Definición de la clase Personaa que tiene nombre y edad
class Personaa(val nombre: String, val edad: Int) {

    // Método esMayor que recibe una función fn como parámetro para determinar si una persona es mayor de edad
    fun esMayor(fn: (Int) -> Boolean): Boolean {
        return fn(edad)  // Llama a la función fn con la edad de la persona y devuelve el resultado
    }
}

// Función para determinar si una persona es mayor de edad en Estados Unidos (mayoría de edad a los 21 años)
fun mayorEstadosUnidos(edad: Int): Boolean {
    if (edad >= 21)
        return true  // Si la edad es mayor o igual a 21, la persona es mayor en Estados Unidos
    else
        return false  // Si no, la persona no es mayor en Estados Unidos
}

// Función para determinar si una persona es mayor de edad en Argentina (mayoría de edad a los 18 años)
fun mayorArgentina(edad: Int): Boolean {
    if (edad >= 18)
        return true  // Si la edad es mayor o igual a 18, la persona es mayor en Argentina
    else
        return false  // Si no, la persona no es mayor en Argentina
}

fun main(parametro: Array<String>) {
    // Se crea una instancia de Personaa con nombre "juan" y edad 18
    val persona1 = Personaa("juan", 18)

    // Se verifica si la persona es mayor de edad en Argentina
    if (persona1.esMayor(::mayorArgentina))
        println("${persona1.nombre} es mayor si vive en Argentina")  // Si la persona es mayor según la ley argentina, se imprime
    else
        println("${persona1.nombre} no es mayor si vive en Argentina")  // Si no, se imprime lo contrario

    // Se verifica si la persona es mayor de edad en Estados Unidos
    if (persona1.esMayor(::mayorEstadosUnidos))
        println("${persona1.nombre} es mayor si vive en Estados Unidos")  // Si la persona es mayor según la ley estadounidense, se imprime
    else
        println("${persona1.nombre} no es mayor si vive en Estados Unidos")  // Si no, se imprime lo contrario
}
