package com.brandoncano.capacitorcalculator.ui.screens.capacitoradvanced

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.constants.DropdownLists
import com.brandoncano.capacitorcalculator.constants.Links
import com.brandoncano.capacitorcalculator.model.capacitoradvanced.CapacitorAdvanced
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AboutAppMenuItem
import com.brandoncano.sharedcomponents.composables.AppDivider
import com.brandoncano.sharedcomponents.composables.AppDropDownMenu
import com.brandoncano.sharedcomponents.composables.AppMenuTopAppBar
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTextField
import com.brandoncano.sharedcomponents.composables.ClearSelectionsMenuItem
import com.brandoncano.sharedcomponents.composables.FeedbackMenuItem
import com.brandoncano.sharedcomponents.composables.ShareTextMenuItem

@Composable
fun CapacitorAdvancedCodeScreen(
    capacitor: CapacitorAdvanced,
    isError: Boolean,
    openMenu: MutableState<Boolean>,
    reset: MutableState<Boolean>,
    onNavigateBack: () -> Unit,
    onClearSelectionsTapped: () -> Unit,
    onAboutTapped: () -> Unit,
    onValueChanged: (String, String, String, String, Boolean) -> Unit,
    onCapacitorValuesTapped: () -> Unit,
    onCapacitorTypesTapped: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppMenuTopAppBar(
                titleText = stringResource(id = R.string.capacitor_calculator_title),
                interactionSource = remember { MutableInteractionSource() },
                showMenu = openMenu,
                navigationIcon = Icons.AutoMirrored.Filled.ArrowBack,
                onNavigateBack = onNavigateBack,
            ) {
                ClearSelectionsMenuItem(
                    onClearSelectionsTapped
                )
                ShareTextMenuItem(
                    text = capacitor.toString(),
                    showMenu = openMenu,
                )
                FeedbackMenuItem(
                    app = Links.APP_NAME,
                    showMenu = openMenu,
                )
                AboutAppMenuItem(onAboutTapped)
            }
        }
    ) { paddingValues ->
        CapacitorAdvancedCodeScreenContent(
            paddingValues = paddingValues,
            capacitor = capacitor,
            isError = isError,
            reset = reset,
            onValueChanged = onValueChanged,
            onCapacitorValuesTapped = onCapacitorValuesTapped,
            onCapacitorTypesTapped = onCapacitorTypesTapped,
        )
    }
}

@Composable
private fun CapacitorAdvancedCodeScreenContent(
    paddingValues: PaddingValues,
    capacitor: CapacitorAdvanced,
    isError: Boolean,
    reset: MutableState<Boolean>,
    onValueChanged: (String, String, String, String, Boolean) -> Unit,
    onCapacitorValuesTapped: () -> Unit,
    onCapacitorTypesTapped: () -> Unit,
) {
    val code = remember { mutableStateOf(capacitor.code) }
    val sidePadding = dimensionResource(R.dimen.app_side_padding)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)
            .padding(horizontal = sidePadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CapacitanceText(capacitor, capacitor.units, isError)
        AppTextField(
            modifier = Modifier.padding(top = 24.dp),
            label = stringResource(id = R.string.capacitor_calculator_code),
            value = code,
            reset = reset.value,
            isError = isError,
            errorMessage = stringResource(id = R.string.error_invalid_code),
            onOptionSelected = {
                onValueChanged(it, capacitor.units, capacitor.tolerance, capacitor.voltageRating, false)
            }
        )
        AppDropDownMenu(
            modifier = Modifier.padding(top = 12.dp),
            label = stringResource(R.string.capacitor_calculator_units),
            selectedOption = capacitor.units,
            items = DropdownLists.UNITS,
            reset = reset.value,
            onOptionSelected = {
                onValueChanged(code.value, it, capacitor.tolerance, capacitor.voltageRating, true)
            }
        )
        AppDropDownMenu(
            modifier = Modifier.padding(top = 12.dp),
            label = stringResource(R.string.capacitor_calculator_tolerance),
            selectedOption = capacitor  .tolerance,
            items = DropdownLists.TOLERANCE,
            reset = reset.value,
            onOptionSelected = {
                onValueChanged(code.value, capacitor.units, it, capacitor.voltageRating, true)
            }
        )
        AppDropDownMenu(
            modifier = Modifier.padding(top = 12.dp),
            label = stringResource(R.string.capacitor_calculator_voltage_rating),
            selectedOption = capacitor.voltageRating,
            items = DropdownLists.VOLTAGE_RATING,
            reset = reset.value,
            onOptionSelected = {
                onValueChanged(code.value, capacitor.units, capacitor.tolerance, it, true)
            }
        )
        AppDivider(modifier = Modifier.padding(vertical = 24.dp))
        CapacitorInformation(
            onCapacitorValuesTapped = onCapacitorValuesTapped,
            onCapacitorTypesTapped = onCapacitorTypesTapped,
        )
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@AppScreenPreviews
@Composable
private fun CapacitorCalculatorPreview() {
    CapacitorCalculatorTheme {
        CapacitorAdvancedCodeScreen(
            capacitor = CapacitorAdvanced(),
            isError = false,
            openMenu = remember { mutableStateOf(false) },
            reset = remember { mutableStateOf(false) },
            onNavigateBack = {},
            onClearSelectionsTapped = {},
            onAboutTapped = {},
            onValueChanged = { _, _, _, _, _ -> },
            onCapacitorValuesTapped = {},
            onCapacitorTypesTapped = {},
        )
    }
}
