package com.brandoncano.capacitorcalculator.ui.screens.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Policy
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.ui.screens.home.CapacitorInformationButtons
import com.brandoncano.capacitorcalculator.ui.screens.home.OurAppsButtons
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppArrowCardButton
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppStandardCard
import com.brandoncano.sharedcomponents.composables.AppTopAppBar
import com.brandoncano.sharedcomponents.data.ArrowCardButtonContents
import com.brandoncano.sharedcomponents.screen.AppInfoCard
import com.brandoncano.sharedcomponents.screen.AuthorCard
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleBody
import com.brandoncano.sharedcomponents.text.textStyleHeadline

@Composable
fun AboutScreen(
    onNavigateBack: () -> Unit,
    onViewPrivacyPolicyTapped: () -> Unit,
    onCapacitorTypesTapped: () -> Unit,
    onCapacitorValuesTapped: () -> Unit,
    onRateThisAppTapped: () -> Unit,
    onViewOurAppsTapped: () -> Unit,
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        AboutScreenContent(
            onNavigateBack = onNavigateBack,
            onViewPrivacyPolicyTapped = onViewPrivacyPolicyTapped,
            onRateThisAppTapped = onRateThisAppTapped,
            onCapacitorTypesTapped = onCapacitorTypesTapped,
            onCapacitorValuesTapped = onCapacitorValuesTapped,
            onViewOurAppsTapped = onViewOurAppsTapped,
        )
    }
}

@Composable
private fun AboutScreenContent(
    onNavigateBack: () -> Unit,
    onViewPrivacyPolicyTapped: () -> Unit,
    onCapacitorTypesTapped: () -> Unit,
    onCapacitorValuesTapped: () -> Unit,
    onRateThisAppTapped: () -> Unit,
    onViewOurAppsTapped: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
    ) {
        AppTopAppBar(
            titleText = stringResource(R.string.about_title),
            navigationIcon = Icons.Filled.Close,
            onNavigateBack = onNavigateBack,
        )
        Spacer(modifier = Modifier.height(12.dp))

        AuthorCard()
        Spacer(modifier = Modifier.height(16.dp))

        AppInfoCard(R.string.version, R.string.last_updated)
        Spacer(modifier = Modifier.height(16.dp))

        AppArrowCardButton(
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Policy,
                text = stringResource(id = R.string.about_view_privacy_policy),
                onClick = onViewPrivacyPolicyTapped,
            )
        )
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = stringResource(id = R.string.about_description),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 12.dp),
            style = textStyleHeadline(),
        )
        AppStandardCard {
            Text(
                text = stringResource(id = R.string.about_description_part_01),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp),
                style = textStyleBody().onSurfaceVariant(),
            )
            Text(
                text = stringResource(id = R.string.about_description_part_02),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp),
                style = textStyleBody().onSurfaceVariant(),
            )
            Text(
                text = stringResource(id = R.string.about_description_part_03),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 12.dp),
                style = textStyleBody().onSurfaceVariant(),
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        CapacitorInformationButtons(
            onCapacitorTypesTapped = onCapacitorTypesTapped,
            onCapacitorValuesTapped = onCapacitorValuesTapped,
        )
        Spacer(modifier = Modifier.height(32.dp))
        OurAppsButtons(
            onRateThisAppTapped = onRateThisAppTapped,
            onViewOurAppsTapped = onViewOurAppsTapped,
        )
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@AppScreenPreviews
@Composable
private fun AboutPreview() {
    CapacitorCalculatorTheme {
        AboutScreen(
            onNavigateBack = {},
            onViewPrivacyPolicyTapped = {},
            onCapacitorTypesTapped = {},
            onCapacitorValuesTapped = {},
            onRateThisAppTapped = {},
            onViewOurAppsTapped = {},
        )
    }
}
