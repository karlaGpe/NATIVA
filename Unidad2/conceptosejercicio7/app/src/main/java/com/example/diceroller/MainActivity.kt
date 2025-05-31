package com.example.diceroller

// Subasta especial-----------------------------------------------------------

fun main() {
    // Crea una instancia de Bid (oferta) con monto 5000 y nombre del ofertante "Private Collector"
    val winningBid = Bid(5000, "Private Collector")

    // Llama a la función auctionPrice con una oferta válida y un precio mínimo de 2000
    // Como hay una oferta, se usa su valor (5000)
    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")

    // Llama a auctionPrice con una oferta nula (sin oferta) y precio mínimo de 3000
    // Como no hay oferta, se usa el precio mínimo (3000)
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

// Clase Bid representa una oferta en la subasta, con monto y nombre del ofertante
class Bid(val amount: Int, val bidder: String)

// Función que determina el precio final del producto en la subasta
// Si hay una oferta (`bid` no es null), devuelve el monto de la oferta
// Si no hay oferta (`bid` es null), devuelve el precio mínimo
fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return bid?.amount ?: minimumPrice
}
