package com.supermarket.gaj.promotion

import com.supermarket.gaj.item.SKU
import com.supermarket.gaj.item.UnitItem
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class BuyTwoForOnePoundTest {
    private val buyTwoForOnePound: BuyTwoForOnePound = BuyTwoForOnePound(SKU.B)

    @Test
    fun `apply 2For1pound promotion when zero items scanned then should return no savings`() {
        val actualSavings = buyTwoForOnePound.apply(emptyList())
        Assertions.assertEquals(BigDecimal("0.00"), actualSavings)
    }

    @Test
    fun `apply 2For1pound promotion when two same items scanned then should return savings`() {
        val items = listOf(
            UnitItem(SKU.B, BigDecimal("0.60")),
            UnitItem(SKU.B, BigDecimal("0.60"))
        )
        val actualSavings = buyTwoForOnePound.apply(items)
        Assertions.assertEquals(BigDecimal("0.20"), actualSavings)
    }

    @Test
    fun `apply 2For1pound promotion when four same items then should return savings`() {
        val items = listOf(
            UnitItem(SKU.B, BigDecimal("0.60")),
            UnitItem(SKU.B, BigDecimal("0.60")),
            UnitItem(SKU.B, BigDecimal("0.60")),
            UnitItem(SKU.B, BigDecimal("0.60"))
        )
        val actualSavings = buyTwoForOnePound.apply(items)
        Assertions.assertEquals(BigDecimal("0.40"), actualSavings)
    }


    @Test
    fun `apply 2For1pound promotion when two same items and two different items then should return savings`() {
        val items = listOf(
            UnitItem(SKU.A, BigDecimal("0.50")),
            UnitItem(SKU.B, BigDecimal("0.60")),
            UnitItem(SKU.A, BigDecimal("0.50")),
            UnitItem(SKU.B, BigDecimal("0.60"))
        )
        val actualSavings = buyTwoForOnePound.apply(items)
        Assertions.assertEquals(BigDecimal("0.20"), actualSavings)
    }
}