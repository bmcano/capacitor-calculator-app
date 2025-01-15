package com.brandoncano.capacitorcalculator.ui.screens.learndetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.data.CapacitorType
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews

@Composable
fun ElectrolyticView() {
    Column {
        CapacitorImage(R.drawable.img_electrolytic)
        HeaderBodyInformation(
            header = R.string.information_details_general_information,
            R.string.electrolytic_details_general_information,
        )
        HeaderBodyInformation(
            header = R.string.information_details_capacitance,
            R.string.electrolytic_details_capacitance_1,
            R.string.electrolytic_details_capacitance_2,
        )
        HeaderBodyInformation(
            header =  R.string.information_details_characteristics,
            R.string.electrolytic_details_characteristics_1,
            R.string.electrolytic_details_characteristics_2,
            R.string.electrolytic_details_characteristics_3,
        )
        HeaderBodyInformation(
            header = R.string.information_details_applications,
            R.string.electrolytic_details_applications,
        )
    }
}

@AppScreenPreviews
@Composable
private fun ElectrolyticPreview() {
    CapacitorCalculatorTheme {
        InformationDetailsScreen(
            type = CapacitorType.Electrolytic,
            onNavigateBack = {},
        )
    }
}
