package com.supermarket.gaj.checkout

import com.supermarket.gaj.item.Item
import java.math.BigDecimal
import java.math.RoundingMode

class Checkout(
    private val items: MutableList<Item> = mutableListOf()
) {
    fun scan(item: Item) = items.add(item)

    fun total(): BigDecimal = items
        .stream()
        .map { it.unitPrice() }
        .reduce(BigDecimal.ZERO, BigDecimal::add)
        .setScale(2, RoundingMode.HALF_UP)
}