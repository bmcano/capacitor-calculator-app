package com.brandoncano.capacitorcalculator.ui.screens.learndetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.data.CapacitorType
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews

@Composable
fun FilmView() {
    Column {
        // TODO - get film capacitor image(s) at some point (?)
        HeaderBodyInformation(
            header = R.string.information_details_general_information,
            R.string.film_details_general_information,
        )
        HeaderBodyInformation(
            header = R.string.information_details_capacitance,
            R.string.film_details_capacitance,
        )
        HeaderBodyInformation(
            header = R.string.information_film_subtext_1,
            R.string.film_details_characteristics_1,
            R.string.film_details_applications_1,
        )
        HeaderBodyInformation(
            header = R.string.information_film_subtext_2,
            R.string.film_details_characteristics_2,
            R.string.film_details_applications_2,
        )
        HeaderBodyInformation(
            header = R.string.information_film_subtext_3,
            R.string.film_details_characteristics_3,
            R.string.film_details_applications_3,
        )
        HeaderBodyInformation(
            header = R.string.information_film_subtext_4,
            R.string.film_details_characteristics_4,
            R.string.film_details_applications_4,
        )
        HeaderBodyInformation(
            header = R.string.information_film_subtext_5,
            R.string.film_details_characteristics_5,
            R.string.film_details_applications_5,
        )
        HeaderBodyInformation(
            header = R.string.information_film_subtext_6,
            R.string.film_details_characteristics_6,
            R.string.film_details_applications_6,
        )
        HeaderBodyInformation(
            header = R.string.information_film_subtext_7,
            R.string.film_details_characteristics_7,
            R.string.film_details_applications_7,
        )
    }
}

@AppScreenPreviews
@Composable
private fun FilmPreview() {
    CapacitorCalculatorTheme {
        InformationDetailsScreen(
            type = CapacitorType.Film,
            onNavigateBack = {},
        )
    }
}
