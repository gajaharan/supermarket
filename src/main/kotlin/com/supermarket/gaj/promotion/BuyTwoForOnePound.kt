package com.supermarket.gaj.promotion

import com.supermarket.gaj.item.Item
import com.supermarket.gaj.item.SKU
import java.math.BigDecimal
import java.util.stream.Collectors

class BuyTwoForOnePound(private val sku: SKU) : Promotion {
    override fun apply(items: List<Item>): BigDecimal {
        if (items.isEmpty()) {
            return BigDecimal.ZERO.setScale(2)
        }

        val commonItems = items.stream()
            .filter { it.itemSKU() == sku }
            .collect(Collectors.toUnmodifiableList())

        if (commonItems.isEmpty()) {
            return BigDecimal.ZERO.setScale(2)
        }

        val pairs = commonItems.size / BUY_QUANITY
        return commonItems.first().unitPrice()
            .multiply(BigDecimal(BUY_QUANITY))
            .subtract(FIXED_PRICE)
            .multiply(BigDecimal(pairs))
    }

    companion object {
        val FIXED_PRICE = BigDecimal("1.00")
        const val BUY_QUANITY = 2
    }
}