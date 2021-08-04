package com.supermarket.gaj.promotion

import com.supermarket.gaj.item.Item
import com.supermarket.gaj.item.SKU
import java.math.BigDecimal
import java.util.stream.Collectors

class BuyNGetOneFree(
    private val sku: SKU,
    private val multiBuyQuantity: Int
) : Promotion {
    override fun apply(items: List<Item>): BigDecimal {
        if (items.isEmpty()) {
            return BigDecimal.ZERO.setScale(2)
        }

        val commonItems = items.stream()
            .filter { it.itemSKU() == sku }
            .collect(Collectors.toUnmodifiableList())

        val unitPrice = commonItems.first().unitPrice()
        val packNumber = items.size / multiBuyQuantity
        return unitPrice.multiply(BigDecimal(packNumber))
    }
}
