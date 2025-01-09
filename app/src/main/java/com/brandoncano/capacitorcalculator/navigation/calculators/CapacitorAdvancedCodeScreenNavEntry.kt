package com.brandoncano.capacitorcalculator.navigation.calculators

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.brandoncano.capacitorcalculator.model.CapacitorViewModelFactory
import com.brandoncano.capacitorcalculator.model.capacitoradvanced.CapacitorAdvancedViewModel
import com.brandoncano.capacitorcalculator.navigation.Screen
import com.brandoncano.capacitorcalculator.navigation.navigateToAbout
import com.brandoncano.capacitorcalculator.navigation.navigateToCapacitorTypes
import com.brandoncano.capacitorcalculator.navigation.navigateToCapacitorValues
import com.brandoncano.capacitorcalculator.ui.screens.capacitoradvanced.CapacitorAdvancedCodeScreen

fun NavGraphBuilder.capacitorAdvancedCodeScreen(
    navHostController: NavHostController,
) {
    composable(
        route = Screen.CapacitorAdvancedCalculator.route,
        enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
        exitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
    ) {
        val context = LocalContext.current
        val focusManager = LocalFocusManager.current
        val openMenu = remember { mutableStateOf(false) }
        val reset = remember { mutableStateOf(false) }
        val viewModel: CapacitorAdvancedViewModel = viewModel(factory = CapacitorViewModelFactory(context))
        val capacitor by viewModel.capacitor.collectAsState()
        val isError by viewModel.isError.collectAsState()

        CapacitorAdvancedCodeScreen(
            capacitor = capacitor,
            isError = isError,
            openMenu = openMenu,
            reset = reset,
            onNavigateBack = { navHostController.popBackStack() },
            onClearSelectionsTapped = {
                openMenu.value = false
                reset.value = true
                viewModel.clear()
                focusManager.clearFocus()
            },
            onAboutTapped = { navigateToAbout(navHostController) },
            onValueChanged = { code, units, tolerance, voltage, clearFocus ->
                reset.value = false
                viewModel.updateValues(code, units, tolerance, voltage)
                if (clearFocus) focusManager.clearFocus()
            },
            onCapacitorValuesTapped = { navigateToCapacitorValues(navHostController) },
            onCapacitorTypesTapped = { navigateToCapacitorTypes(navHostController) },
        )
    }
}
