// Se define una clase de datos llamada Persona4 con dos propiedades: nombre y edad
data class Persona4(var nombre: String, var edad: Int) {

    // Se sobreescribe el método toString() para personalizar cómo se imprime un objeto de tipo Persona4
    override fun toString(): String {
        return "$nombre, $edad"
    }
}

fun main(parametro: Array<String>) {
    // Se crea una instancia de Persona4 con nombre "Juan" y edad 22
    var persona1 = Persona4("Juan", 22)

    // Otra instancia con nombre "Ana" y edad 59
    var persona2 = Persona4("Ana", 59)

    // Se imprimen ambos objetos. Gracias al override de toString(), la salida será más simple: "Juan, 22" y "Ana, 59"
    println(persona1)
    println(persona2)
}
