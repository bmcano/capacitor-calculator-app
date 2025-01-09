package com.brandoncano.capacitorcalculator.model.capacitoradvanced

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brandoncano.capacitorcalculator.util.formatCapacitance
import com.brandoncano.capacitorcalculator.util.isCodeInvalid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CapacitorAdvancedViewModel(context: Context) : ViewModel() {

    private val repository = CapacitorRepository.getInstance(context)

    private val _capacitor = MutableStateFlow(CapacitorAdvanced())
    val capacitor: StateFlow<CapacitorAdvanced> get() = _capacitor

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
        _capacitor.value = CapacitorAdvanced()
        _isError.value = false
        repository.clear()
    }

    fun updateValues(code: String, units: String, tolerance: String, voltageRating: String) {
        _capacitor.value = _capacitor.value.copy(
            code = code,
            units = units,
            tolerance = tolerance,
            voltageRating = voltageRating
        )
        updateErrorState()
        if (!_isError.value) {
            _capacitor.value.formatCapacitance()
            saveCapacitorValues()
        }
    }

    private fun updateErrorState() {
        _isError.value = _capacitor.value.isCodeInvalid()
    }

    private fun saveCapacitorValues() {
        repository.saveCapacitor(_capacitor.value)
    }
}
