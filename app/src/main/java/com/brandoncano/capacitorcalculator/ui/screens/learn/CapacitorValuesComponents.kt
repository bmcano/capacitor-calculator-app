package com.brandoncano.capacitorcalculator.ui.screens.learn

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.data.Tolerance
import com.brandoncano.capacitorcalculator.data.VoltageRating
import com.brandoncano.sharedcomponents.composables.AppCard
import com.brandoncano.sharedcomponents.composables.AppTable

@Preview
@Composable
fun ToleranceTable() {
    AppCard {
        val colHeader1 = stringResource(id = R.string.capacitor_values_tolerance_letter)
        val colHeader2 = stringResource(id = R.string.capacitor_values_tolerance_percentage)
        val tolerances = Tolerance.entries.map { listOf(it.letter, it.tolerance) }
        AppTable(
            columnTitles = listOf(colHeader1, colHeader2),
            rows = tolerances
        )
    }
}

@Preview
@Composable
fun VoltageRatingTable() {
    AppCard {
        val colHeader1 = stringResource(id = R.string.capacitor_values_voltage_code)
        val colHeader2 = stringResource(id = R.string.capacitor_values_voltage_values)
        val voltages = VoltageRating.entries.map { listOf(it.code, it.voltage) }
        AppTable(
            columnTitles = listOf(colHeader1, colHeader2),
            rows = voltages
        )
    }
}
