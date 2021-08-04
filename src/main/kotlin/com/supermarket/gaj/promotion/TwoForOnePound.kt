package com.supermarket.gaj.promotion

import com.supermarket.gaj.item.Item
import java.math.BigDecimal

class TwoForOnePound {
    fun apply(items: List<Item>) =
        items[0].unitPrice()
            .multiply(BigDecimal(2))
            .subtract(BigDecimal("1.00"))

}