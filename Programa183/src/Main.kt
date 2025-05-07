// Función para cargar palabras en el diccionario (mutable map).
fun cargar(diccionario: MutableMap<String, String>) {
    // Usamos un bucle do-while para permitir que el usuario cargue varias palabras.
    do {
        // Solicitamos al usuario que ingrese una palabra en castellano.
        print("Ingrese palabra en castellano:")
        val palCastellano = readLine()!!

        // Solicitamos al usuario que ingrese la traducción de la palabra en inglés.
        print("Ingrese palabra en ingles:")
        val palIngles = readLine()!!

        // Añadimos la palabra en inglés como clave y su traducción al castellano como valor en el diccionario.
        diccionario[palIngles] = palCastellano

        // Preguntamos al usuario si desea continuar agregando más palabras al diccionario.
        print("Continua cargando otra palabra en el diccionario? (si/no):")
        val fin = readLine()!!
    } while (fin == "si") // El bucle continuará si el usuario responde "si".
}

// Función para mostrar todas las palabras cargadas en el diccionario.
fun listado(diccionario: MutableMap<String, String>) {
    // Recorremos todas las entradas del diccionario.
    for((ingles, castellano) in diccionario)
    // Imprimimos cada palabra en inglés con su correspondiente traducción en castellano.
        println("$ingles: $castellano")
    println() // Línea vacía para separar la salida.
}

// Función para consultar la traducción de una palabra en inglés.
fun consultaIngles(diccionario: MutableMap<String, String>) {
    // Solicitamos al usuario que ingrese una palabra en inglés para buscar su traducción.
    print("Ingrese una palabra en ingles para verificar su traducción:")
    val ingles = readLine()

    // Verificamos si la palabra ingresada existe en el diccionario.
    if (ingles in diccionario)
    // Si la palabra existe, mostramos la traducción al castellano.
        println("La traducción en castellano es ${diccionario[ingles]}")
    else
    // Si la palabra no existe en el diccionario, informamos que no está presente.
        println("No existe esa palabra en el diccionario")
}

// Función principal que coordina las operaciones.
fun main(args: Array<String>) {
    // Creamos un diccionario vacío (mutable map).
    val diccionario: MutableMap<String, String> = mutableMapOf()

    // Llamamos a la función cargar para que el usuario ingrese palabras al diccionario.
    cargar(diccionario)

    // Llamamos a la función listado para imprimir todas las palabras del diccionario.
    listado(diccionario)

    // Llamamos a la función consultaIngles para permitir al usuario consultar traducciones.
    consultaIngles(diccionario)
}
