package com.brandoncano.capacitorcalculator.ui.composables

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Feedback
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.navigation.Screen
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.capacitorcalculator.util.EmailFeedback
import com.brandoncano.capacitorcalculator.util.ShareCapacitance
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews
import com.brandoncano.sharedcomponents.composables.MenuIcon
import com.brandoncano.sharedcomponents.composables.MenuText

/**
 * Note: Menu items are in alphabetical order
 */

@Composable
fun AboutAppMenuItem(onAboutTapped: () -> Unit) {
    DropdownMenuItem(
        text = { MenuText(stringRes = R.string.menu_about) },
        onClick = onAboutTapped,
        leadingIcon = { MenuIcon(Icons.Outlined.Info) },
    )
}

@Composable
fun AppThemeMenuItem(
    openMenu: MutableState<Boolean>,
    onThemeSelected: () -> Unit,
) {
    DropdownMenuItem(
        text = { MenuText(stringRes = R.string.menu_app_theme) },
        onClick = {
            openMenu.value = false
            onThemeSelected()
        },
        leadingIcon = { MenuIcon(Icons.Outlined.Palette) },
    )
}

@Deprecated("")
@Composable
fun AboutAppMenuItem(navController: NavController, showMenu: MutableState<Boolean>) {
    DropdownMenuItem(
        text = { MenuText(stringRes = R.string.menu_about) },
        onClick = {
            showMenu.value = false
            navController.navigate(Screen.About.route)
        },
        leadingIcon = { MenuIcon(Icons.Outlined.Info) },
    )
}

@Deprecated("")
@Composable
fun ClearSelectionsMenuItem(onClick: (() -> Unit)) {
    DropdownMenuItem(
        text = { MenuText(stringRes = R.string.menu_clear) },
        onClick = onClick,
        leadingIcon = { MenuIcon(Icons.Outlined.Cancel) },
    )
}

@Deprecated("")
@Composable
fun FeedbackMenuItem(context: Context, showMenu: MutableState<Boolean>) {
    DropdownMenuItem(
        text = { MenuText(stringRes = R.string.menu_feedback) },
        onClick = {
            showMenu.value = false
            EmailFeedback.execute(context)
        },
        leadingIcon = { MenuIcon(Icons.Outlined.Feedback) },
    )
}

@Deprecated("")
@Composable
fun ShareMenuItem(text: String, context: Context, showMenu: MutableState<Boolean>) {
    DropdownMenuItem(
        text = { MenuText(stringRes = R.string.menu_share) },
        onClick = {
            showMenu.value = false
            ShareCapacitance.execute(text, context)
        },
        leadingIcon = { MenuIcon(Icons.Outlined.Share) },
    )
}

@AppComponentPreviews
@Composable
private fun MenuItemsPreview() {
    val showMenu = remember { mutableStateOf(false) }
    CapacitorCalculatorTheme {
        Column {
            AboutAppMenuItem {}
            AppThemeMenuItem(showMenu) {}
        }
    }
}
