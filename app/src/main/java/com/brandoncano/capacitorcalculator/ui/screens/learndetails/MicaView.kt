package com.brandoncano.capacitorcalculator.ui.screens.learndetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.data.CapacitorType
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews

@Composable
fun MicaView() {
    Column {
        CapacitorImage(R.drawable.img_mica)
        HeaderBodyInformation(
            header = R.string.information_details_general_information,
            R.string.mica_details_general_information,
        )
        HeaderBodyInformation(
            header = R.string.information_details_capacitance,
            R.string.mica_details_capacitance,
        )
        HeaderBodyInformation(
            header = R.string.information_details_characteristics,
            R.string.mica_details_characteristics,
        )
        HeaderBodyInformation(
            header = R.string.information_details_applications,
            R.string.mica_details_applications,
        )
    }
}

@AppScreenPreviews
@Composable
private fun MicaPreview() {
    CapacitorCalculatorTheme {
        InformationDetailsScreen(
            type = CapacitorType.Mica,
            onNavigateBack = {},
        )
    }
}
