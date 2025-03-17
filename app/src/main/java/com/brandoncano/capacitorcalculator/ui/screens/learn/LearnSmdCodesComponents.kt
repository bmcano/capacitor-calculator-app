package com.brandoncano.capacitorcalculator.ui.screens.learn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.util.FindEIA198Value
import com.brandoncano.sharedcomponents.composables.AppCard
import com.brandoncano.sharedcomponents.composables.AppDivider
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleBody
import com.brandoncano.sharedcomponents.text.textStyleCallout
import com.brandoncano.sharedcomponents.text.textStyleTitle

private data class BaseCapacitanceEntry(val letter: String, val value: Double)

@Composable
fun SmdBaseCapacitanceTableWithSearch() {
    var searchQuery by remember { mutableStateOf("") }
    val entries = remember {
        FindEIA198Value.table.map { (letter, value) ->
            BaseCapacitanceEntry(letter, value)
        }
    }
    val filteredEntries = entries.filter { entry ->
        entry.letter.contains(searchQuery, ignoreCase = true) ||
                entry.value.toString().contains(searchQuery)
    }.sortedBy { it.letter }

    TextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = stringResource(id = R.string.smd_eia_198_base_capacitance_text_field)) },
        singleLine = true,
        trailingIcon = {
            if (searchQuery.isNotEmpty()) {
                IconButton(onClick = { searchQuery = "" }) {
                    Icon(
                        imageVector = Icons.Outlined.Cancel,
                        contentDescription = stringResource(R.string.smd_eia_198_base_capacitance_text_field_clear_label)
                    )
                }
            }
        }
    )
    Column {
        filteredEntries.forEachIndexed { index, entry ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = entry.letter,
                    style = textStyleBody(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = entry.value.toString(),
                    style = textStyleBody(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
            }
            if (filteredEntries.size - 1 != index) {
                AppDivider(modifier = Modifier)
            }
        }
        if (filteredEntries.isEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.smd_eia_198_base_capacitance_no_results),
                style = textStyleBody().onSurfaceVariant(),
            )
        }
    }
}

@Composable
fun CodeInfoSection(
    headlineRes: Int,
    bodyRes: Int,
    formulaRes: Int,
    exampleLabelRes: Int,
    exampleRes: Int,
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
    EquationCard(stringResource(formulaRes))
    Text(
        text = stringResource(exampleLabelRes),
        modifier = Modifier.padding(vertical = 12.dp),
        style = textStyleBody().onSurfaceVariant(),
    )
    EquationCard(stringResource(exampleRes))
}

@Composable
private fun EquationCard(equation: String) {
    AppCard(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = equation,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            style = textStyleCallout(),
            textAlign = TextAlign.Center,
        )
    }
}
