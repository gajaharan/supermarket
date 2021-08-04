package com.supermarket.gaj.promotion

import com.supermarket.gaj.item.Item
import java.math.BigDecimal

interface Promotion {
    fun apply(items: List<Item>): BigDecimal
}