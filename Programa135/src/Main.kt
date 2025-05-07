// Función principal
fun main(parametro: Array<String>) {
    // Definición de un objeto anónimo llamado 'dados'
    val dados = object {
        // Propiedad 'arreglo' que es un arreglo de enteros con 5 elementos
        val arreglo = IntArray(5)

        // Método 'generar' que llena el arreglo con valores aleatorios entre 1 y 6
        fun generar() {
            // Iteración sobre los índices del arreglo
            for(i in arreglo.indices)
            // Asignación de un valor aleatorio entre 1 y 6 a cada elemento del arreglo
                arreglo[i] = ((Math.random() * 6) + 1).toInt()
        }

        // Método 'imprimir' que imprime los elementos del arreglo
        fun imprimir() {
            // Iteración sobre cada elemento del arreglo
            for(elemento in arreglo)
            // Imprime cada elemento seguido de un guion
                print("$elemento - ")
            // Imprime un salto de línea después de imprimir todos los elementos
            println()
        }

        // Método 'mayor' que devuelve el valor más grande del arreglo
        fun mayor(): Int {
            // Inicializa la variable 'may' con el primer valor del arreglo
            var may = arreglo[0]
            // Iteración sobre los índices del arreglo
            for(i in arreglo.indices)
            // Si el valor en la posición actual es mayor que 'may', lo actualiza
                if (arreglo[i] > may)
                    may = arreglo[i]
            // Devuelve el mayor valor encontrado
            return may
        }
    }

    // Llamada al método 'generar' para llenar el arreglo con valores aleatorios
    dados.generar()

    // Llamada al método 'imprimir' para mostrar los valores generados
    dados.imprimir()

    // Muestra el valor mayor encontrado en el arreglo
    print("Mayor valor:")
    // Llama al método 'mayor' y lo imprime
    println(dados.mayor())
}
