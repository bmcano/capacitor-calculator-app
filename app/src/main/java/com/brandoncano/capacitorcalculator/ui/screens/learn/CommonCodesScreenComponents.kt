package com.brandoncano.capacitorcalculator.ui.screens.learn

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.data.CapacitorCodeConversions
import com.brandoncano.sharedcomponents.composables.AppCard
import com.brandoncano.sharedcomponents.composables.AppDivider
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleHeadline
import com.brandoncano.sharedcomponents.text.textStyleSubhead

@Preview
@Composable
fun ChartRowLabels() {
    val labels = listOf(
        stringResource(id = R.string.common_codes_code),
        stringResource(id = R.string.common_codes_pf),
        stringResource(id = R.string.common_codes_nf),
        stringResource(id = R.string.common_codes_uf),
    )
    AppCard {
        Row(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .fillMaxWidth(),
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
    }
}

@Preview
@Composable
fun ChartTable() {
    val codes = CapacitorCodeConversions.entries
    AppCard {
        LazyColumn {
            itemsIndexed(codes) { index, code ->
                ChartTableRow(code)
                // This check is to replicate the divider logic
                if (codes.size - 1 != index) {
                    AppDivider(modifier = Modifier.padding(horizontal = 16.dp))
                }
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
