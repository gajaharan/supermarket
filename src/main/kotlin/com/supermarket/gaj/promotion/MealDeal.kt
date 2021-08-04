package com.supermarket.gaj.promotion

import com.supermarket.gaj.item.Item
import java.math.BigDecimal

class MealDeal : Promotion {
    override fun apply(items: List<Item>): BigDecimal {
        return BigDecimal.ZERO.setScale(2)
    }
}