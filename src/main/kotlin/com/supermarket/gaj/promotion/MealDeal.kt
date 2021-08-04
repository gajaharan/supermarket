package com.supermarket.gaj.promotion

import com.supermarket.gaj.item.Item
import com.supermarket.gaj.item.SKU
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.stream.Collectors

class MealDeal(private val mealDealSKUs: Set<SKU>) : Promotion {

    override fun apply(items: List<Item>): BigDecimal {
        val commonItems = items.stream()
            .filter { mealDealSKUs.contains(it.itemSKU()) }
            .collect(Collectors.toUnmodifiableList())

        val mealTotal = commonItems.stream()
            .map { it.unitPrice() }
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .setScale(2, RoundingMode.HALF_UP)

        if (commonItems.size == 0) {
            return BigDecimal.ZERO.setScale(2)
        }

        return mealTotal.subtract(BigDecimal(3.25))
    }
}