package com.brandoncano.capacitorcalculator.ui.screens.home

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
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Memory
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.brandoncano.capacitorcalculator.constants.Links
import com.brandoncano.capacitorcalculator.ui.composables.AboutAppMenuItem
import com.brandoncano.capacitorcalculator.ui.composables.AppThemeMenuItem
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppArrowCardButton
import com.brandoncano.sharedcomponents.composables.AppMenuTopAppBar
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.FeedbackMenuItem
import com.brandoncano.sharedcomponents.data.ArrowCardButtonContents
import com.brandoncano.sharedcomponents.text.textStyleHeadline

@Composable
fun HomeScreen(
    openMenu: MutableState<Boolean>,
    onOpenThemeDialog: () -> Unit,
    onAboutTapped: () -> Unit,
    onCapacitorCodeTapped: () -> Unit,
    onAdvancedCodeTapped: () -> Unit,
    onSmdTapped: () -> Unit,
    onCommonCodesTapped: () -> Unit,
    onCapacitorValuesTapped: () -> Unit,
    onCapacitorTypesTapped: () -> Unit,
    onRateThisAppTapped: () -> Unit,
    onViewOurAppsTapped: () -> Unit,
    onDonateTapped: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppMenuTopAppBar(
                titleText = stringResource(R.string.app_name),
                interactionSource = remember { MutableInteractionSource() },
                showMenu = openMenu,
                content = {
                    FeedbackMenuItem(Links.APP_NAME, openMenu)
                    AppThemeMenuItem(openMenu, onOpenThemeDialog)
                    AboutAppMenuItem(onAboutTapped)
                }
            )
        },
    ) { paddingValues ->
        HomeScreenContent(
            paddingValues = paddingValues,
            onCapacitorCodeTapped = onCapacitorCodeTapped,
            onAdvancedCodeTapped = onAdvancedCodeTapped,
            onSmdTapped = onSmdTapped,
            onCommonCodesTapped = onCommonCodesTapped,
            onCapacitorValuesTapped = onCapacitorValuesTapped,
            onCapacitorTypesTapped = onCapacitorTypesTapped,
            onRateThisAppTapped = onRateThisAppTapped,
            onViewOurAppsTapped = onViewOurAppsTapped,
            onDonateTapped = onDonateTapped
        )
    }
}

@Composable
private fun HomeScreenContent(
    paddingValues: PaddingValues,
    onCapacitorCodeTapped: () -> Unit,
    onAdvancedCodeTapped: () -> Unit,
    onSmdTapped: () -> Unit,
    onCommonCodesTapped: () -> Unit,
    onCapacitorValuesTapped: () -> Unit,
    onCapacitorTypesTapped: () -> Unit,
    onRateThisAppTapped: () -> Unit,
    onViewOurAppsTapped: () -> Unit,
    onDonateTapped: () -> Unit,
) {
    val sidePadding = dimensionResource(R.dimen.app_side_padding)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)
            .padding(horizontal = sidePadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(id = R.string.home_calculators_header_text),
            modifier = Modifier
                .padding(vertical = 12.dp)
                .align(Alignment.Start),
            style = textStyleHeadline(),
        )
        AppArrowCardButton(
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Code,
                text = stringResource(id = R.string.home_capacitor_code_calculator_button),
                onClick = onCapacitorCodeTapped
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Tune,
                text = stringResource(id = R.string.home_advanced_capacitor_code_button),
                onClick = onAdvancedCodeTapped
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Memory,
                text = stringResource(id = R.string.home_smd_calculator_button),
                onClick = onSmdTapped
            )
        )
        Spacer(modifier = Modifier.height(32.dp))
        CapacitorInformationButtons(
            onCommonCodesTapped = onCommonCodesTapped,
            onCapacitorValuesTapped = onCapacitorValuesTapped,
            onCapacitorTypesTapped = onCapacitorTypesTapped,
        )
        Spacer(modifier = Modifier.height(32.dp))
        OurAppsButtons(
            onRateThisAppTapped = onRateThisAppTapped,
            onViewOurAppsTapped = onViewOurAppsTapped,
            onDonateTapped = onDonateTapped,
        )
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@AppScreenPreviews
@Composable
private fun HomePreview() {
    CapacitorCalculatorTheme {
        HomeScreen(
            openMenu = remember { mutableStateOf(false) },
            onOpenThemeDialog = {},
            onAboutTapped = {},
            onCapacitorCodeTapped = {},
            onAdvancedCodeTapped = {},
            onSmdTapped = {},
            onCommonCodesTapped = {},
            onCapacitorValuesTapped = {},
            onCapacitorTypesTapped = {},
            onRateThisAppTapped = {},
            onViewOurAppsTapped = {},
            onDonateTapped = {},
        )
    }
}
