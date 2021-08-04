package com.supermarket.gaj.promotion

import com.supermarket.gaj.item.Item
import com.supermarket.gaj.item.SKU
import java.math.BigDecimal
import java.util.stream.Collectors

class TwoForOnePound(private val sku: SKU) {
    fun apply(items: List<Item>): BigDecimal {
        if (items.isEmpty()) {
            return BigDecimal.ZERO.setScale(2)
        }

        val commonItems = items.stream()
            .filter { it.itemSKU() == sku }
            .collect(Collectors.toUnmodifiableList())

        if (commonItems.isEmpty()) {
            return BigDecimal.ZERO.setScale(2)
        }

        val pairs = commonItems.size / 2
        return commonItems.first().unitPrice()
            .multiply(BigDecimal(2))
            .subtract(FIXED_PRICE)
            .multiply(BigDecimal(pairs))
    }

    companion object {
        val FIXED_PRICE = BigDecimal("1.00")
    }
}