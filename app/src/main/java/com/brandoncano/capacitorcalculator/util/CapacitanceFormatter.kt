package com.brandoncano.capacitorcalculator.util

import com.brandoncano.capacitorcalculator.constants.Units
import java.math.RoundingMode
import java.text.DecimalFormat

/**
 * Job: Take a code and format the capacitance based on unit
 */
object CapacitanceFormatter {

    private val decimalFormat = DecimalFormat("0.######").apply {
        roundingMode = RoundingMode.HALF_UP
    }

    fun execute(code: String, units: String): String {
        if (code.isEmpty()) return ""
        val number = if (code.length == 3) {
            code.dropLast(1).toIntOrNull() ?: return ""
        } else {
            code.toIntOrNull() ?: return ""
        }
        val multiplier = if (code.length == 3) code.takeLast(1) else "0"
        val pico = number * MultiplierFromDigit.execute(multiplier)
        return when (units) {
            Units.PF -> decimalFormat.format(pico.toDouble())
            Units.NF -> decimalFormat.format(pico.toDouble() / 1_000)
            Units.UF -> decimalFormat.format(pico.toDouble() / 1_000_000)
            else -> decimalFormat.format(pico.toDouble())
        }
    }
}
