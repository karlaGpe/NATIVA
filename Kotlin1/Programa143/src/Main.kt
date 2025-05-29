// Definición de la interfaz Figura que incluye los métodos para calcular la superficie y el perímetro,
// así como un método por defecto para imprimir el título "Datos de la figura".
interface Figura {
    fun calcularSuperficie(): Int  // Método abstracto para calcular la superficie de la figura
    fun calcularPerimetro(): Int   // Método abstracto para calcular el perímetro de la figura

    // Método por defecto para imprimir los datos de la figura
    fun tituloResultado() {
        println("Datos de la figura")  // Imprime un título común para todas las figuras
    }
}

// Clase Cuadrado que implementa la interfaz Figura, con un lado como propiedad
class Cuadrado(val lado: Int): Figura {
    // Implementación del cálculo de la superficie de un cuadrado (lado * lado)
    override fun calcularSuperficie(): Int {
        return lado * lado
    }

    // Implementación del cálculo del perímetro de un cuadrado (lado * 4)
    override fun calcularPerimetro(): Int {
        return lado * 4
    }
}

// Clase Rectangulo que implementa la interfaz Figura, con dos lados como propiedades (mayor y menor)
class Rectangulo(val ladoMayor: Int, val ladoMenor: Int): Figura {
    // Implementación del cálculo de la superficie de un rectángulo (ladoMayor * ladoMenor)
    override fun calcularSuperficie(): Int {
        return ladoMayor * ladoMenor
    }

    // Implementación del cálculo del perímetro de un rectángulo (2 * ladoMayor + 2 * ladoMenor)
    override fun calcularPerimetro(): Int {
        return (ladoMayor * 2) + (ladoMenor * 2)
    }
}

// Función que recibe una figura de tipo Figura e imprime su superficie y perímetro
fun imprimir(fig: Figura) {
    println("Perimetro: ${fig.calcularPerimetro()}")  // Imprime el perímetro de la figura
    println("Superficie: ${fig.calcularSuperficie()}")  // Imprime la superficie de la figura
}

// Función principal donde se crean instancias de las clases Cuadrado y Rectangulo
fun main(parametro: Array<String>) {
    // Crear un objeto cuadrado1 con un lado de 10
    val cuadrado1 = Cuadrado(10)
    cuadrado1.tituloResultado()  // Imprime el título común para la figura
    println("Perimetro del cuadrado : ${cuadrado1.calcularPerimetro()}")  // Imprime el perímetro del cuadrado
    println("Superficie del cuadrado : ${cuadrado1.calcularSuperficie()}")  // Imprime la superficie del cuadrado

    // Crear un objeto rectangulo1 con lados de 10 y 5
    val rectangulo1 = Rectangulo(10, 5)
    rectangulo1.tituloResultado()  // Imprime el título común para la figura
    println("Perimetro del rectangulo : ${rectangulo1.calcularPerimetro()}")  // Imprime el perímetro del rectángulo
    println("Superficie del rectángulo : ${rectangulo1.calcularSuperficie()}")  // Imprime la superficie del rectángulo

    // Llamar a la función imprimir para las dos figuras
    imprimir(cuadrado1)  // Imprime los resultados del cuadrado
    imprimir(rectangulo1)  // Imprime los resultados del rectángulo
}
