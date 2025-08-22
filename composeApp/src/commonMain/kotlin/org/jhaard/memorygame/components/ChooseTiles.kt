package org.jhaard.memorygame.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import org.jhaard.memorygame.uiTheme.AppBorderSizing
import org.jhaard.memorygame.uiTheme.AppShapes
import org.jhaard.memorygame.uiTheme.AppSpacing
import org.jhaard.memorygame.uiTheme.PrimaryGradient

@Composable
fun ChooseTiles(listOfKeys: List<String>, onClick: (String) -> Unit) {

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(0.9f)
            .padding(AppSpacing.small)
            .clip(shape = AppShapes.large)
            .background(MaterialTheme.colorScheme.background)
            .border(
                brush = PrimaryGradient,
                width = AppBorderSizing.xlarge,
                shape = AppShapes.large
            )
    ) {

        Text(
            text = "TILES",
            style = MaterialTheme.typography.headlineLarge,
        )
        listOfKeys.forEach {
            GameButton(
                buttonText = it.uppercase(),
                animate = false,
                onClick = { onClick(it) },
            )
        }

    }

}