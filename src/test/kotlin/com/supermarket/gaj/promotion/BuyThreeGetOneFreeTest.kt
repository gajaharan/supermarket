package com.supermarket.gaj.promotion

import com.supermarket.gaj.item.SKU
import com.supermarket.gaj.item.UnitItem
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class BuyThreeGetOneFreeTest {
    private var buyThreeGetOneFree: BuyThreeGetOneFree = BuyThreeGetOneFree()

    @Test
    fun `apply 3Get1Free promotion when zero items scanned then should return no savings`() {
        val actualSavings = buyThreeGetOneFree.apply(emptyList())
        Assertions.assertEquals(BigDecimal("0.00"), actualSavings)
    }

    @Test
    fun `apply Buy3Get1Free promotion when three same items are added then should return savings`() {
        val items = listOf(
            UnitItem(SKU.C, BigDecimal("0.25")),
            UnitItem(SKU.C, BigDecimal("0.25"))
        )
        val actualSavings = buyThreeGetOneFree.apply(items)
        Assertions.assertEquals(BigDecimal("0.25"), actualSavings)
    }
}