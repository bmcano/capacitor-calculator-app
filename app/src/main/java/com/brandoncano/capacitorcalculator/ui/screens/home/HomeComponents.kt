package com.brandoncano.capacitorcalculator.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ViewList
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Grade
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
            )
        )
    }
}

@Composable
fun OurAppsButtons(
    onRateThisAppTapped: () -> Unit,
    onViewOurAppsTapped: () -> Unit,
    onDonateTapped: () -> Unit,
) {
    Column {
        Text(
            text = stringResource(id = R.string.home_our_apps_header_text),
            modifier = Modifier.align(Alignment.Start),
            style = textStyleHeadline(),
        )
        Spacer(modifier = Modifier.height(12.dp))
        AppArrowCardButton(
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Grade,
                text = stringResource(id = R.string.home_button_rate_us),
                onClick = onRateThisAppTapped,
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Apps,
                text = stringResource(id = R.string.home_button_view_apps),
                onClick = onViewOurAppsTapped,
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.FavoriteBorder,
                text = stringResource(R.string.home_button_donate),
                onClick = onDonateTapped,
            ),
        )
    }
}

@AppComponentPreviews
@Composable
private fun ButtonsPreview() {
    CapacitorCalculatorTheme {
        Surface {
            OurAppsButtons(
                onRateThisAppTapped = {},
                onViewOurAppsTapped = {},
                onDonateTapped = {},
            )
        }
    }
}
