package com.brandoncano.capacitorcalculator.ui.screens.learn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppDivider
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTopAppBar
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleBody
import com.brandoncano.sharedcomponents.text.textStyleCallout
import com.brandoncano.sharedcomponents.text.textStyleTitle

@Composable
fun LearnSmdCapacitorCodesScreen(
    onNavigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppTopAppBar(
                titleText = stringResource(R.string.smd_info_title),
                navigationIcon = Icons.Filled.Close,
                onNavigateBack = onNavigateBack,
            )
        },
        contentWindowInsets = WindowInsets.safeDrawing,
    ) { paddingValues ->
        LearnSmdCapacitorCodesScreenContent(paddingValues)
    }
}

@Composable
private fun LearnSmdCapacitorCodesScreenContent(paddingValues: PaddingValues) {
    val sidePadding = dimensionResource(R.dimen.app_side_padding)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)
            .padding(horizontal = sidePadding)
            .imePadding(),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = stringResource(R.string.smd_info_intro_title),
            modifier = Modifier.padding(vertical = 12.dp),
            style = textStyleTitle(),
        )
        Text(
            text = stringResource(R.string.smd_info_intro_body_1),
            modifier = Modifier.padding(bottom = 12.dp),
            style = textStyleBody().onSurfaceVariant(),
        )
        Text(
            text = stringResource(R.string.smd_info_intro_body_2),
            modifier = Modifier.padding(bottom = 32.dp),
            style = textStyleBody().onSurfaceVariant(),
        )

        CodeInfoSection(
            headlineRes = R.string.smd_three_code_title,
            bodyRes = R.string.smd_three_code_body,
            formulaRes = R.string.smd_three_digit_formula,
            exampleLabelRes = R.string.smd_three_digit_example_label,
            exampleRes = R.string.smd_three_digit_example,
        )
        Spacer(modifier = Modifier.height(32.dp))

        CodeInfoSection(
            headlineRes = R.string.smd_four_code_title,
            bodyRes = R.string.smd_four_code_body,
            formulaRes = R.string.smd_four_digit_formula,
            exampleLabelRes = R.string.smd_four_digit_example_label,
            exampleRes = R.string.smd_four_digit_example,
        )
        AppDivider(modifier = Modifier.padding(vertical = 16.dp))
        Text(
            text = stringResource(R.string.smd_four_digit_note),
            modifier = Modifier.padding(bottom = 32.dp),
            style = textStyleCallout().onSurfaceVariant(),
        )

        CodeInfoSection(
            headlineRes = R.string.smd_eia_198_title,
            bodyRes = R.string.smd_eia_198_body,
            formulaRes = R.string.smd_eia_198_formula,
            exampleLabelRes = R.string.smd_eia_198_example_label,
            exampleRes = R.string.smd_eia_198_example,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.smd_eia_198_base_capacitance_title),
            style = textStyleTitle(),
        )
        Text(
            text = stringResource(id = R.string.smd_eia_198_base_capacitance_body),
            modifier = Modifier.padding(vertical = 12.dp),
            style = textStyleBody().onSurfaceVariant(),
        )
        SmdBaseCapacitanceTableWithSearch()
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@AppScreenPreviews
@Composable
private fun LearnSmdCodesPreview() {
    CapacitorCalculatorTheme {
        LearnSmdCapacitorCodesScreen {}
    }
}
