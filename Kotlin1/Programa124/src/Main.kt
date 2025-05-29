// PROBLEMA PROPUESTO 124
/* Desarrollar una clase que defina una propiedad privada de tipo arreglo de 5 enteros.
   En el bloque init llamar a un método privado que cargue valores aleatorios comprendidos entre 0 y 10.
   Definir otros tres métodos públicos que muestren el arreglo, el mayor y el menor elemento. */

// Definimos la clase Vector
class Vector {
    // Declaramos un arreglo privado de 5 enteros
    private val vec = IntArray(5)

    // Bloque de inicialización que se ejecuta al crear el objeto
    init {
        cargar() // Llama al método privado para llenar el arreglo con valores aleatorios
    }

    // Método privado para cargar valores aleatorios entre 0 y 10 en el arreglo
    private fun cargar() {
        for(i in vec.indices)
            vec[i] = ((Math.random() * 11)).toInt() // Genera valores de 0 a 10
    }

    // Método público que imprime todo el arreglo
    fun imprimir() {
        println("Listado completo del arreglo")
        for(i in vec.indices)
            print("${vec[i]} - ") // Imprime cada valor separado por guiones
        println() // Salto de línea al final
    }

    // Método público que muestra el mayor valor del arreglo
    fun mostrarMayor() {
        var mayor = vec[0] // Inicializa con el primer valor del arreglo
        for(i in vec.indices)
            if (vec[i] > mayor)
                mayor = vec[i] // Actualiza si encuentra un valor mayor
        println("El elemento mayor del arreglo es $mayor")
    }

    // Método público que muestra el menor valor del arreglo
    fun mostrarMenor() {
        var menor = vec[0] // Inicializa con el primer valor del arreglo
        for(i in vec.indices)
            if (vec[i] < menor)
                menor = vec[i] // Actualiza si encuentra un valor menor
        println("El elemento menor del arreglo es $menor")
    }
}

// Función principal que se ejecuta al iniciar el programa
fun main(parametro: Array<String>) {
    val vector1 = Vector() // Crea una instancia de la clase Vector (y carga los valores aleatorios)
    vector1.imprimir()      // Muestra todos los valores del arreglo
    vector1.mostrarMayor()  // Muestra el valor mayor del arreglo
    vector1.mostrarMenor()  // Muestra el valor menor del arreglo
}
