package com.brandoncano.capacitorcalculator.ui.screens.informationdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.brandoncano.capacitorcalculator.R
import com.brandoncano.capacitorcalculator.data.CapacitorType
import com.brandoncano.capacitorcalculator.ui.theme.CapacitorCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.text.textStyleHeadline

@Composable
fun InformationDetailsScreen(
    type: CapacitorType,
    onNavigateBack: () -> Unit,
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        when (type) {
            CapacitorType.Ceramic -> CeramicView()
            CapacitorType.Film -> FilmView()
            CapacitorType.Electrolytic -> ElectrolyticView()
            CapacitorType.Polymer -> PolymerView()
            CapacitorType.SuperCapacitor -> SuperCapacitorView()
            CapacitorType.Mica -> MicaView()
            CapacitorType.Variable -> VariableView()
        }
    }
}

