package com.brandoncano.capacitorcalculator.constants

import com.brandoncano.capacitorcalculator.data.Tolerance
import com.brandoncano.capacitorcalculator.data.VoltageRating

object DropdownLists {
    val UNITS = listOf(Units.PF, Units.NF, Units.UF)
    val TOLERANCE = Tolerance.getStandardToleranceLettersList()
    val VOLTAGE_RATING = VoltageRating.getCodeList()
}
