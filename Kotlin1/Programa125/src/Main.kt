import java.util.* // Importa la clase Locale para usar la conversión a mayúsculas con configuración local

// Definición de la clase Persona3
class Persona3 {
    // Propiedad 'nombre' con getter y setter personalizados
    var nombre: String = ""
        set(valor) {
            // Al asignar un nombre, se convierte todo a mayúsculas
            field = valor.uppercase(Locale.getDefault())
        }
        get() {
            // Al obtener el nombre, se retorna entre paréntesis
            return "(" + field + ")"
        }

    // Propiedad 'edad' con validación en el setter
    var edad: Int = 0
        set(valor) {
            // Solo se asigna si el valor es mayor o igual a 0, de lo contrario se asigna 0
            if (valor >= 0)
                field = valor
            else
                field = 0
        }
}

// Función principal que ejecuta el programa
fun main(parametro: Array<String>) {
    val persona1 = Persona3()        // Se crea una instancia de la clase Persona3
    persona1.nombre = "juan"         // Se asigna el nombre, se guarda como "JUAN" internamente
    persona1.edad = 23               // Se asigna una edad válida (23)

    println(persona1.nombre)         // Imprime: (JUAN)
    println(persona1.edad)           // Imprime: 23

    persona1.edad = -50              // Se intenta asignar una edad inválida
    println(persona1.edad)           // Imprime: 0 (porque se forzó el valor a 0)
}
