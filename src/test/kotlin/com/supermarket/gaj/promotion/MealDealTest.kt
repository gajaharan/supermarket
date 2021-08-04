package com.supermarket.gaj.promotion

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class MealDealTest {
    private val mealDeal: MealDeal = MealDeal()

    @Test
    fun `apply MealDeal promotion when zero items then should return no savings`() {
        val actualSavings = mealDeal.apply(emptyList())
        Assertions.assertEquals(BigDecimal("0.00"), actualSavings)
    }
}