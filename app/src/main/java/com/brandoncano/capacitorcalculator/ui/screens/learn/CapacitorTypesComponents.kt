package com.brandoncano.capacitorcalculator.ui.screens.learn

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.composables.AppBulletList
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleCallout
import com.brandoncano.sharedcomponents.text.textStyleSubhead

@Composable
fun CapacitorTypeListItem(
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
                modifier = Modifier.padding(top = 16.dp, bottom = bottomPadding),
                style = textStyleCallout(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            if (subText.isNotEmpty()) {
                AppBulletList(
                    bulletStrings = subText,
                    textStyle = textStyleSubhead().onSurfaceVariant(),
                    bulletVerticalSpace = 0.dp,
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        Image(
            modifier = Modifier.padding(16.dp),
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
        )
    }
}
