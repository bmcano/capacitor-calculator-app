package com.brandoncano.capacitorcalculator.navigation

import android.app.Activity
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.data.BillingManager
import com.brandoncano.capacitorcalculator.ui.screens.donate.DonateScreen
import com.brandoncano.sharedcomponents.navigation.SharedScreens
import com.brandoncano.sharedcomponents.utils.GetProductIdForAmount
import kotlinx.coroutines.launch

fun NavGraphBuilder.donateScreen(
    navHostController: NavHostController,
) {
    composable(
        route = SharedScreens.Donate.route,
        enterTransition = { slideInVertically(initialOffsetY = { it }) },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { slideOutVertically(targetOffsetY= { it }) },
    ) {
        val context = LocalContext.current
        val activity = context as? Activity ?: return@composable

        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }
        val billingManager = remember { BillingManager(context) }

        billingManager.startConnection(
            onError = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = context.getString(R.string.donate_error_text)
                    )
                }
            }
        )

        DonateScreen(
            onNavigateBack = { navHostController.popBackStack() },
            onContinueToPaymentTapped = {
                val productId = GetProductIdForAmount.execute(it)
                billingManager.launchPurchaseFlow(activity, productId)
            },
            snackbarHostState = snackbarHostState,
        )
    }
}