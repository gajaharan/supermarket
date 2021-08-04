package com.supermarket.gaj.promotion

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class TwoForOnePoundTest {
    private val twoForOnePound: TwoForOnePound = TwoForOnePound()

    @Test
    fun `apply promotion when zero items scanned then should return no savings`() {
        val actualSavings = twoForOnePound.apply(emptyList())
        Assertions.assertEquals(BigDecimal(0.00), actualSavings)
    }
}