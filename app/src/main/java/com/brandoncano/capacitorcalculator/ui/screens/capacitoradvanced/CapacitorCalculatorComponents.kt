package com.brandoncano.capacitorcalculator.ui.screens.capacitoradvanced

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.model.capacitoradvanced.CapacitorAdvanced
import com.brandoncano.capacitorcalculator.util.formatCapacitance
import com.brandoncano.capacitorcalculator.util.getTolerancePercentage
import com.brandoncano.capacitorcalculator.util.getVoltageRating
import com.brandoncano.sharedcomponents.composables.AppArrowCardButton
import com.brandoncano.sharedcomponents.composables.AppCard
import com.brandoncano.sharedcomponents.data.ArrowCardButtonContents
import com.brandoncano.sharedcomponents.text.textStyleHeadline
import com.brandoncano.sharedcomponents.text.textStyleTitle

@Composable
fun CapacitanceText(
    capacitor: CapacitorAdvanced,
    units: String,
    isError: Boolean,
) {
    val capacitance: String
    var tolerance = ""
    var voltage = ""
    if (isError) {
        capacitance = stringResource(id = R.string.error_na)
    } else {
        capacitance = if (capacitor.isEmpty()) {
            stringResource(id = R.string.default_code)
        } else {
            capacitor.formatCapacitance()
        }
        tolerance = capacitor.getTolerancePercentage()
        voltage = capacitor.getVoltageRating()
    }
    AppCard(modifier = Modifier.padding(top = 24.dp)) {
        Text(
            text = "$capacitance $units $tolerance".trimEnd(),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 6.dp, bottom = 6.dp, start = 12.dp, end = 12.dp),
            style = textStyleTitle(),
        )
        if (voltage.isNotEmpty()) {
            Text(
                text = voltage,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 2.dp, bottom = 6.dp, start = 12.dp, end = 12.dp),
                style = textStyleTitle(),
            )
        }
    }
}

@Composable
fun CapacitorInformation(
    onCapacitorValuesTapped: () -> Unit,
    onCapacitorTypesTapped: () -> Unit,
) {
    Column {
        Text(
            text = stringResource(id = R.string.home_capacitors_header_text),
            modifier = Modifier.align(Alignment.Start),
            style = textStyleHeadline(),
        )
        Spacer(modifier = Modifier.height(12.dp))
        AppArrowCardButton(
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Calculate,
                text = stringResource(id = R.string.home_capacitor_values),
                onClick = onCapacitorValuesTapped
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Category,
                text = stringResource(id = R.string.home_information_button),
                onClick = onCapacitorTypesTapped
            )
        )
    }
}
