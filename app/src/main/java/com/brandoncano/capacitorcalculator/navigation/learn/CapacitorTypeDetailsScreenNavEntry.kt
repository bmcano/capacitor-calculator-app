package com.brandoncano.capacitorcalculator.navigation.learn

import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
        enterTransition = { slideInVertically(initialOffsetY = { it }) },
        exitTransition = { slideOutVertically(targetOffsetY = { it }) },
    ) { navBackStackEntry ->
        // Retrieve the argument from the route
        val args = navBackStackEntry.toRoute<Screen.CapacitorTypeDetails>()
        InformationDetailsScreen(
            type = args.type,
            onNavigateBack = { navHostController.popBackStack() },
        )
    }
}
