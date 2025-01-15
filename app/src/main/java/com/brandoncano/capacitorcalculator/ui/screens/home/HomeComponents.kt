package com.brandoncano.capacitorcalculator.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ViewList
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Memory
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppArrowCardButton
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews
import com.brandoncano.sharedcomponents.data.ArrowCardButtonContents
import com.brandoncano.sharedcomponents.text.textStyleHeadline

@Composable
fun CapacitorInformationButtons(
    onCommonCodesTapped: () -> Unit,
    onCapacitorValuesTapped: () -> Unit,
    onCapacitorTypesTapped: () -> Unit,
    onSmdCodeSystemsTapped: () -> Unit,
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
                imageVector = Icons.AutoMirrored.Outlined.ViewList,
                text = stringResource(id = R.string.home_common_codes),
                onClick = onCommonCodesTapped,
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Calculate,
                text = stringResource(id = R.string.home_capacitor_values),
                onClick = onCapacitorValuesTapped
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Category,
                text = stringResource(id = R.string.home_information_button),
                onClick = onCapacitorTypesTapped
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Memory,
                text = stringResource(id = R.string.home_smd_codes_button),
                onClick = onSmdCodeSystemsTapped
            )
        )
    }
}

@AppComponentPreviews
@Composable
private fun ButtonsPreview() {
    CapacitorCalculatorTheme {
        Surface {
            CapacitorInformationButtons(
                onCommonCodesTapped = {},
                onCapacitorValuesTapped = {},
                onCapacitorTypesTapped = {},
                onSmdCodeSystemsTapped = {},
            )
        }
    }
}
