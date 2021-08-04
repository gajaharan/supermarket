package com.supermarket.gaj.checkout

import com.supermarket.gaj.item.SKU
import com.supermarket.gaj.item.UnitItem
import com.supermarket.gaj.promotion.BuyNGetOneFree
import com.supermarket.gaj.promotion.BuyTwoForOnePound
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

    @Test
    fun `checkout provides it's total value when containing a two items with 2for1pound promotion`() {
        val expectedTotal = "1.50";
        val items = listOf(
            UnitItem(SKU.A, BigDecimal("0.50")),
            UnitItem(SKU.B, BigDecimal("0.60")),
            UnitItem(SKU.B, BigDecimal("0.60"))
        )
        val checkout = Checkout()
        items.forEach { checkout.scan(it) }
        assertEquals(BigDecimal(expectedTotal), checkout.total())
    }

    @Test
    fun `checkout provides it's total value when containing two items with two different promotion`() {
        val expectedTotal = "1.75";
        val discounts = listOf(
            BuyNGetOneFree(SKU.C, 3),
            BuyTwoForOnePound(SKU.B)
        )
        val items = listOf(
            UnitItem(SKU.A, BigDecimal(0.50)),
            UnitItem(SKU.B, BigDecimal(0.60)),
            UnitItem(SKU.B, BigDecimal(0.60)),
            UnitItem(SKU.C, BigDecimal(0.25)),
            UnitItem(SKU.C, BigDecimal(0.25)),
            UnitItem(SKU.C, BigDecimal(0.25)),
        )

        val checkout = Checkout()
        items.forEach { checkout.scan(it) }
        discounts.forEach { checkout.add(it) }
        assertEquals(BigDecimal(expectedTotal), checkout.total())
    }
}