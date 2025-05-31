package com.example.diceroller

// Notificaciones móviles-----------------------------------------------------------
fun main() {
    // Número de notificaciones en la mañana
    val morningNotification = 51
    // Número de notificaciones en la tarde
    val eveningNotification = 135

    // Llama a la función para mostrar el resumen de notificaciones
    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

// Función que imprime un resumen de las notificaciones
fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100) {
        // Si hay menos de 100 notificaciones, muestra el número exacto
        println("You have ${numberOfMessages} notifications.")
    } else {
        // Si hay 100 o más, muestra un mensaje general
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}


// Precio de las entradas de cine-----------------------------------------------------------
/*
fun main() {
    // Edades de ejemplo para distintos tipos de personas
    val child = 5
    val adult = 28
    val senior = 87

    // Es lunes (entrada con descuento para adultos)
    val isMonday = true

    // Imprime el precio para cada tipo de persona
    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

// Función que devuelve el precio del boleto según la edad y si es lunes
fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when(age) {
        in 0..12 -> 15                            // Precio para niños
        in 13..60 -> if (isMonday) 25 else 30     // Adultos pagan menos los lunes
        in 61..100 -> 20                          // Precio para adultos mayores
        else -> -1                                // Edad inválida
    }
}
*/


// Conversor de temperatura-----------------------------------------------------------
/*
fun main() {
    // Convierte 27 °C a °F
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }

    // Convierte 350 K a °C
    printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }

    // Convierte 10 °F a K
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }
}

// Función que imprime el resultado de una conversión de temperatura
fun printFinalTemperature(
    initialMeasurement: Double,                      // Valor original
    initialUnit: String,                             // Unidad original
    finalUnit: String,                               // Unidad convertida
    conversionFormula: (Double) -> Double            // Función de conversión
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // Formateado a 2 decimales
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
*/


// Catálogo de canciones-----------------------------------------------------------
/*
fun main() {
    // Crea una canción con título, artista, año y número de reproducciones
    val brunoSong = Song("We Don't Talk About Bruno", "Encanto Cast", 2022, 1_000_000)

    // Imprime la descripción de la canción
    brunoSong.printDescription()

    // Imprime si la canción es popular (basado en las reproducciones)
    println(brunoSong.isPopular)
}

// Clase Song que representa una canción
class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
) {
    // Propiedad que indica si la canción es popular (1000+ reproducciones)
    val isPopular: Boolean
        get() = playCount >= 1000

    // Método para imprimir información de la canción
    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}
*/


// Perfil de Internet-----------------------------------------------------------
/*
fun main() {
    // Crea una persona sin referente
    val amanda = Person("Amanda", 33, "play tennis", null)

    // Crea otra persona con Amanda como referente
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    // Muestra el perfil de Amanda
    amanda.showProfile()

    // Muestra el perfil de Atiqah
    atiqah.showProfile()
}

// Clase Person que representa a una persona con un posible referente
class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    // Función que imprime el perfil de la persona
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")

        // Si tiene un hobby, lo muestra
        if (hobby != null) {
            print("Likes to $hobby. ")
        }

        // Si tiene un referente, muestra su información
        if (referrer != null) {
            print("Has a referrer named ${referrer.name}")
            if (referrer.hobby != null) {
                print(", who likes to ${referrer.hobby}.")
            } else {
                print(".")
            }
        } else {
            // Si no tiene referente
            print("Doesn't have a referrer.")
        }

        print("\n\n") // Separación entre perfiles
    }
}
*/


// Teléfonos plegables-----------------------------------------------------------
/*
open class Phone(var isScreenLightOn: Boolean = false) {
    // Método para encender la pantalla
    open fun switchOn() {
        isScreenLightOn = true
    }

    // Método para apagar la pantalla
    fun switchOff() {
        isScreenLightOn = false
    }

    // Muestra si la pantalla está encendida o apagada
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

// Clase FoldablePhone que hereda de Phone, añade funcionalidad de plegado
class FoldablePhone(var isFolded: Boolean = true): Phone() {
    // Solo permite encender si está desplegado
    override fun switchOn() {
        if (!isFolded) {
            isScreenLightOn = true
        }
    }

    // Método para plegar el teléfono
    fun fold() {
        isFolded = true
    }

    // Método para desplegar el teléfono
    fun unfold() {
        isFolded = false
    }
}

fun main() {
    // Crea un nuevo teléfono plegable
    val newFoldablePhone = FoldablePhone()

    // Intenta encenderlo estando plegado (no debería encenderse)
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()

    // Lo despliega y vuelve a encender
    newFoldablePhone.unfold()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
}
*/


// Subasta especial-----------------------------------------------------------
/*
fun main() {
    // Oferta ganadora con monto y nombre del postor
    val winningBid = Bid(5000, "Private Collector")

    // Subasta del ítem A con oferta válida
    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")

    // Subasta del ítem B sin oferta (usa el precio mínimo)
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

// Clase que representa una oferta con monto y postor
class Bid(val amount: Int, val bidder: String)

// Función que retorna el precio final: si hay oferta, usa su valor; si no, el mínimo
fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return bid?.amount ?: minimumPrice
}
*/
