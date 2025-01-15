package com.brandoncano.capacitorcalculator.ui.screens.learn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
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
import com.brandoncano.sharedcomponents.text.textStyleHeadline
import com.brandoncano.sharedcomponents.text.textStyleTitle

@Composable
fun LearnSmdCapacitorCodesScreen(
    onNavigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppTopAppBar(
                titleText = stringResource(R.string.cap_info_title),
                navigationIcon = Icons.Filled.Close,
                onNavigateBack = onNavigateBack,
            )
        },
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
            .padding(horizontal = sidePadding),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = stringResource(R.string.cap_info_intro_title),
            modifier = Modifier.padding(vertical = 12.dp),
            style = textStyleTitle(),
        )
        Text(
            text = stringResource(R.string.cap_info_intro_body),
            modifier = Modifier.padding(bottom = 12.dp),
            style = textStyleBody().onSurfaceVariant(),
        )
        Text(
            text = stringResource(R.string.cap_info_codes_body),
            modifier = Modifier.padding(bottom = 32.dp),
            style = textStyleBody().onSurfaceVariant(),
        )

        CodeInfoSection(
            headlineRes = R.string.cap_three_code_headline,
            bodyRes = R.string.cap_three_code_body,
            formulaRes = R.string.cap_three_digit_formula,
            exampleRes = R.string.cap_three_digit_example,
            code = "Code: xyz",
            exampleCode = "Code: 113",
        )
        Spacer(modifier = Modifier.height(32.dp))
        CodeInfoSection(
            headlineRes = R.string.cap_four_code_headline,
            bodyRes = R.string.cap_four_code_body,
            formulaRes = R.string.cap_four_digit_formula,
            exampleRes = R.string.cap_four_digit_example,
            code = "Code: xyz t",
            exampleCode = "Code: 222J",
        )
        AppDivider(modifier = Modifier.padding(vertical = 16.dp))
        Text(
            text = stringResource(R.string.cap_four_digit_note),
            modifier = Modifier.padding(bottom = 32.dp),
            style = textStyleCallout().onSurfaceVariant(),
        )
        CodeInfoSection(
            headlineRes = R.string.cap_eia_198_headline,
            bodyRes = R.string.cap_eia_198_body,
            formulaRes = R.string.cap_eia_198_formula,
            exampleRes = R.string.cap_eia_198_example,
            code = "Code: xy",
            exampleCode = "Code: B2",
        )
        Spacer(modifier = Modifier.height(24.dp))
        SmdBaseCapacitanceTable()
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
private fun CodeInfoSection(
    headlineRes: Int,
    bodyRes: Int,
    formulaRes: Int,
    exampleRes: Int,
    code: String,
    exampleCode: String,
) {
    Text(
        text = stringResource(headlineRes),
        modifier = Modifier.padding(bottom = 12.dp),
        style = textStyleTitle(),
    )
    Text(
        text = stringResource(bodyRes),
        modifier = Modifier.padding(bottom = 12.dp),
        style = textStyleBody().onSurfaceVariant(),
    )
    CodeExampleCard(
        code = code,
        description = stringResource(formulaRes),
    )
    Text(
        text = stringResource(R.string.info_smd_code_example),
        modifier = Modifier.padding(vertical = 12.dp),
        style = textStyleBody().onSurfaceVariant(),
    )
    CodeExampleCard(
        code = exampleCode,
        description = stringResource(exampleRes),
    )
}

@Composable
private fun CodeExampleCard(code: String, description: String) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp)) {
            Text(
                text = code,
                style = textStyleHeadline(),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                style = textStyleBody().onSurfaceVariant(),
            )
        }
    }
}

@AppScreenPreviews
@Composable
private fun LearnSmdCodesPreview() {
    CapacitorCalculatorTheme {
        LearnSmdCapacitorCodesScreen {}
    }
}
