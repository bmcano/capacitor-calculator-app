package com.brandoncano.capacitorcalculator.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.brandoncano.capacitorcalculator.constants.Links
import com.brandoncano.capacitorcalculator.navigation.calculators.capacitorAdvancedCodeScreen
import com.brandoncano.capacitorcalculator.navigation.calculators.capacitorCodeValuesScreen
import com.brandoncano.capacitorcalculator.navigation.calculators.smdScreen
import com.brandoncano.capacitorcalculator.navigation.learn.learnCapacitorTypeDetails
import com.brandoncano.capacitorcalculator.navigation.learn.learnCapacitorTypes
import com.brandoncano.capacitorcalculator.navigation.learn.learnCapacitorValues
import com.brandoncano.capacitorcalculator.navigation.learn.learnCommonCodes
import com.brandoncano.sharedcomponents.data.Apps
import com.brandoncano.sharedcomponents.navigation.SharedScreens
import com.brandoncano.sharedcomponents.navigation.donateScreen
import com.brandoncano.sharedcomponents.navigation.viewOurAppsScreen
import com.brandoncano.sharedcomponents.utils.OpenLink

/**
 * Note: Keep each navigation route in alphabetical order
 */

@Composable
fun Navigation(onOpenThemeDialog: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        aboutScreen(navController)
        capacitorAdvancedCodeScreen(navController)
        capacitorCodeValuesScreen(navController)
        homeScreen(navController, onOpenThemeDialog)
        learnCapacitorTypes(navController)
        learnCapacitorTypeDetails(navController)
        learnCapacitorValues(navController)
        learnCommonCodes(navController)
        smdScreen(navController)
        // from shared library
        donateScreen(navController)
        viewOurAppsScreen(navController, Apps.Capacitor)
    }
}

fun navigateToAbout(navController: NavHostController) {
    navController.navigate(Screen.About.route)
}

fun navigateToCapacitorCode(navController: NavHostController) {
    navController.navigate(Screen.CapacitorCodeValues.route) {
        popUpTo(Screen.Home.route)
    }
}

fun navigateToAdvancedCapacitorCode(navController: NavHostController) {
    navController.navigate(Screen.CapacitorAdvancedCalculator.route) {
        popUpTo(Screen.Home.route)
    }
}

fun navigateToSmd(navController: NavHostController) {
    navController.navigate(Screen.Smd.route) {
        popUpTo(Screen.Home.route)
    }
}

fun navigateToCommonCodes(navController: NavHostController) {
    navController.navigate(Screen.CommonCodes.route)
}

fun navigateToCapacitorTypes(navController: NavHostController) {
    navController.navigate(Screen.CapacitorTypes.route)
}

fun navigateToCapacitorValues(navController: NavHostController) {
    navController.navigate(Screen.CapacitorValues.route)
}

fun navigateToGooglePlay(context: Context) {
    OpenLink.execute(context, Links.CAPACITOR_PLAYSTORE)
}

fun navigateToOurApps(navController: NavHostController) {
    navController.navigate(SharedScreens.ViewOurApps.route)
}

fun navigateToDonate(navController: NavHostController) {
    navController.navigate(SharedScreens.Donate.route)
}
