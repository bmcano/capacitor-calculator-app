package com.brandoncano.capacitorcalculator.model.capacitor

import com.brandoncano.capacitorcalculator.constants.Units

data class Capacitor(
    var code: String = "",
    var uf: String = "",
    var nf: String = "",
    var pf: String = "",
) {
    override fun toString(): String {
        return "$code\n$uf ${Units.UF}\n$nf nF\n$pf pF"
    }
}
