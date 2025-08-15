package org.jhaard.memorygame.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import org.jhaard.memorygame.components.GameButton

/**
 * The Game Over view to display.
 * @param navController The NavController to navigate.
 * @param score The score to display.
 */
@Composable
fun GameOverScreen(navController: NavController, navOptions: NavOptions, score: Int, onClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF232323))
            .padding(20.dp)
    ) {
        Text(text = "GAME OVER", textAlign = TextAlign.Center, color = Color.Green)
        Text(text = "Your Score: $score", textAlign = TextAlign.Center, color = Color.LightGray)
        GameButton(
            navController = navController,
            navOptions = navOptions,
            route = "start_screen",
            buttonText = "Back to Start",
            onClick = {},
            modifier = Modifier

        )
        GameButton(
            navController = navController,
            navOptions = navOptions,
            route = "game_screen",
            buttonText = "Retry",
            onClick = onClick,
            modifier = Modifier
        )

    }


}