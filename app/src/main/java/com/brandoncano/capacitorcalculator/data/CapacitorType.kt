package com.brandoncano.capacitorcalculator.data

/**
 * Job: For type safe navigation on the capacitor type detail screens
 */
@androidx.annotation.Keep // Helps with minified since it's used for type-safe navigation
enum class CapacitorType {
    Ceramic,
    Film,
    Electrolytic,
    Polymer,
    SuperCapacitor,
    Mica,
    Variable
}
