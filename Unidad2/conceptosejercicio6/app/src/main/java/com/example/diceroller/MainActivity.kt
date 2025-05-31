package com.example.diceroller

// Teléfonos plegables-----------------------------------------------------------

// Clase base Phone, representa un teléfono con una pantalla que puede estar encendida o apagada
open class Phone(var isScreenLightOn: Boolean = false) {

    // Método para encender la pantalla (puede ser sobrescrito por subclases)
    open fun switchOn() {
        isScreenLightOn = true
    }

    // Método para apagar la pantalla
    fun switchOff() {
        isScreenLightOn = false
    }

    // Método para mostrar si la pantalla está encendida o apagada
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

// Clase derivada FoldablePhone, representa un teléfono plegable
class FoldablePhone(var isFolded: Boolean = true): Phone() {

    // Sobrescribe el método switchOn: solo enciende la pantalla si el teléfono está desplegado
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

// Función principal donde se ejecuta el programa
fun main() {
    // Crea una nueva instancia de FoldablePhone, comienza plegado por defecto
    val newFoldablePhone = FoldablePhone()

    // Intenta encender la pantalla estando plegado (no debería encenderse)
    newFoldablePhone.switchOn()

    // Muestra el estado de la pantalla (debería estar "off")
    newFoldablePhone.checkPhoneScreenLight()

    // Despliega el teléfono
    newFoldablePhone.unfold()

    // Ahora sí intenta encender la pantalla (debería encenderse)
    newFoldablePhone.switchOn()

    // Muestra el estado de la pantalla (debería estar "on")
    newFoldablePhone.checkPhoneScreenLight()
}
