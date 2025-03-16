package com.brandoncano.capacitorcalculator.ui.screens.learn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.data.Tolerance
import com.brandoncano.capacitorcalculator.data.VoltageRating
import com.brandoncano.capacitorcalculator.util.FindEIA198Value
import com.brandoncano.sharedcomponents.composables.AppCard
import com.brandoncano.sharedcomponents.composables.AppDivider
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleCallout
import com.brandoncano.sharedcomponents.text.textStyleSubhead
import com.brandoncano.sharedcomponents.text.textStyleTitle

@Preview
@Composable
fun ToleranceTable() {
    AppCard(modifier = Modifier.padding(top = 12.dp)) {
        val col1 = Tolerance.getStandardToleranceLettersList()
        val col2 = Tolerance.getStandardToleranceList()
        val colHeader1 = stringResource(id = R.string.capacitor_values_tolerance_letter)
        val colHeader2 = stringResource(id = R.string.capacitor_values_tolerance_percentage)
        TableScreen(colHeader1, colHeader2, col1, col2)
    }
}

@Preview
@Composable
fun VoltageRatingTable() {
    AppCard(modifier = Modifier.padding(top = 12.dp)) {
        val col1 = VoltageRating.getCodeList()
        val col2 = VoltageRating.getVoltageList()
        val colHeader1 = stringResource(id = R.string.capacitor_values_voltage_code)
        val colHeader2 = stringResource(id = R.string.capacitor_values_voltage_values)
        TableScreen(colHeader1, colHeader2, col1, col2)
    }
}

@Preview
@Composable
fun SmdBaseCapacitanceTable() {
    Column {
        Text(
            text = stringResource(id = R.string.cap_eia_198_base_capacitance_value),
            style = textStyleTitle()
        )
        AppCard(modifier = Modifier.padding(top = 12.dp)) {
            val col1 = FindEIA198Value.table.keys.toList()
            val col2 =  FindEIA198Value.table.values.map { it -> it.toString() }
            val colHeader1 = stringResource(id = R.string.cap_eia_198_base_capacitance_col1)
            val colHeader2 = stringResource(id = R.string.cap_eia_198_base_capacitance_col2)
            TableScreen(colHeader1, colHeader2, col1, col2)
        }
    }
}

@Composable
private fun RowScope.TableCell(text: String, weight: Float, style: TextStyle) {
    Text(
        text = text,
        modifier = Modifier
            .weight(weight)
            .padding(start = 8.dp, end = 8.dp, top = 8.dp),
        style = style,
        textAlign = TextAlign.Center,
    )
}

@Composable
private fun TableScreen(
    columnTitle1: String,
    columnTitle2: String,
    columnContents1: List<String>,
    columnContents2: List<String>
) {
    val tableData = columnContents1.zip(columnContents2)
    val column1Weight = .3f // 30%
    val column2Weight = .7f // 70%
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 12.dp)
    ) {
        Row {
            TableCell(text = columnTitle1, weight = column1Weight, style = textStyleCallout())
            TableCell(text = columnTitle2, weight = column2Weight, style = textStyleCallout())
        }
        AppDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp))
        tableData.forEach { pair ->
            val (id, text) = pair
            Row(Modifier.fillMaxWidth()) {
                TableCell(text = id, weight = column1Weight, style = textStyleSubhead().onSurfaceVariant())
                TableCell(text = text, weight = column2Weight, style = textStyleSubhead().onSurfaceVariant())
            }
            if (tableData[tableData.size - 1] != pair) {
                AppDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp))
            }
        }
    }
}
