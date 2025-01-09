package com.brandoncano.capacitorcalculator.util

import com.brandoncano.capacitorcalculator.data.Tolerance
import com.brandoncano.capacitorcalculator.data.VoltageRating
import com.brandoncano.capacitorcalculator.model.capacitor.Capacitor
import com.brandoncano.capacitorcalculator.model.capacitoradvanced.CapacitorAdvanced
import com.brandoncano.capacitorcalculator.model.smd.SmdCapacitor

/**
 * Job: Holds the extension functions for all the capacitor models
 */

// Capacitor code values
fun Capacitor.isCodeValid(): Boolean {
    return IsValidCode.execute(this.code)
}

fun String.isCapacitanceValid(units: String): Boolean {
    return IsValidCapacitance.execute(this, units)
}

fun String.formatCapacitance(units: String): String {
    return CapacitanceFormatter.execute(this, units)
}

fun String.formatCode(units: String): String {
    return CodeFormatter.execute(this, units)
}

// Capacitor advanced
fun CapacitorAdvanced.isCodeInvalid(): Boolean {
    return !IsValidCode.execute(this.code)
}

fun CapacitorAdvanced.formatCapacitance(): String {
    return CapacitanceFormatter.execute(this.code, this.units)
}

fun CapacitorAdvanced.getTolerancePercentage(): String {
    return Tolerance.getToleranceValue(this.tolerance)
}

fun CapacitorAdvanced.getVoltageRating(): String {
    return VoltageRating.getVoltageValue(this.voltageRating)
}

// SMD capacitor
fun SmdCapacitor.isSmdInputInvalid(): Boolean {
    return !IsValidSmdCode.execute(this.code, this.getSmdMode())
}

fun SmdCapacitor.formatCapacitance(): String {
    return CapacitanceSmdFormatter.execute(this)
}
