package com.brandoncano.capacitorcalculator.navigation.learn

import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.brandoncano.capacitorcalculator.data.CapacitorType
import com.brandoncano.capacitorcalculator.navigation.Screen
import com.brandoncano.capacitorcalculator.ui.screens.learn.CapacitorTypesScreen

fun NavGraphBuilder.learnCapacitorTypes(
    navHostController: NavHostController,
) {
    composable(
        route = Screen.CapacitorTypes.route,
        enterTransition = { slideInVertically(initialOffsetY = { it }) },
        exitTransition = { slideOutVertically(targetOffsetY = { it }) },
    ) {
        CapacitorTypesScreen(
            onNavigateBack = { navHostController.popBackStack() },
            onCapacitorTypeClicks = listOf(
                { navHostController.navigate(Screen.CapacitorTypeDetails(CapacitorType.Ceramic)) },
                { navHostController.navigate(Screen.CapacitorTypeDetails(CapacitorType.Film)) },
                { navHostController.navigate(Screen.CapacitorTypeDetails(CapacitorType.Electrolytic)) },
                { navHostController.navigate(Screen.CapacitorTypeDetails(CapacitorType.Polymer)) },
                { navHostController.navigate(Screen.CapacitorTypeDetails(CapacitorType.SuperCapacitor)) },
                { navHostController.navigate(Screen.CapacitorTypeDetails(CapacitorType.Mica)) },
                { navHostController.navigate(Screen.CapacitorTypeDetails(CapacitorType.Variable)) },
            )
        )
    }
}
