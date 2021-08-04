package com.supermarket.gaj.promotion

import com.supermarket.gaj.item.SKU
import com.supermarket.gaj.item.UnitItem
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class MealDealTest {
    private val mealDeal: MealDeal = MealDeal(setOf(SKU.D, SKU.E))

    @Test
    fun `apply MealDeal promotion when zero items then should return no savings`() {
        val actualSavings = mealDeal.apply(emptyList())
        Assertions.assertEquals(BigDecimal("0.00"), actualSavings)
    }

    @Test
    fun `apply MealDeal promotion when SKU D and SKU E items are added then should return savings`() {
        val items = listOf(
            UnitItem(SKU.D, BigDecimal("1.50")),
            UnitItem(SKU.E, BigDecimal("2.00"))
        )
        val actualSavings = mealDeal.apply(items)
        Assertions.assertEquals(BigDecimal("0.25"), actualSavings)
    }
}