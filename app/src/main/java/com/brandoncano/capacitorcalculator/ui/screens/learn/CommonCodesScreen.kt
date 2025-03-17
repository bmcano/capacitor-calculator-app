package com.brandoncano.capacitorcalculator.ui.screens.learn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.data.CapacitorCodeConversions
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppDivider
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTopAppBar
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleBody
import com.brandoncano.sharedcomponents.text.textStyleHeadline
import com.brandoncano.sharedcomponents.text.textStyleSubhead

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
        // Note: we don't use WindowInsets.safeDrawing since this is a special scrolling screen
        contentWindowInsets = WindowInsets(bottom = 0.dp)
    ) { paddingValues ->
        CommonCodesScreenContent(paddingValues)
    }
}

@Composable
private fun CommonCodesScreenContent(paddingValues: PaddingValues) {
    val sidePadding = dimensionResource(R.dimen.app_side_padding)
    val codes = CapacitorCodeConversions.entries
    val labels = listOf(
        stringResource(id = R.string.common_codes_code),
        stringResource(id = R.string.common_codes_pf),
        stringResource(id = R.string.common_codes_nf),
        stringResource(id = R.string.common_codes_uf),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = sidePadding),
    ) {
        Text(
            text = stringResource(R.string.common_codes_body),
            modifier = Modifier.padding(top = 24.dp, bottom = 24.dp),
            style = textStyleBody()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            labels.forEach {
                Text(
                    text = it,
                    modifier = Modifier.weight(1f),
                    style = textStyleHeadline(),
                    textAlign = TextAlign.Center,
                )
            }
        }
        AppDivider(modifier = Modifier.padding(horizontal = 0.dp))

        LazyColumn {
            itemsIndexed(codes) { index, code ->
                ChartTableRow(code)
                if (codes.size - 1 != index) {
                    AppDivider(modifier = Modifier)
                }
            }
            item {
                Spacer(modifier = Modifier.height(48.dp))
            }
        }
    }
}

@Composable
private fun ChartTableRow(row: CapacitorCodeConversions) {
    Row(
        modifier = Modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth()
    ) {
        row.asList().forEach { value ->
            Text(
                text = value,
                modifier = Modifier.weight(1f),
                style = textStyleSubhead().onSurfaceVariant(),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@AppScreenPreviews
@Composable
private fun ChartPreview() {
    CapacitorCalculatorTheme {
        CommonCodesScreen {}
    }
}
