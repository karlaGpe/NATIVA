// Definimos un enum class llamado 'Paises' que contiene varios países sudamericanos y su cantidad de habitantes
enum class Paises (val habitantes: Int) {
    BRASIL (202450649),   // Brasil con 202,450,649 habitantes
    COLOMBIA (50364000),   // Colombia con 50,364,000 habitantes
    PERU (31151643),   // Perú con 31,151,643 habitantes
    VENEZUELA (31028337),   // Venezuela con 31,028,337 habitantes
    CHILE (18261884),   // Chile con 18,261,884 habitantes
    ECUADOR (16298217),   // Ecuador con 16,298,217 habitantes
    BOLIVIA (10888000),   // Bolivia con 10,888,000 habitantes
    PARAGUAY (6460000),   // Paraguay con 6,460,000 habitantes
    URUGUAY (3372000)   // Uruguay con 3,372,000 habitantes
}

// Función principal
fun main(parametro: Array<String>) {
    // Creación de una variable 'pais1' con la constante 'BRASIL' del enum 'Paises'
    val pais1 = Paises.BRASIL
    println(pais1)   // Imprime el nombre del país (BRASIL)
    println(pais1.habitantes)   // Imprime la cantidad de habitantes de Brasil

    // Creación de una variable 'pais2' con la constante 'COLOMBIA' del enum 'Paises'
    val pais2 = Paises.COLOMBIA
    println(pais2)   // Imprime el nombre del país (COLOMBIA)
    println(pais2.habitantes)   // Imprime la cantidad de habitantes de Colombia

    // Creación de una variable 'pais3' con la constante 'PERU' del enum 'Paises'
    val pais3 = Paises.PERU
    println(pais3)   // Imprime el nombre del país (PERU)
    println(pais3.habitantes)   // Imprime la cantidad de habitantes de Perú

    // Creación de una variable 'pais4' con la constante 'VENEZUELA' del enum 'Paises'
    val pais4 = Paises.VENEZUELA
    println(pais4)   // Imprime el nombre del país (VENEZUELA)
    println(pais4.habitantes)   // Imprime la cantidad de habitantes de Venezuela

    // Creación de una variable 'pais5' con la constante 'CHILE' del enum 'Paises'
    val pais5 = Paises.CHILE
    println(pais5)   // Imprime el nombre del país (CHILE)
    println(pais5.habitantes)   // Imprime la cantidad de habitantes de Chile

    // Creación de una variable 'pais6' con la constante 'ECUADOR' del enum 'Paises'
    val pais6 = Paises.ECUADOR
    println(pais6)   // Imprime el nombre del país (ECUADOR)
    println(pais6.habitantes)   // Imprime la cantidad de habitantes de Ecuador

    // Creación de una variable 'pais7' con la constante 'BOLIVIA' del enum 'Paises'
    val pais7 = Paises.BOLIVIA
    println(pais7)   // Imprime el nombre del país (BOLIVIA)
    println(pais7.habitantes)   // Imprime la cantidad de habitantes de Bolivia

    // Creación de una variable 'pais8' con la constante 'PARAGUAY' del enum 'Paises'
    val pais8 = Paises.PARAGUAY
    println(pais8)   // Imprime el nombre del país (PARAGUAY)
    println(pais8.habitantes)   // Imprime la cantidad de habitantes de Paraguay

    // Creación de una variable 'pais9' con la constante 'URUGUAY' del enum 'Paises'
    val pais9 = Paises.URUGUAY
    println(pais9)   // Imprime el nombre del país (URUGUAY)
    println(pais9.habitantes)   // Imprime la cantidad de habitantes de Uruguay
}
