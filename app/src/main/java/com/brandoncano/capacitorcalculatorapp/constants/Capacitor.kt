package com.brandoncano.capacitorcalculatorapp.constants

import com.brandoncano.capacitorcalculatorapp.util.MultiplierFromDigit

data class Capacitor(
    var code: String = "",
    var pf: String = "",
    var nf: String = "",
    var uf: String = "",
) {
    fun computeFromCode() {
        val number = if (code.length == 3) code.dropLast(1).toInt() else code.toInt()
        val multiplier = if (code.length == 3) code.takeLast(1) else "0"
        val pico = number * MultiplierFromDigit.execute(multiplier)
        pf = "$pico"
        nf = "${pico.toDouble()/1000}"
        uf = "${pico.toDouble()/1000000}"
    }

    fun computeFromPF() {


        nf = "${pf.toDouble()/1000}"
        uf = "${pf.toDouble()/1000000}"
    }

    fun computeFromNF() {
        pf = "${nf.toDouble() * 1000}"
        uf = "${nf.toDouble()/1000}"
    }

    fun computeFromUF() {
        pf = "${uf.toDouble() * 1000000}"
        nf = "${uf.toDouble() * 1000}"
    }
}
