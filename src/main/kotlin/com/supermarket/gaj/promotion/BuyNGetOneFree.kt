package com.supermarket.gaj.promotion

import com.supermarket.gaj.item.Item
import java.math.BigDecimal

class BuyNGetOneFree(private val multiBuyQuantity: Int) {
    fun apply(items: List<Item>): BigDecimal {
        if (items.isEmpty()) {
            return BigDecimal.ZERO.setScale(2)
        }

        val unitPrice = items.first().unitPrice()
        val packNumber = items.size / multiBuyQuantity
        return unitPrice.multiply(BigDecimal(packNumber))
    }
}
