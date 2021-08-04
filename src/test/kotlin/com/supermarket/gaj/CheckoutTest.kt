package com.supermarket.gaj

import com.supermarket.gaj.checkout.Checkout
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class CheckoutTest {

    @Test
    fun `checkout provides it's total value zero when containing no items`() {
        val expectedTotal = 0;
        val checkout = Checkout(listOf())
        assertEquals(BigDecimal(expectedTotal), checkout.total())
    }
}