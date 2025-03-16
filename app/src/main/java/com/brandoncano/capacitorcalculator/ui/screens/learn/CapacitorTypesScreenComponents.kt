package com.brandoncano.capacitorcalculator.ui.screens.learn

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.ui.composables.AppBulletList
import com.brandoncano.sharedcomponents.composables.AppDivider
import com.brandoncano.sharedcomponents.text.textStyleCallout

@Composable
fun ArrowCardButtonWithSubText(
    cardTexts: List<String>,
    subTexts: List<List<String>> = listOf(),
    onClicks: List<(() -> Unit)>,
) {
    if (cardTexts.size != subTexts.size || cardTexts.size != onClicks.size) return
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        onClicks.forEachIndexed { index, onClick ->
            CapacitorTypeListItem(cardTexts[index], subTexts[index], onClick)
            if (onClicks.size - 1 != index) {
                AppDivider(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
            }
        }
    }
}

@Composable
private fun CapacitorTypeListItem(
    cardText: String,
    subText: List<String>,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .clickable(role = Role.Button, onClick = onClick)
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
        ) {
            val bottomPadding = if (subText.isEmpty()) 16.dp else 4.dp
            Text(
                text = cardText,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = bottomPadding),
                style = textStyleCallout(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            if (subText.isNotEmpty()) {
                AppBulletList(
                    items = subText,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                    verticalSpacing = 0.dp,
                    ellipse = true,
                    maxLines = 1,
                )
            }
        }
        Image(
            modifier = Modifier.padding(16.dp),
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = stringResource(id = R.string.content_right_arrow),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
        )
    }
}
