package org.jhaard.memorygame.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import org.jhaard.memorygame.uiTheme.AppShapes

@Composable
fun ChooseTiles(listOfKeys: List<String>, onClick: (String) -> Unit) {

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = AppShapes.large)
            .background(MaterialTheme.colorScheme.background)
    ) {

        Text(
            text = "THEME",
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