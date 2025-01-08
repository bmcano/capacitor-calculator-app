package com.brandoncano.capacitorcalculator.model.smd

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brandoncano.capacitorcalculator.util.formatCapacitance
import com.brandoncano.capacitorcalculator.util.isSmdInputInvalid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SmdCapacitorViewModel(context: Context): ViewModel() {

    private val repository = SmdCapacitorRepository.getInstance(context)

    private val _capacitor = MutableStateFlow(SmdCapacitor())
    val capacitor: StateFlow<SmdCapacitor> get() = _capacitor

    private val _isError = MutableStateFlow(false)
    val isError: StateFlow<Boolean> get() = _isError

    init {
        viewModelScope.launch {
            val loadedResistor = repository.loadCapacitor()
            _capacitor.value = loadedResistor
            updateErrorState()
        }
    }

    fun clear() {
        _capacitor.value = SmdCapacitor(navBarSelection = getNavBarSelection())
        _isError.value = false
        repository.clear()
    }

    fun updateValues(code: String, units: String) {
        _capacitor.value = _capacitor.value.copy(code = code, units = units)
        updateErrorState()
        if (!_isError.value) {
            _capacitor.value.formatCapacitance()
            saveResistorValues()
        }
    }

    fun getNavBarSelection(): Int {
        return _capacitor.value.navBarSelection
    }

    fun saveNavBarSelection(number: Int) {
        val navBarSelection = number.coerceIn(0..2)
        _capacitor.value = _capacitor.value.copy(navBarSelection = navBarSelection)
        updateErrorState()
        if (!_isError.value) {
            _capacitor.value.formatCapacitance()
            saveResistorValues()
        }
        repository.saveNavBarSelection(navBarSelection)
    }

    private fun saveResistorValues() {
        repository.saveCapacitor(_capacitor.value)
    }

    private fun updateErrorState() {
        _isError.value = _capacitor.value.isSmdInputInvalid()
    }
}
