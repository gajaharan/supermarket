package com.supermarket.gaj.promotion

import com.supermarket.gaj.item.Item
import java.math.BigDecimal

class TwoForOnePound {
    fun apply(items: List<Item>): BigDecimal {
        if (items.isEmpty()) {
            return BigDecimal.ZERO.setScale(2)
        }

        val pairs = items.size / 2
        return items.first().unitPrice()
            .multiply(BigDecimal(2))
            .subtract(BigDecimal("1.00"))
            .multiply(BigDecimal(pairs))
    }
}