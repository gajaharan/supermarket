package com.supermarket.gaj.promotion

import com.supermarket.gaj.item.Item
import java.math.BigDecimal

class BuyThreeGetOneFree {
    fun apply(items: List<Item>): BigDecimal {
        if (items.isEmpty()) {
            return BigDecimal.ZERO.setScale(2)
        }

        val unitPrice = items.first().unitPrice()
        val packNumber = items.size / MULTI_BUY_QUANITY
        return unitPrice.multiply(BigDecimal(packNumber))
    }

    companion object {
        const val MULTI_BUY_QUANITY = 2
    }
}
