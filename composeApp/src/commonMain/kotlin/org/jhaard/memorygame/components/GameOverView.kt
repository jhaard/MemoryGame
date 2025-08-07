package org.jhaard.memorygame.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavOptions

/**
 * The Game Over view to display.
 * @param navController The NavController to navigate.
 * @param score The score to display.
 */
@Composable
fun GameOverView(navController: NavController, navOptions: NavOptions, score: Int) {
    Text(text = "GAME OVER", textAlign = TextAlign.Center, color = Color.Green)
    Text(text = "Your Score: $score", textAlign = TextAlign.Center, color = Color.LightGray)
    GameButton(navController = navController, navOptions = navOptions, route = "start_screen", buttonText = "Back to Start")
    GameButton(navController = navController, navOptions = navOptions, route = "game_screen", buttonText = "Retry")

}