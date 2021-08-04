package com.supermarket.gaj

import com.supermarket.gaj.checkout.Checkout
import com.supermarket.gaj.item.SKU
import com.supermarket.gaj.item.UnitItem
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class CheckoutTest {
    @Test
    fun `checkout provides it's total value zero when containing no items`() {
        val expectedTotal = "0.00";
        val checkout = Checkout()
        assertEquals(BigDecimal(expectedTotal), checkout.total())
    }

    @Test
    fun `checkout provides it's total value when containing a single item`() {
        val expectedTotal = "0.50";
        val items = listOf(
            UnitItem(SKU.A, BigDecimal("0.50"))
        )
        val checkout = Checkout()
        items.forEach { checkout.scan(it) }
        assertEquals(BigDecimal(expectedTotal), checkout.total())
    }

    @Test
    fun `checkout provides it's total value when containing two items`() {
        val expectedTotal = "1.10";
        val items = listOf(
            UnitItem(SKU.A, BigDecimal("0.50")),
            UnitItem(SKU.B, BigDecimal("0.60"))
        )
        val checkout = Checkout()
        items.forEach { checkout.scan(it) }
        assertEquals(BigDecimal(expectedTotal), checkout.total())
    }
}