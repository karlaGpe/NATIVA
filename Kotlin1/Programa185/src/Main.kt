// Definimos una clase Materia con dos propiedades: nombre (String) y nota (Int).
data class Materia(val nombre: String, val nota: Int)

// Función para cargar los alumnos y sus materias en un mapa mutable.
fun cargar(alumnos: MutableMap<Int, MutableList<Materia>>) {
    // Pedimos al usuario cuántos alumnos se van a cargar.
    print("Cuantos alumnos cargará ?:")
    val cant = readLine()!!.toInt()

    // Iteramos para cargar los alumnos.
    for(i in 1..cant) {
        // Solicitamos el dni del alumno.
        print("Ingrese dni:")
        val dni = readLine()!!.toInt()

        // Creamos una lista mutable para almacenar las materias del alumno.
        val listaMaterias = mutableListOf<Materia>()

        // Bucle para ingresar las materias y las notas de cada alumno.
        do {
            // Solicitamos el nombre de la materia.
            print("Ingrese materia del alumno:")
            val nombre = readLine()!!

            // Solicitamos la nota de la materia.
            print("Ingrese nota:")
            val nota = readLine()!!.toInt()

            // Agregamos la materia con su respectiva nota a la lista del alumno.
            listaMaterias.add(Materia(nombre, nota))

            // Preguntamos si desea ingresar otra materia.
            print("Ingrese otra nota (si/no):")
            val opcion = readLine()!!
        } while (opcion == "si")  // Continuamos mientras el usuario quiera agregar más materias.

        // Asignamos la lista de materias del alumno al mapa utilizando el dni como clave.
        alumnos[dni] = listaMaterias
    }
}

// Función para imprimir los datos de todos los alumnos y sus materias.
fun imprimir(alumnos: MutableMap<Int, MutableList<Materia>>) {
    // Recorremos todos los alumnos en el mapa.
    for((dni, listaMaterias) in alumnos) {
        println("Dni del alumno: $dni") // Imprimimos el dni del alumno.

        // Recorremos la lista de materias de cada alumno.
        for(materia in listaMaterias) {
            // Imprimimos el nombre y la nota de cada materia.
            println("Materia: ${materia.nombre}")
            println("Nota: ${materia.nota}")
        }
        println()  // Se imprime una línea vacía para separar a cada alumno.
    }
}

// Función para consultar las materias de un alumno según su dni.
fun consultaPorDni(alumnos: MutableMap<Int, MutableList<Materia>>) {
    // Solicitamos el dni del alumno a consultar.
    print("Ingrese el dni del alumno a consultar:")
    val dni = readLine()!!.toInt()

    // Verificamos si el alumno con el dni ingresado existe en el mapa.
    if (dni in alumnos) {
        println("Cursa las siguientes materias:")

        // Obtenemos la lista de materias del alumno.
        val lista = alumnos[dni]

        // Si la lista no es nula, mostramos las materias y notas.
        if (lista != null) {
            for (materia in lista) {
                // Imprimimos el nombre de la materia y la nota.
                println("Nombre de materia: ${materia.nombre}")
                println("Nota: ${materia.nota}")
            }
        }
    } else {
        // Si el alumno no existe en el mapa, informamos que no se encontró.
        println("No se encuentra un alumno con ese dni")
    }
}

// Función principal que orquesta las operaciones.
fun main(args: Array<String>){
    // Creamos un mapa mutable que almacena el dni del alumno como clave
    // y una lista de materias (MutableList<Materia>) como valor.
    val alumnos: MutableMap<Int, MutableList<Materia>> = mutableMapOf()

    // Llamamos a la función cargar para ingresar datos de los alumnos y sus materias.
    cargar(alumnos)

    // Llamamos a la función imprimir para mostrar todos los datos cargados.
    imprimir(alumnos)

    // Llamamos a la función consultaPorDni para permitir la consulta de un alumno específico.
    consultaPorDni(alumnos)
}
