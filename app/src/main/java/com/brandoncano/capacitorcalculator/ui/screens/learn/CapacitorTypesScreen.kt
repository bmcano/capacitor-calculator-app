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
import com.brandoncano.sharedcomponents.text.textStyleCaption
import com.brandoncano.sharedcomponents.text.textStyleHeadline
import com.brandoncano.sharedcomponents.text.textStyleSubhead

@Composable
fun CapacitorTypesScreen(
    onNavigateBack: () -> Unit,
    onCapacitorTypeClicks: List<() -> Unit>,
) {
    Scaffold(
        topBar = {
            AppTopAppBar(
                titleText = stringResource(R.string.information_title),
                navigationIcon =  Icons.Filled.Close,
                onNavigateBack = onNavigateBack,
            )
        },
    ) { paddingValues ->
        CapacitorTypesScreenContent(
            paddingValues = paddingValues,
            onCapacitorTypeClicks = onCapacitorTypeClicks,
        )
    }
}

@Composable
private fun CapacitorTypesScreenContent(
    paddingValues: PaddingValues,
    onCapacitorTypeClicks: List<() -> Unit>,
) {
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
            text = stringResource(id = R.string.information_header_text),
            modifier = Modifier.padding(top = 24.dp, bottom = 12.dp),
            style = textStyleHeadline().onSurfaceVariant(),
        )
        Text(
            text = stringResource(id = R.string.information_body_text),
            modifier = Modifier.padding(bottom = 24.dp),
            style = textStyleSubhead().onSurfaceVariant(),
        )
        // Note: Order and categorization was done similar to Wikipedia
        ArrowCardButtonWithSubText(
            cardTexts = listOf(
                stringResource(id = R.string.information_ceramic_header),
                stringResource(id = R.string.information_film_header),
                stringResource(id = R.string.information_electrolytic_header),
                stringResource(id = R.string.information_polymer_header),
                stringResource(id = R.string.information_super_header),
                stringResource(id = R.string.information_mica_header),
                stringResource(id = R.string.information_variable_header),
            ),
            subTexts = listOf(
                emptyList(),
                listOf(
                    stringResource(id = R.string.information_film_subtext_1),
                    stringResource(id = R.string.information_film_subtext_2),
                    stringResource(id = R.string.information_film_subtext_3),
                    stringResource(id = R.string.information_film_subtext_4),
                    stringResource(id = R.string.information_film_subtext_5),
                    stringResource(id = R.string.information_film_subtext_6),
                    stringResource(id = R.string.information_film_subtext_7),
                ),
                listOf(
                    stringResource(id = R.string.information_electrolytic_subtext_1),
                    stringResource(id = R.string.information_electrolytic_subtext_2),
                    stringResource(id = R.string.information_electrolytic_subtext_3)
                ),
                listOf(
                    stringResource(id = R.string.information_polymer_subtext_1),
                    stringResource(id = R.string.information_polymer_subtext_2),
                    stringResource(id = R.string.information_polymer_subtext_3),
                    stringResource(id = R.string.information_polymer_subtext_4),
                ),
                emptyList(),
                emptyList(),
                listOf(
                    stringResource(id = R.string.information_variable_subtext_1),
                    stringResource(id = R.string.information_variable_subtext_2),
                    stringResource(id = R.string.information_variable_subtext_3),
                    stringResource(id = R.string.information_variable_subtext_4),
                    stringResource(id = R.string.information_variable_subtext_5),
                ),
            ),
            onClicks = onCapacitorTypeClicks,
        )
        AppDivider(modifier = Modifier.padding(vertical = 24.dp))
        Text(
            text = stringResource(id = R.string.information_footer_text),
            style = textStyleCaption().onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@AppScreenPreviews
@Composable
private fun CapacitorTypesPreview() {
    CapacitorCalculatorTheme {
        CapacitorTypesScreen(
            onNavigateBack = {},
            onCapacitorTypeClicks = listOf(),
        )
    }
}
