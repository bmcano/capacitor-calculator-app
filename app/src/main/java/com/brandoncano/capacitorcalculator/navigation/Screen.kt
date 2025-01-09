package com.brandoncano.capacitorcalculator.navigation

import com.brandoncano.capacitorcalculator.data.CapacitorType
import kotlinx.serialization.Serializable

/**
 * Note: Keep screens in alphabetical order
 */

@Serializable // needed for type-sage navigation
sealed class Screen(val route: String) {
    data object About : Screen("about_screen")
    data object CapacitorAdvancedCalculator : Screen("capacitor_advanced_screen")
    data object CapacitorCodeValues : Screen("capacitor_code_values_screen")
    data object CapacitorTypes : Screen("capacitor_types_screen")

    @Serializable
    data class CapacitorTypeDetails(
        val type: CapacitorType
    ) : Screen("capacitor_details_screen")

    data object CapacitorValues : Screen("capacitor_values_screen")
    data object CommonCodes : Screen("common_codes")
    data object Home : Screen("home_screen")
    data object Smd : Screen("smd_calculator_screen")
}
