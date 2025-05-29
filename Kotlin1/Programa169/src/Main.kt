// Definición de la clase Alumnoo, que representa a un alumno con su documento y nombre.
data class Alumnoo(val documento: Int, val nombre: String)

// Clase Curso que contiene una lista de alumnos
class Curso {
    // Arreglo de alumnos inscritos en el curso
    val alumnos = arrayOf(
        Alumnoo(123456, "Marcos"),
        Alumnoo(666666, "Ana"),
        Alumnoo(777777, "Luis")
    )

    // Sobrecarga del operador 'in' para verificar si un alumno está inscrito en el curso.
    // Esto se hace utilizando el operador 'contains' y 'any' para buscar el documento del alumno.
    operator fun contains(documento: Int): Boolean {
        // Recorre el arreglo de alumnos y verifica si alguno tiene el documento solicitado.
        return alumnos.any { documento == it.documento }
    }
}

// Función main donde se crea un objeto Curso y se verifica si un alumno está inscrito.
fun main(args: Array<String>) {
    // Crear una instancia de la clase Curso
    val curso1 = Curso()

    // Verificar si el alumno con el documento 123456 está inscrito en el curso
    if (123456 in curso1)
        println("El alumno Marcos está inscrito en el curso") // Salida si el alumno está inscrito
    else
        println("El alumno Marcos no está inscrito en el curso") // Salida si el alumno no está inscrito
}
