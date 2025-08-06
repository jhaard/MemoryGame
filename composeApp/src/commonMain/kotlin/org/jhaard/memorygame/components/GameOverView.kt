package org.jhaard.memorygame.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

/**
 * The Game Over view to display.
 * @param navController The NavController to navigate.
 * @param score The score to display.
 */
@Composable
fun GameOverView(navController: NavController, score: Int) {
    Text(text = "GAME OVER", textAlign = TextAlign.Center, color = Color.Green)
    Text(text = "Your Score: $score", textAlign = TextAlign.Center, color = Color.LightGray)
    Button(
        onClick = ({
            navController.navigate("game_screen")
        }),
        colors = ButtonColors(
            containerColor = Color.White,
            contentColor = Color.Gray,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.Gray
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Retry",
            fontSize = 18.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}