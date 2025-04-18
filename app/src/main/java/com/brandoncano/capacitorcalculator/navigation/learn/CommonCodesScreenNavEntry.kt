package com.brandoncano.capacitorcalculator.navigation.learn

import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.brandoncano.capacitorcalculator.navigation.Screen
import com.brandoncano.capacitorcalculator.ui.screens.learn.CommonCodesScreen

fun NavGraphBuilder.learnCommonCodes(
    navHostController: NavHostController,
) {
    composable(
        route = Screen.CommonCodes.route,
        enterTransition = { slideInVertically(initialOffsetY = { it }) },
        exitTransition = { slideOutVertically(targetOffsetY = { it }) },
    ) {
        CommonCodesScreen(
            onNavigateBack = { navHostController.popBackStack() },
        )
    }
}
