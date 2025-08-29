package org.jhaard.memorygame.screens.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jhaard.memorygame.components.TileBoard
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.uiTheme.AppSpacing

@Composable
fun PlayView(tileList: List<TileData>, timer: String, score: String, onClick: (TileData) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(AppSpacing.medium)
    ) {

        TileBoard(tileList = tileList, timer = timer, score = score, onClick = onClick)

    }
}