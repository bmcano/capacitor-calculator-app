package com.brandoncano.capacitorcalculator.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.brandoncano.capacitorcalculator.ui.screens.home.HomeScreen

fun NavGraphBuilder.homeScreen(
    navHostController: NavHostController,
    onOpenThemeDialog: () -> Unit,
) {
    composable(
        route = Screen.Home.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        val context = LocalContext.current
        val openMenu = remember { mutableStateOf(false) }
        HomeScreen(
            openMenu = openMenu,
            onOpenThemeDialog = onOpenThemeDialog,
            onAboutTapped = {
                openMenu.value = false
                navigateToAbout(navHostController)
            },
            onCapacitorCodeTapped = { navigateToCapacitorCode(navHostController) },
            onAdvancedCodeTapped = { navigateToAdvancedCapacitorCode(navHostController) },
            onSmdTapped = { navigateToSmd(navHostController) },
            onCommonCodesTapped = { navigateToCommonCodes(navHostController) },
            onCapacitorValuesTapped = { navigateToCapacitorValues(navHostController) },
            onCapacitorTypesTapped = { navigateToCapacitorTypes(navHostController) },
            onRateThisAppTapped = { navigateToGooglePlay(context) },
            onViewOurAppsTapped = { navigateToOurApps(navHostController) },
            onDonateTapped = { navigateToDonate(navHostController) },
        )
    }
}
