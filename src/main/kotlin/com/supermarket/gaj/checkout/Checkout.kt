package com.supermarket.gaj.checkout

import com.supermarket.gaj.calculator.TotalCalculator
import com.supermarket.gaj.item.Item
import com.supermarket.gaj.promotion.Promotion

class Checkout(
    private val items: MutableList<Item> = mutableListOf(),
    private val discounts: MutableList<Promotion> = mutableListOf(),
    private val totalCalculator: TotalCalculator = TotalCalculator(items, discounts)
) {
    fun scan(item: Item) = items.add(item)

    fun add(promotion: Promotion) = discounts.add(promotion)

    fun total() = totalCalculator.calculate()
}