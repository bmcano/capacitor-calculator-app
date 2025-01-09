package com.brandoncano.capacitorcalculator.model.capacitor

import androidx.lifecycle.ViewModel
import com.brandoncano.capacitorcalculator.constants.Units
import com.brandoncano.capacitorcalculator.data.CapacitorValue
import com.brandoncano.capacitorcalculator.util.formatCapacitance
import com.brandoncano.capacitorcalculator.util.formatCode
import com.brandoncano.capacitorcalculator.util.isCapacitanceValid
import com.brandoncano.capacitorcalculator.util.isCodeValid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CapacitorViewModel : ViewModel() {

    private val _capacitor = MutableStateFlow(Capacitor())
    val capacitor: StateFlow<Capacitor> get() = _capacitor

    private val _isCodeError = MutableStateFlow(false)
    val isCodeError: StateFlow<Boolean> get() = _isCodeError

    private val _isCapacitanceError = MutableStateFlow(false)
    val isCapacitanceError: StateFlow<Boolean> get() = _isCapacitanceError

    fun clear() {
        _capacitor.value = Capacitor()
        _isCodeError.value = false
    }

    fun updateValues(value: String, capacitorValue: CapacitorValue) {
        when (capacitorValue) {
            CapacitorValue.Code -> {
                _capacitor.value = _capacitor.value.copy(code = value)
                updateErrorState()
                if (!_isCodeError.value) {
                    _capacitor.value = _capacitor.value.copy(
                        pf = value.formatCapacitance(Units.PF),
                        nf = value.formatCapacitance(Units.NF),
                        uf = value.formatCapacitance(Units.UF),
                    )
                }
            }
            CapacitorValue.PF -> {
                _capacitor.value = _capacitor.value.copy(pf = value)
                updateCapacitanceErrorState(value, Units.PF)
                if (!_isCapacitanceError.value) {
                    val code = value.formatCode(Units.PF)
                    _capacitor.value = _capacitor.value.copy(
                        code = code,
                        nf = code.formatCapacitance(Units.NF),
                        uf = code.formatCapacitance(Units.UF),
                    )
                }
            }
            CapacitorValue.NF -> {
                _capacitor.value = _capacitor.value.copy(nf = value)
                updateCapacitanceErrorState(value, Units.NF)
                if (!_isCapacitanceError.value) {
                    val code = value.formatCode(Units.NF)
                    _capacitor.value = _capacitor.value.copy(
                        code = code,
                        pf = code.formatCapacitance(Units.PF),
                        uf = code.formatCapacitance(Units.UF),
                    )
                }
            }
            CapacitorValue.UF -> {
                _capacitor.value = _capacitor.value.copy(uf = value)
                updateCapacitanceErrorState(value, Units.UF)
                if (!_isCapacitanceError.value) {
                    val code = value.formatCode(Units.UF)
                    _capacitor.value = _capacitor.value.copy(
                        code = code,
                        pf = code.formatCapacitance(Units.PF),
                        nf = code.formatCapacitance(Units.NF),
                    )
                }
            }
        }
    }

    fun updateErrorState() {
        _isCodeError.value = !_capacitor.value.isCodeValid()
    }

    fun updateCapacitanceErrorState(value: String, units: String) {
        _isCapacitanceError.value = !value.isCapacitanceValid(units)
    }
}
