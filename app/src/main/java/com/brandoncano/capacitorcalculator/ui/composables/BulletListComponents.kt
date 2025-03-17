package com.brandoncano.capacitorcalculator.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleSubhead

@Composable
fun AppBulletList(
    items: List<String>,
    modifier: Modifier = Modifier,
    style: TextStyle = textStyleSubhead().onSurfaceVariant(),
    spacingBetweenBulletAndText: Dp = 8.dp,
    verticalSpacing: Dp = 4.dp,
    ellipse: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
) {
    Column(modifier = modifier) {
        items.forEach { itemText ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = verticalSpacing)
                    .padding(start = 8.dp),
            ) {
                Text(
                    text = "•",
                    style = style,
                )
                Spacer(modifier = Modifier.width(spacingBetweenBulletAndText))
                Text(
                    text = itemText,
                    style = style,
                    overflow = if (ellipse) TextOverflow.Ellipsis else TextOverflow.Clip,
                    maxLines = maxLines,
                )
            }
        }
    }
}
