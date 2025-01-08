package com.brandoncano.capacitorcalculator.ui.screens.learndetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.data.CapacitorType
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews

@Composable
fun PolymerView() {
    Column {
        // TODO - add image?
        HeaderBodyInformation(
            header = R.string.information_details_general_information,
            R.string.polymer_details_general_information_1,
            R.string.polymer_details_general_information_2,
        )
        HeaderBodyInformation(
            header = R.string.information_details_capacitance,
            R.string.polymer_details_capacitance,
        )
        HeaderBodyInformation(
            header = R.string.information_details_characteristics,
            R.string.polymer_details_characteristics_1,
            R.string.polymer_details_characteristics_2,
            R.string.polymer_details_characteristics_3,
        )
        HeaderBodyInformation(
            header = R.string.information_details_applications,
            R.string.polymer_details_applications,
        )
    }
}

@AppScreenPreviews
@Composable
private fun PolymerPreview() {
    CapacitorCalculatorTheme {
        InformationDetailsScreen(
            type = CapacitorType.Polymer,
            onNavigateBack = {},
        )
    }
}
