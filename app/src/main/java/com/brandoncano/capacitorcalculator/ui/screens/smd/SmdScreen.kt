package com.brandoncano.capacitorcalculator.ui.screens.smd

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Explicit
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.Looks3
import androidx.compose.material.icons.outlined.Looks4
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.constants.DropdownLists
import com.brandoncano.capacitorcalculator.constants.Links
import com.brandoncano.capacitorcalculator.model.smd.SmdCapacitor
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AboutAppMenuItem
import com.brandoncano.sharedcomponents.composables.AppArrowCardButton
import com.brandoncano.sharedcomponents.composables.AppDivider
import com.brandoncano.sharedcomponents.composables.AppDropDownMenu
import com.brandoncano.sharedcomponents.composables.AppMenuTopAppBar
import com.brandoncano.sharedcomponents.composables.AppNavigationBar
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTextField
import com.brandoncano.sharedcomponents.composables.ClearSelectionsMenuItem
import com.brandoncano.sharedcomponents.composables.FeedbackMenuItem
import com.brandoncano.sharedcomponents.composables.ShareTextMenuItem
import com.brandoncano.sharedcomponents.data.ArrowCardButtonContents
import com.brandoncano.sharedcomponents.data.NavigationBarOptions
import com.brandoncano.sharedcomponents.text.textStyleHeadline
import java.util.Locale

@Composable
fun SmdScreen(
    openMenu: MutableState<Boolean>,
    reset: MutableState<Boolean>,
    capacitor: SmdCapacitor,
    isError: Boolean,
    onNavigateBack: () -> Unit,
    onClearSelectionsTapped: () -> Unit,
    onAboutTapped: () -> Unit,
    onValueChanged: (String, String, Boolean) -> Unit,
    onNavBarSelectionChanged: (Int) -> Unit,
    navBarPosition: Int,
    onLearnSmdCodesTapped: () -> Unit,
) {
    var navBarSelection by remember { mutableIntStateOf(navBarPosition) }
    Scaffold(
        topBar = {
            AppMenuTopAppBar(
                titleText = stringResource(R.string.smd_calculator_title),
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
        },
        bottomBar = {
            AppNavigationBar(
                selection = navBarSelection,
                onClick = {
                    navBarSelection = it
                    onNavBarSelectionChanged(it)
                },
                options = listOf(
                    NavigationBarOptions(
                        label = stringResource(id = R.string.smd_navbar_three_eia),
                        imageVector = Icons.Outlined.Looks3,
                    ),
                    NavigationBarOptions(
                        label = stringResource(id = R.string.smd_navbar_four_eia),
                        imageVector = Icons.Outlined.Looks4,
                    ),
                    NavigationBarOptions(
                        label = stringResource(id = R.string.smd_navbar_eia_198),
                        imageVector = Icons.Outlined.Explicit,
                    ),
                ),
            )
        },
        contentWindowInsets = WindowInsets.safeDrawing,
    ) { paddingValues ->
        SmdScreenContent(
            paddingValues = paddingValues,
            reset = reset,
            capacitor = capacitor,
            isError = isError,
            onValueChanged = onValueChanged,
            onLearnSmdCodesTapped = onLearnSmdCodesTapped,
        )
    }
}

@Composable
private fun SmdScreenContent(
    paddingValues: PaddingValues,
    reset: MutableState<Boolean>,
    capacitor: SmdCapacitor,
    isError: Boolean,
    onValueChanged: (String, String, Boolean) -> Unit,
    onLearnSmdCodesTapped: () -> Unit,
) {
    val code = remember { mutableStateOf(capacitor.code) }
    val sidePadding = dimensionResource(R.dimen.app_side_padding)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)
            .padding(horizontal = sidePadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SmdCapacitorLayout(capacitor, isError)
        AppTextField(
            label = stringResource(id = R.string.smd_code_hint),
            modifier = Modifier.padding(top = 32.dp),
            value = code,
            reset = reset.value,
            isError = isError,
            errorMessage = stringResource(id = R.string.error_invalid_code),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Characters,
                autoCorrectEnabled = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        ) {
            code.value = it.uppercase(Locale.getDefault())
            onValueChanged(code.value, capacitor.units, false)
        }
        AppDropDownMenu(
            label = stringResource(id = R.string.smd_units_hint),
            modifier = Modifier.padding(top = 12.dp),
            selectedOption = capacitor.units,
            items = DropdownLists.UNITS,
            reset = reset.value,
            onOptionSelected = { onValueChanged(code.value, it, true) }
        )

        AppDivider(modifier = Modifier.padding(vertical = 24.dp))
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = stringResource(id = R.string.smd_learn_code_headline),
                modifier = Modifier.padding(bottom = 16.dp),
                style = textStyleHeadline(),
            )
            AppArrowCardButton(
                ArrowCardButtonContents(
                    imageVector = Icons.Outlined.Lightbulb,
                    text = stringResource(id = R.string.smd_learn_code_card),
                    onClick = onLearnSmdCodesTapped,
                )
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@AppScreenPreviews
@Composable
private fun SmdScreenPreview() {
    CapacitorCalculatorTheme {
        SmdScreen(
            openMenu = remember { mutableStateOf(false) },
            reset = remember { mutableStateOf(false) },
            capacitor = SmdCapacitor(),
            isError = false,
            onNavigateBack = {},
            onClearSelectionsTapped = {},
            onAboutTapped = {},
            onValueChanged = { _, _, _-> },
            onNavBarSelectionChanged = { _ -> },
            navBarPosition = 1,
            onLearnSmdCodesTapped = {},
        )
    }
}
