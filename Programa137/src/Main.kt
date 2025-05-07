// Definición de la clase Persona6, que es la clase base o "superclase"
open class Persona6(val nombre: String, val edad: Int) {
    // Función 'imprimir' que imprime los datos de la persona
    open fun imprimir() {
        println("Nombre: $nombre")  // Imprime el nombre de la persona
        println("Edad: $edad")      // Imprime la edad de la persona
    }
}

// Definición de la clase Empleado4, que hereda de Persona6
class Empleado4(nombre: String, edad: Int, val sueldo: Double): Persona6(nombre, edad) {
    // Sobrescribe la función 'imprimir' de la clase Persona6 para agregar el sueldo
    override fun imprimir() {
        super.imprimir()          // Llama a la función imprimir de la clase base (Persona6)
        println("Sueldo: $sueldo") // Imprime el sueldo del empleado
    }

    // Función que determina si el empleado paga impuestos basado en su sueldo
    fun pagaImpuestoss() {
        // Si el sueldo es mayor que 3000, imprime que paga impuestos
        if (sueldo > 3000)
            println("El empleado $nombre paga impuestos")
        // Si el sueldo es menor o igual a 3000, imprime que no paga impuestos
        else
            println("El empleado $nombre no paga impuestos")
    }
}

// Función principal donde se crea un objeto de cada clase y se prueban sus métodos
fun main(parametro: Array<String>) {
    // Se crea un objeto de la clase Persona6
    val persona1 = Persona6("Jose", 22)
    println("Datos de la persona")  // Imprime un título para los datos de la persona
    persona1.imprimir()             // Llama al método imprimir para mostrar los datos de la persona

    // Se crea un objeto de la clase Empleado4 (subclase de Persona6)
    val empleado1 = Empleado4("Ana", 30, 5000.0)
    println("Datos del empleado")   // Imprime un título para los datos del empleado
    empleado1.imprimir()            // Llama al método imprimir para mostrar los datos del empleado
    empleado1.pagaImpuestoss()      // Llama al método pagaImpuestoss para determinar si paga impuestos
}
