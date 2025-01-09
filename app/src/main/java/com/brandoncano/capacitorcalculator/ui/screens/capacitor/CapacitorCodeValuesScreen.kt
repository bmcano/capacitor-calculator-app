package com.brandoncano.capacitorcalculator.ui.screens.capacitor

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
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.constants.Links
import com.brandoncano.capacitorcalculator.data.CapacitorValue
import com.brandoncano.capacitorcalculator.model.capacitor.Capacitor
import com.brandoncano.capacitorcalculator.ui.composables.AboutAppMenuItem
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppArrowCardButton
import com.brandoncano.sharedcomponents.composables.AppDivider
import com.brandoncano.sharedcomponents.composables.AppMenuTopAppBar
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTextField
import com.brandoncano.sharedcomponents.composables.ClearSelectionsMenuItem
import com.brandoncano.sharedcomponents.composables.FeedbackMenuItem
import com.brandoncano.sharedcomponents.composables.ShareTextMenuItem
import com.brandoncano.sharedcomponents.data.ArrowCardButtonContents
import com.brandoncano.sharedcomponents.text.textStyleHeadline

@Composable
fun CapacitorCodeValuesScreen(
    capacitor: Capacitor,
    isCodeError: Boolean,
    isCapacitanceError: Boolean,
    openMenu: MutableState<Boolean>,
    reset: MutableState<Boolean>,
    onNavigateBack: () -> Unit,
    onClearSelectionsTapped: () -> Unit,
    onAboutTapped: () -> Unit,
    onValueChanged: (String, CapacitorValue) -> Unit,
    onLearnMoreTapped: () -> Unit,
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
                ClearSelectionsMenuItem(onClearSelectionsTapped)
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
        CapacitorCodeValuesContent(
            paddingValues = paddingValues,
            capacitor = capacitor,
            isCodeError = isCodeError,
            isCapacitanceError = isCapacitanceError,
            reset = reset,
            onValueChanged = onValueChanged,
            onLearnMoreTapped = onLearnMoreTapped,
        )
    }
}

@Composable
private fun CapacitorCodeValuesContent(
    paddingValues: PaddingValues,
    capacitor: Capacitor,
    isCodeError: Boolean,
    isCapacitanceError: Boolean,
    reset: MutableState<Boolean>,
    onValueChanged: (String, CapacitorValue) -> Unit,
    onLearnMoreTapped: () -> Unit,
) {
    val sidePadding = dimensionResource(R.dimen.app_side_padding)
    val code = remember { mutableStateOf(capacitor.code) }
    val uf = remember { mutableStateOf(capacitor.uf) }
    val nf = remember { mutableStateOf(capacitor.nf) }
    val pf = remember { mutableStateOf(capacitor.pf) }
    LaunchedEffect(capacitor) {
        code.value = capacitor.code
        uf.value = capacitor.uf
        nf.value = capacitor.nf
        pf.value = capacitor.pf
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)
            .padding(horizontal = sidePadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppTextField(
            label = stringResource(id = R.string.capacitor_calculator_code),
            modifier = Modifier.padding(top = 24.dp),
            value = code,
            reset = reset.value,
            isError = isCodeError,
            errorMessage = stringResource(id = R.string.error_invalid_code),
            onOptionSelected = { onValueChanged(it, CapacitorValue.Code) },
        )
        AppTextField(
            label = stringResource(id = R.string.hint_uf),
            modifier = Modifier.padding(top = 12.dp),
            value = uf,
            reset = reset.value,
            isError = isCapacitanceError,
            errorMessage = stringResource(id = R.string.error_invalid_capacitance),
            onOptionSelected = { onValueChanged(it, CapacitorValue.UF) },
        )
        AppTextField(
            label = stringResource(id = R.string.hint_nf),
            modifier = Modifier.padding(top = 12.dp),
            value = nf,
            reset = reset.value,
            isError = isCapacitanceError,
            errorMessage = stringResource(id = R.string.error_invalid_capacitance),
            onOptionSelected = { onValueChanged(it, CapacitorValue.NF) },
        )
        AppTextField(
            label = stringResource(id = R.string.hint_pf),
            modifier = Modifier.padding(top = 12.dp),
            value = pf,
            reset = reset.value,
            isError = isCapacitanceError,
            errorMessage = stringResource(id = R.string.error_invalid_capacitance),
            onOptionSelected = { onValueChanged(it, CapacitorValue.PF) },
        )

        AppDivider(modifier = Modifier.padding(vertical = 24.dp))
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = stringResource(id = R.string.capacitor_calculator_headline_text),
                modifier = Modifier.padding(bottom = 16.dp),
                style = textStyleHeadline(),
            )
            AppArrowCardButton(
                ArrowCardButtonContents(
                    imageVector = Icons.Outlined.Lightbulb,
                    text = stringResource(id = R.string.capacitor_calculator_button_text),
                    onClick = onLearnMoreTapped,
                )
            )
        }
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@AppScreenPreviews
@Composable
fun CapacitorCodeValuesScreenPreview() {
    CapacitorCalculatorTheme {
        CapacitorCodeValuesScreen(
            capacitor = Capacitor(),
            isCodeError = false,
            isCapacitanceError = false,
            openMenu = remember { mutableStateOf(false) },
            reset = remember { mutableStateOf(false) },
            onNavigateBack = {},
            onClearSelectionsTapped = {},
            onAboutTapped = {},
            onValueChanged = { _, _ -> },
            onLearnMoreTapped = {},
        )
    }
}
