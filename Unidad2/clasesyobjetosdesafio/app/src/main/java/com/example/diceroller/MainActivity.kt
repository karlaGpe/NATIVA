package com.example.diceroller

// Importa la interfaz necesaria para propiedades delegadas con lectura/escritura
import kotlin.properties.ReadWriteProperty
// Importa la clase que representa una propiedad de Kotlin (usada en la delegación)
import kotlin.reflect.KProperty

// Clase base para dispositivos inteligentes
open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online" // Estado inicial del dispositivo
        protected set           // Solo puede modificarse desde esta clase o subclases

    open val deviceType = "unknown" // Tipo de dispositivo, puede sobrescribirse en subclases

    open fun turnOn() {
        deviceStatus = "on" // Cambia el estado a "on"
    }

    open fun turnOff() {
        deviceStatus = "off" // Cambia el estado a "off"
    }

    // Imprime la información del dispositivo
    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

// Clase que representa un Smart TV
class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV" // Define el tipo como Smart TV

    // Control del volumen con límites entre 0 y 100
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    // Control del canal con límites entre 0 y 200
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    // Aumenta el volumen y muestra el valor
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    // Disminuye el volumen si no está en el mínimo
    fun decreaseVolume() {
        if (speakerVolume > 0) {
            speakerVolume--
            println("Speaker volume decreased to $speakerVolume.")
        } else {
            println("Speaker volume is already at the minimum.")
        }
    }

    // Aumenta el número de canal
    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    // Disminuye el número de canal si no está en el primero
    fun previousChannel() {
        if (channelNumber > 0) {
            channelNumber--
            println("Channel number decreased to $channelNumber.")
        } else {
            println("You are already on the first channel.")
        }
    }

    // Sobrescribe el encendido para mostrar el volumen y canal actuales
    override fun turnOn() {
        super.turnOn()
        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to $channelNumber.")
    }

    // Sobrescribe el apagado con mensaje personalizado
    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

// Clase que representa una luz inteligente
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light" // Define el tipo como Smart Light

    // Control del brillo entre 0 y 100
    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    // Aumenta el brillo
    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    // Disminuye el brillo si es mayor a 0
    fun decreaseBrightness() {
        if (brightnessLevel > 0) {
            brightnessLevel--
            println("Brightness decreased to $brightnessLevel.")
        } else {
            println("Brightness is already at the minimum.")
        }
    }

    // Enciende la luz y establece el brillo en 2
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    // Apaga la luz y pone el brillo en 0
    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

// Clase delegada que regula un valor dentro de un rango (min y max)
class RangeRegulator(initialValue: Int, private val minValue: Int, private val maxValue: Int) :
    ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue // Valor actual almacenado

    // Devuelve el valor actual
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    // Solo asigna el valor si está dentro del rango permitido
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

// Clase que representa un hogar inteligente con una TV y una luz
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0 // Cantidad de dispositivos encendidos
        private set           // Solo se puede modificar desde dentro de la clase

    // Actualiza el contador según los dispositivos que estén encendidos
    private fun updateDeviceTurnOnCount() {
        deviceTurnOnCount = listOf(smartTvDevice.deviceStatus, smartLightDevice.deviceStatus).count { it == "on" }
    }

    // Enciende la TV y actualiza el contador
    fun turnOnTv() {
        smartTvDevice.turnOn()
        updateDeviceTurnOnCount()
    }

    // Apaga la TV y actualiza el contador
    fun turnOffTv() {
        smartTvDevice.turnOff()
        updateDeviceTurnOnCount()
    }

    // Aumenta el volumen de la TV si está encendida
    fun increaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.increaseSpeakerVolume()
        } else {
            println("TV is off. Can't increase volume.")
        }
    }

    // Disminuye el volumen de la TV si está encendida
    fun decreaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.decreaseVolume()
        } else {
            println("TV is off. Can't decrease volume.")
        }
    }

    // Cambia al siguiente canal si la TV está encendida
    fun changeTvChannelToNext() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.nextChannel()
        } else {
            println("TV is off. Can't change channel.")
        }
    }

    // Cambia al canal anterior si la TV está encendida
    fun changeTvChannelToPrevious() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.previousChannel()
        } else {
            println("TV is off. Can't change channel.")
        }
    }

    // Enciende la luz y actualiza el contador
    fun turnOnLight() {
        smartLightDevice.turnOn()
        updateDeviceTurnOnCount()
    }

    // Apaga la luz y actualiza el contador
    fun turnOffLight() {
        smartLightDevice.turnOff()
        updateDeviceTurnOnCount()
    }

    // Aumenta el brillo si la luz está encendida
    fun increaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.increaseBrightness()
        } else {
            println("Light is off. Can't increase brightness.")
        }
    }

    // Disminuye el brillo si la luz está encendida
    fun decreaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.decreaseBrightness()
        } else {
            println("Light is off. Can't decrease brightness.")
        }
    }

    // Muestra información de la Smart TV
    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }

    // Muestra información de la luz
    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }

    // Apaga todos los dispositivos
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

// Función principal para probar la funcionalidad
fun main() {
    val smartTv = SmartTvDevice("Android TV", "Entertainment")     // Crea una instancia de Smart TV
    val smartLight = SmartLightDevice("Google Light", "Utility")   // Crea una instancia de luz inteligente
    val smartHome = SmartHome(smartTv, smartLight)                 // Crea un hogar inteligente con los dispositivos

    smartHome.turnOnTv()           // Enciende la TV
    smartHome.turnOnLight()        // Enciende la luz

    smartHome.increaseTvVolume()   // Aumenta el volumen de la TV
    smartHome.decreaseTvVolume()   // Disminuye el volumen de la TV
    smartHome.changeTvChannelToNext()     // Cambia al siguiente canal
    smartHome.changeTvChannelToPrevious() // Cambia al canal anterior

    smartHome.increaseLightBrightness()   // Aumenta el brillo de la luz
    smartHome.decreaseLightBrightness()   // Disminuye el brillo de la

    // Imprimir información de los dispositivos
    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()

    // Apagar dispositivos
    smartHome.turnOffAllDevices()
}
