package com.example.diceroller

// Importa interfaces necesarias para la delegación de propiedades
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// ----------------------
// Clase base para todos los dispositivos inteligentes
// ----------------------
open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"       // Estado inicial del dispositivo
        protected set                 // Solo se puede modificar dentro de la clase o subclases

    open val deviceType = "unknown"   // Tipo de dispositivo, por defecto "desconocido"

    // Función para encender el dispositivo
    open fun turnOn() {
        deviceStatus = "on"
    }

    // Función para apagar el dispositivo
    open fun turnOff() {
        deviceStatus = "off"
    }
}

// ----------------------
// Clase para representar una Smart TV
// ----------------------
class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV" // Tipo específico

    // Propiedad delegada para el volumen, con límites entre 0 y 100
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    // Propiedad delegada para el canal, entre 0 y 200
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    // Incrementa el volumen y lo imprime
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    // Pasa al siguiente canal e imprime el número
    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    // Sobrescribe el método de encendido para mostrar más información
    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    // Sobrescribe el apagado con mensaje personalizado
    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

// ----------------------
// Clase para representar una luz inteligente
// ----------------------
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light" // Tipo específico

    // Brillo controlado por propiedad delegada
    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    // Aumenta el brillo en una unidad
    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    // Enciende la luz y establece brillo inicial
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    // Apaga la luz y pone brillo en 0
    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

// ----------------------
// Clase para representar el hogar inteligente con dispositivos
// ----------------------
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0         // Cuenta cuántos dispositivos están encendidos
        private set                   // Solo puede ser modificada desde dentro de la clase

    // Enciende la TV y aumenta el contador
    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    // Apaga la TV y disminuye el contador
    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    // Aumenta volumen de la TV
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    // Cambia al siguiente canal en la TV
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    // Enciende la luz y suma al contador
    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    // Apaga la luz y resta al contador
    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    // Aumenta el brillo de la luz
    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    // Apaga todos los dispositivos (TV y luz)
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

// ----------------------
// Clase delegada para controlar valores en un rango definido
// ----------------------
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue // Almacena el valor actual

    // Devuelve el valor actual
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    // Asigna un nuevo valor, si está dentro del rango permitido
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

// ----------------------
// Función principal para probar el sistema
// ----------------------
fun main() {
    // Crea una instancia de SmartTvDevice y la asigna a una variable de tipo base SmartDevice
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn() // Enciende el dispositivo (TV)

    // Reasigna la variable a una luz inteligente
    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn() // Enciende el dispositivo (luz)
}

