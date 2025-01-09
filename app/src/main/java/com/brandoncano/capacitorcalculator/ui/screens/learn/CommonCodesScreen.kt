package com.brandoncano.capacitorcalculator.ui.screens.learn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTopAppBar

@Composable
fun CommonCodesScreen(
    onNavigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppTopAppBar(
                titleText = stringResource(R.string.common_code_title),
                navigationIcon =  Icons.Filled.Close,
                onNavigateBack = onNavigateBack,
            )
        },
    ) { paddingValues ->
        CommonCodesScreenContent(paddingValues)
    }
}

@Composable
private fun CommonCodesScreenContent(paddingValues: PaddingValues) {
    val sidePadding = dimensionResource(R.dimen.app_side_padding)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = sidePadding),
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        ChartRowLabels()
        Spacer(modifier = Modifier.height(12.dp))
        ChartTable()
    }
}

@AppScreenPreviews
@Composable
private fun ChartPreview() {
    CapacitorCalculatorTheme {
        CommonCodesScreen {}
    }
}
