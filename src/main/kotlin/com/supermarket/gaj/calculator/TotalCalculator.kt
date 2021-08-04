package com.supermarket.gaj.calculator

import com.supermarket.gaj.item.Item
import com.supermarket.gaj.promotion.Promotion
import java.math.BigDecimal
import java.math.RoundingMode


class TotalCalculator(
    private val items: List<Item>,
    private val discounts: List<Promotion>
) : Calculator {
    private fun subtotal() = items
        .stream()
        .map { it.unitPrice() }
        .reduce(BigDecimal.ZERO, BigDecimal::add)
        .setScale(2, RoundingMode.HALF_UP)

    private fun discounts() = discounts
        .stream()
        .map { it.apply(items) }
        .reduce(BigDecimal.ZERO, BigDecimal::add)
        .setScale(2, RoundingMode.HALF_UP)

    override fun calculate() = subtotal().subtract(discounts())
}