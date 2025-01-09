package com.brandoncano.capacitorcalculator.model.capacitoradvanced

import com.brandoncano.capacitorcalculator.constants.Units
import com.brandoncano.capacitorcalculator.util.formatCapacitance
import com.brandoncano.capacitorcalculator.util.getTolerancePercentage
import com.brandoncano.capacitorcalculator.util.getVoltageRating

data class CapacitorAdvanced(
    var code: String = "",
    var capacitance: String = "",
    var tolerance: String = "",
    var units: String = "",
    val voltageRating: String = "",
) {
    fun isEmpty(isCode: Boolean = true): Boolean {
        if (isCode) {
            return code.isEmpty() || code.length < 2
        }
        return capacitance.isEmpty() || (units == Units.PF && capacitance.length < 2)
    }

    override fun toString(): String {
        val code = "$code$tolerance $voltageRating"
        val capacitance = formatCapacitance()
        val tolerance = getTolerancePercentage()
        val voltageRating = getVoltageRating()
        return "$code\n$capacitance $tolerance $voltageRating".trimEnd(' ')
    }
}
