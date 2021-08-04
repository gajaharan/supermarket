package com.supermarket.gaj.promotion

import com.supermarket.gaj.item.SKU
import com.supermarket.gaj.item.UnitItem
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class TwoForOnePoundTest {
    private val twoForOnePound: TwoForOnePound = TwoForOnePound()

    @Test
    fun `apply promotion when zero items scanned then should return no savings`() {
        val actualSavings = twoForOnePound.apply(emptyList())
        Assertions.assertEquals(BigDecimal("0.00"), actualSavings)
    }

    @Test
    fun `apply promotion when two same items scanned then should return savings`() {
        val items = listOf(
            UnitItem(SKU.B, BigDecimal("0.60")),
            UnitItem(SKU.B, BigDecimal("0.60"))
        )
        val actualSavings = twoForOnePound.apply(items)
        Assertions.assertEquals(BigDecimal("0.20"), actualSavings)
    }

    @Test
    fun `apply promotion when four same items then should return savings`() {
        val items = listOf(
            UnitItem(SKU.B, BigDecimal("0.60")),
            UnitItem(SKU.B, BigDecimal("0.60")),
            UnitItem(SKU.B, BigDecimal("0.60")),
            UnitItem(SKU.B, BigDecimal("0.60"))
        )
        val actualSavings = twoForOnePound.apply(items)
        Assertions.assertEquals(BigDecimal("0.40"), actualSavings)
    }
}