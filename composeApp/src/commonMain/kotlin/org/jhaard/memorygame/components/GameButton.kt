package org.jhaard.memorygame.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import org.jhaard.memorygame.animations.scaleAnimation
import org.jhaard.memorygame.uiTheme.AppBorderSizing
import org.jhaard.memorygame.uiTheme.AppButtonElevation

@Composable
fun GameButton(buttonText: String, animate: Boolean, onClick: () -> Unit) {

    val scaleAnimation = scaleAnimation()

    Button(
        onClick = onClick,
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.Gray
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = AppButtonElevation.unPressed,
            pressedElevation = AppButtonElevation.pressed,
            focusedElevation = AppButtonElevation.unPressed,
            hoveredElevation = AppButtonElevation.unPressed,
            disabledElevation = AppButtonElevation.unPressed
        ),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .graphicsLayer {
                if (animate) {
                    scaleX = scaleAnimation
                    scaleY = scaleAnimation
                }
            }
            .fillMaxWidth(0.6f)
            .border(
                color = MaterialTheme.colorScheme.primary,
                width = AppBorderSizing.small,
                shape = MaterialTheme.shapes.large
            )

    ) {
        Text(
            text = buttonText,
            style = MaterialTheme.typography.titleMedium
        )
    }
}