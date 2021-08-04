package com.supermarket.gaj.checkout

import com.supermarket.gaj.item.Item
import com.supermarket.gaj.promotion.Promotion
import java.math.BigDecimal
import java.math.RoundingMode

class Checkout(
    private val items: MutableList<Item> = mutableListOf(),
    private val discounts: MutableList<Promotion> = mutableListOf()
) {
    fun scan(item: Item) = items.add(item)

    fun add(promotion: Promotion) = discounts.add(promotion)

    fun total() = calculate().subtract(discount())

    private fun calculate(): BigDecimal = items
        .stream()
        .map { it.unitPrice() }
        .reduce(BigDecimal.ZERO, BigDecimal::add)
        .setScale(2, RoundingMode.HALF_UP)

    private fun discount() = discounts
        .stream()
        .map { it.apply(items) }
        .reduce(BigDecimal.ZERO, BigDecimal::add)
        .setScale(2, RoundingMode.HALF_UP)
}