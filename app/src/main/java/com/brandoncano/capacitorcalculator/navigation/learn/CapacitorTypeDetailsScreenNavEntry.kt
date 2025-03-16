package com.brandoncano.capacitorcalculator.navigation.learn

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.brandoncano.capacitorcalculator.navigation.Screen
import com.brandoncano.capacitorcalculator.ui.screens.learndetails.InformationDetailsScreen

fun NavGraphBuilder.learnCapacitorTypeDetails(
    navHostController: NavHostController,
) {
    composable<Screen.CapacitorTypeDetails> (
        enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
        exitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
    ) { navBackStackEntry ->
        // Retrieve the argument from the route
        val args = navBackStackEntry.toRoute<Screen.CapacitorTypeDetails>()
        InformationDetailsScreen(
            type = args.type,
            onNavigateBack = { navHostController.popBackStack() },
        )
    }
}
