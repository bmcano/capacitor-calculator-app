package com.brandoncano.capacitorcalculator.ui.screens.learndetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.data.CapacitorType
import com.brandoncano.sharedcomponents.composables.AppTopAppBar

@Composable
fun InformationDetailsScreen(
    type: CapacitorType,
    onNavigateBack: () -> Unit,
) {
    val stringResource = when (type) {
        CapacitorType.Ceramic -> R.string.ceramic_details_title
        CapacitorType.Film -> R.string.film_details_title
        CapacitorType.Electrolytic -> R.string.electrolytic_title
        CapacitorType.Polymer -> R.string.polymer_title
        CapacitorType.SuperCapacitor -> R.string.super_title
        CapacitorType.Mica -> R.string.mica_title
        CapacitorType.Variable -> R.string.variable_title
    }
    Scaffold(
        topBar = {
            AppTopAppBar(
                titleText = stringResource(stringResource),
                navigationIcon =  Icons.Filled.Close,
                onNavigateBack = onNavigateBack,
            )
        },
    ) { paddingValues ->
        val sidePadding = dimensionResource(R.dimen.app_side_padding)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(horizontal = sidePadding),
            horizontalAlignment = Alignment.Start,
        ) {
            when (type) {
                CapacitorType.Ceramic -> CeramicView()
                CapacitorType.Film -> FilmView()
                CapacitorType.Electrolytic -> ElectrolyticView()
                CapacitorType.Polymer -> PolymerView()
                CapacitorType.SuperCapacitor -> SuperCapacitorView()
                CapacitorType.Mica -> MicaView()
                CapacitorType.Variable -> VariableView()
            }
            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}
