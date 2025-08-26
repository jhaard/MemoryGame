package org.jhaard.memorygame.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jhaard.memorygame.display.Orientation
import org.jhaard.memorygame.display.ScreenOrientation
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState
import org.jhaard.memorygame.uiTheme.AppSpacing
import org.kodein.di.compose.localDI
import org.kodein.di.instance

/**
 * The TileBoard composable.
 * @param onClick The tile at onClick.
 * @param tileList The tile list to use.
 * @param timer The visible timer.
 */


@Composable
fun TileBoard(onClick: (TileData) -> Unit, tileList: List<TileData>, timer: String) {

    val di = localDI()
    val orientation by di.instance<Orientation>()

    val count = when (orientation.getScreenOrientation()) {
        ScreenOrientation.PORTRAIT -> 4
        ScreenOrientation.LANDSCAPE -> 10
    }

    val screenSize = orientation.getScreenSize()

    LaunchedEffect(Unit) {
        println(screenSize)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = AppSpacing.medium),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Time left:",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = timer,
                style = MaterialTheme.typography.titleLarge
            )
        }
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppSpacing.xSmall),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalArrangement = Arrangement.Center,
            maxItemsInEachRow = count
        )
        {
            tileList.forEach { tile ->
                TileComponent(
                    tile = tile,
                    onClick = { onClick(tile) },
                    enabled = tile.tileState == TileState.IDLE
                )
            }

        }

    }

}