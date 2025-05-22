package com.brandoncano.capacitorcalculator.ui.screens.learn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
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
import com.brandoncano.capacitorcalculator.ui.composables.BottomScreenSpacer
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppBulletList
import com.brandoncano.sharedcomponents.composables.AppDivider
import com.brandoncano.sharedcomponents.composables.AppLongScreenPreview
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTopAppBar
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleHeadline
import com.brandoncano.sharedcomponents.text.textStyleSubhead

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
        contentWindowInsets = WindowInsets.safeDrawing,
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
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.capacitor_values_capacitance_header),
            style = textStyleHeadline(),
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(id = R.string.capacitor_values_capacitance_subhead),
            style = textStyleSubhead().onSurfaceVariant()
        )
        Spacer(modifier = Modifier.height(8.dp))
        AppBulletList(
            bulletStrings = listOf(
                stringResource(id = R.string.capacitor_values_capacitance_bullet_1),
                stringResource(id = R.string.capacitor_values_capacitance_bullet_2),
                stringResource(id = R.string.capacitor_values_capacitance_bullet_3),
            ),
            textStyle = textStyleSubhead().onSurfaceVariant(),
        )
        AppDivider(modifier = Modifier.padding(vertical = 16.dp))
        Text(
            text = stringResource(id = R.string.capacitor_values_tolerance_header),
            style = textStyleHeadline(),
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(id = R.string.capacitor_values_tolerance_subhead),
            style = textStyleSubhead().onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(24.dp))
        ToleranceTable()
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(id = R.string.capacitor_values_voltage_header),
            style = textStyleHeadline(),
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(id = R.string.capacitor_values_voltage_subhead),
            style = textStyleSubhead().onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(24.dp))
        VoltageRatingTable()
        BottomScreenSpacer()
    }
}

@AppScreenPreviews
@AppLongScreenPreview
@Composable
private fun CapacitorValuesPreview() {
    CapacitorCalculatorTheme {
        CapacitorValuesScreen {}
    }
}
