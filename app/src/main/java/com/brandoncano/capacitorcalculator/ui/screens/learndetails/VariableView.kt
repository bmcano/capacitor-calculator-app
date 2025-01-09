package com.brandoncano.capacitorcalculator.ui.screens.learndetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.data.CapacitorType
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews

@Composable
fun VariableView() {
    Column {
        // TODO - add images?
        HeaderBodyInformation(
            header = R.string.information_details_general_information,
            R.string.variable_details_general_information,
        )
        HeaderBodyInformation(
            header = R.string.information_details_characteristics,
            R.string.variable_details_characteristics_1,
            R.string.variable_details_characteristics_2,
            R.string.variable_details_characteristics_3,
            R.string.variable_details_characteristics_4,
        )
        HeaderBodyInformation(
            header = R.string.information_details_applications,
            R.string.variable_details_applications,
        )
    }
}

@AppScreenPreviews
@Composable
private fun VariablePreview() {
    CapacitorCalculatorTheme {
        InformationDetailsScreen(
            type = CapacitorType.Variable,
            onNavigateBack = {},
        )
    }
}
