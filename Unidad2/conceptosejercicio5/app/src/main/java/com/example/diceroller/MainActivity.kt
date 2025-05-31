package com.example.diceroller

// Perfil de Internet-----------------------------------------------------------

fun main() {
    // Crea una instancia de la clase Person con nombre "Amanda", 33 años, hobby "play tennis" y sin referente (null)
    val amanda = Person("Amanda", 33, "play tennis", null)

    // Crea otra instancia llamada "Atiqah", 28 años, hobby "climb" y con Amanda como referente
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    // Muestra el perfil de Amanda
    amanda.showProfile()

    // Muestra el perfil de Atiqah
    atiqah.showProfile()
}

// Definición de la clase Person
class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {

    // Método para mostrar el perfil de la persona
    fun showProfile() {
        println("Name: $name")         // Imprime el nombre
        println("Age: $age")           // Imprime la edad

        // Si la persona tiene un hobby, lo imprime
        if(hobby != null) {
            print("Likes to $hobby. ")
        }

        // Si la persona tiene un referente (referrer), imprime su nombre
        if(referrer != null) {
            print("Has a referrer named ${referrer.name}")

            // Si el referente tiene un hobby, también lo imprime
            if(referrer.hobby != null) {
                print(", who likes to ${referrer.hobby}.")
            } else {
                print(".")
            }
        } else {
            // Si no hay referente, imprime que no tiene
            print("Doesn't have a referrer.")
        }

        print("\n\n")  // Imprime dos saltos de línea para separar perfiles
    }
}
