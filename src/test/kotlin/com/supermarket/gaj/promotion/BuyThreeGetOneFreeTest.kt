package com.supermarket.gaj.promotion

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
}