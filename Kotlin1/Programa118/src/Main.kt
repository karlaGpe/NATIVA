// Definición de la clase Hijos
class Hijos {
    // Se declara un arreglo de enteros con capacidad para 5 elementos (edades)
    val edades = IntArray(5)

    // Método para cargar las edades por teclado
    fun cargar() {
        // Recorre todos los índices del arreglo
        for(i in edades.indices) {
            print("Ingrese edad:")                  // Solicita al usuario ingresar una edad
            edades[i] = readln().toInt()            // Lee el valor ingresado y lo convierte a entero
        }
        mayorEdad()                                 // Llama al método que determina la mayor edad
        promedio()                                  // Llama al método que calcula el promedio
    }

    // Método que busca la mayor edad en el arreglo
    fun mayorEdad() {
        var mayor = edades[0]                       // Inicializa la variable mayor con el primer elemento
        for(i in edades.indices)
            if (edades[i] > mayor)                  // Compara cada edad con el valor actual de 'mayor'
                mayor = edades[i]                   // Si encuentra una mayor, actualiza la variable
        println("El hijo con mayor edad es $mayor") // Muestra la mayor edad encontrada
    }

    // Método que calcula el promedio de edades
    fun promedio() {
        var suma = 0                                // Variable acumuladora para la suma de las edades
        for(i in edades.indices)
            suma += edades[i]                       // Suma cada edad al acumulador
        val promedio = suma / edades.size           // Calcula el promedio dividiendo entre la cantidad de elementos
        println("La edad promedio de los hijos es $promedio") // Muestra el promedio
    }
}

// Función principal del programa
fun main(parametros: Array<String>) {
    val hijos1 = Hijos()                            // Crea un objeto de la clase Hijos
    hijos1.cargar()                                 // Llama al método cargar del objeto
}
