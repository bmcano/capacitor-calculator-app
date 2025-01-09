package com.brandoncano.capacitorcalculator.ui.screens.learn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTopAppBar
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleSubhead
import com.brandoncano.sharedcomponents.text.textStyleTitle

@Composable
fun CapacitorValuesScreen(
    onNavigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppTopAppBar(
                titleText = stringResource(R.string.capacitor_values_title),
                navigationIcon =  Icons.Filled.Close,
                onNavigateBack = onNavigateBack,
            )
        },
    ) { paddingValues ->
        CapacitorValuesScreenContent(paddingValues)
    }
}

@Composable
private fun CapacitorValuesScreenContent(paddingValues: PaddingValues) {
    val sidePadding = dimensionResource(R.dimen.app_side_padding)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)
            .padding(horizontal = sidePadding),
    ) {
        Text(
            text = stringResource(id = R.string.capacitor_values_capacitance_header),
            modifier = Modifier.padding(top = 12.dp),
            style = textStyleTitle()
        )
        Text(
            text = stringResource(id = R.string.capacitor_values_capacitance_body),
            modifier = Modifier.padding(top = 12.dp),
            style = textStyleSubhead().onSurfaceVariant()
        )
        Spacer(modifier = Modifier.height(32.dp))
        ToleranceTable()
        Spacer(modifier = Modifier.height(32.dp))
        VoltageRatingTable()
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@AppScreenPreviews
@Composable
private fun CapacitorValuesPreview() {
    CapacitorCalculatorTheme {
        CapacitorValuesScreen {}
    }
}
