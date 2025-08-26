package org.jhaard.memorygame.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import org.jhaard.memorygame.animations.scaleAnimation
import org.jhaard.memorygame.uiTheme.AppButtonElevation

@Composable
fun GameButton(buttonText: String, animate: Boolean, onClick: () -> Unit) {

    val scaleAnimation = scaleAnimation()

    Button(
        onClick = onClick,
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.background,
            disabledContentColor = MaterialTheme.colorScheme.background
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = AppButtonElevation.unPressed,
            pressedElevation = AppButtonElevation.pressed,
            focusedElevation = AppButtonElevation.pressed,
            hoveredElevation = AppButtonElevation.pressed,
            disabledElevation = AppButtonElevation.pressed
        ),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth(0.6f)

            .graphicsLayer {
                if (animate) {
                    scaleX = scaleAnimation
                    scaleY = scaleAnimation
                }
            }

    ) {
        Text(
            text = buttonText,
            style = MaterialTheme.typography.titleMedium
        )
    }
}