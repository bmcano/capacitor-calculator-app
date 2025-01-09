package com.brandoncano.capacitorcalculator.ui.screens.learndetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.data.CapacitorType
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews

@Composable
fun SuperCapacitorView() {
    Column {
        // TODO - image?
        HeaderBodyInformation(
            header = R.string.information_details_general_information,
            R.string.super_details_general_information,
        )
        HeaderBodyInformation(
            header = R.string.information_details_capacitance,
            R.string.super_details_capacitance,
        )
        HeaderBodyInformation(
            header = R.string.information_details_applications,
            R.string.super_details_applications,
        )
    }
}

@AppScreenPreviews
@Composable
fun SuperCapacitorPreview() {
    CapacitorCalculatorTheme {
        InformationDetailsScreen(
            type = CapacitorType.SuperCapacitor,
            onNavigateBack = {},
        )
    }
}
