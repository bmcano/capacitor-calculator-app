package com.brandoncano.capacitorcalculator.ui.screens.learndetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.data.CapacitorType
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews

@Composable
fun CeramicView() {
    Column {
        CeramicCapacitorImage()
        HeaderBodyInformation(
            header = R.string.information_details_general_information,
            R.string.ceramic_details_general_information_1,
            R.string.ceramic_details_general_information_2,
        )
        HeaderBodyInformation(
            header = R.string.information_details_capacitance,
            R.string.ceramic_details_capacitance,
        )
        HeaderBodyInformation(
            header =  R.string.information_details_applications,
            R.string.ceramic_details_applications_1,
            R.string.ceramic_details_applications_2,
            R.string.ceramic_details_applications_3,
        )
    }
}

@AppScreenPreviews
@Composable
private fun CeramicPreview() {
    CapacitorCalculatorTheme {
        InformationDetailsScreen(
            type = CapacitorType.Ceramic,
            onNavigateBack = {},
        )
    }
}
