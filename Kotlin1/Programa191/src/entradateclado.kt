// Definimos un paquete llamado 'entradateclado', el cual contiene funciones para obtener distintos tipos de datos desde la entrada del usuario.

package entradateclado

// Función para leer un número entero desde la entrada del usuario.
// Recibe un mensaje como parámetro, que se le mostrará al usuario como indicación.
fun retornarInt(mensaje: String): Int {
    print(mensaje) // Imprime el mensaje para que el usuario sepa qué debe ingresar.
    return readln().toInt() // Lee la entrada del usuario, la convierte a entero y la retorna.
}

// Función para leer un número de tipo Double desde la entrada del usuario.
// Recibe un mensaje como parámetro para indicarle al usuario qué valor debe ingresar.
fun retornarDouble(mensaje: String): Double {
    print(mensaje) // Imprime el mensaje para indicar qué debe ingresar el usuario.
    return readln().toDouble() // Lee la entrada del usuario, la convierte a Double y la retorna.
}

// Función para leer un número de tipo Float desde la entrada del usuario.
// Similar a las funciones anteriores, recibe un mensaje como parámetro para mostrarlo al usuario.
fun retornarFloat(mensaje: String): Float {
    print(mensaje) // Muestra el mensaje de entrada al usuario.
    return readln().toFloat() // Lee la entrada del usuario, la convierte a Float y la retorna.
}
