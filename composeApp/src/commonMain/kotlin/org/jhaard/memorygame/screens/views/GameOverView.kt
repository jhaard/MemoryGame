package org.jhaard.memorygame.screens.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jhaard.memorygame.components.GameButton
import org.jhaard.memorygame.uiTheme.AppSpacing

/**
 * The Game Over view to display.
 * @param score The score to display.
 */
@Composable
fun GameOverView(score: Int, onRetry: () -> Unit, onBack: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(AppSpacing.medium)
    ) {
        Text(
            text = "GAME OVER",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.padding(AppSpacing.xSmall))

        Text(
            text = "YOUR SCORE: $score",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.padding(AppSpacing.small))

        GameButton(
            buttonText = "RETRY",
            animate = false,
            onClick = onRetry,
        )

        Spacer(modifier = Modifier.padding(AppSpacing.medium))

        GameButton(
            buttonText = "BACK",
            onClick = onBack,
            animate = false,
        )

    }


}