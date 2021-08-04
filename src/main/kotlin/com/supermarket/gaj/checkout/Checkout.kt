package com.supermarket.gaj.checkout

import com.supermarket.gaj.item.Item
import java.math.BigDecimal

class Checkout(private val items: List<Item>) {
    fun total(): BigDecimal = items
        .stream()
        .map { it.unitPrice() }
        .reduce(BigDecimal.ZERO, BigDecimal::add)
}