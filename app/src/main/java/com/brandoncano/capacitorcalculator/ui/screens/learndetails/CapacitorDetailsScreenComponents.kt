package com.brandoncano.capacitorcalculator.ui.screens.learndetails

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleHeadline
import com.brandoncano.sharedcomponents.text.textStyleSubhead

@Composable
fun CapacitorImage(
    @DrawableRes imgRes: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imgRes),
            contentDescription = stringResource(id = R.string.information_details_content_description),
            modifier = Modifier.size(128.dp),
        )
    }
}

@Composable
fun HeaderBodyInformation(
    @StringRes header: Int,
    @StringRes vararg bodyTexts: Int
) {
    Column {
        Text(
            text = stringResource(id = header),
            modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.Start),
            style = textStyleHeadline(),
        )
        bodyTexts.forEach { body ->
            Text(
                text = stringResource(id = body),
                modifier = Modifier.padding(top = 12.dp),
                style = textStyleSubhead().onSurfaceVariant(),
            )
        }
    }
}
