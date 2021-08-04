package com.supermarket.gaj.item

import java.math.BigDecimal

interface Item {
    fun unitPrice(): BigDecimal
    fun itemSKU(): SKU
}