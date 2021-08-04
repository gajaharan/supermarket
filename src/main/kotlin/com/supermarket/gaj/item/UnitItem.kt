package com.supermarket.gaj.item

import java.math.BigDecimal

class UnitItem(private val sku: SKU, private val price: BigDecimal) : Item {
    override fun unitPrice() = price

    override fun itemSKU() = sku
}