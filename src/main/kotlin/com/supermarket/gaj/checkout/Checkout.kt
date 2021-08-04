package com.supermarket.gaj.checkout

import com.supermarket.gaj.item.Item
import com.supermarket.gaj.item.SKU
import com.supermarket.gaj.promotion.TwoForOnePound
import java.math.BigDecimal
import java.math.RoundingMode

class Checkout(
    private val items: MutableList<Item> = mutableListOf()
) {
    fun scan(item: Item) = items.add(item)

    fun total() = calculate().subtract(discount())

    private fun calculate(): BigDecimal = items
        .stream()
        .map { it.unitPrice() }
        .reduce(BigDecimal.ZERO, BigDecimal::add)
        .setScale(2, RoundingMode.HALF_UP)

    private fun discount() = TwoForOnePound(SKU.B).apply(items)
}