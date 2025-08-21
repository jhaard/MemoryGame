package org.jhaard.memorygame.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import org.jhaard.memorygame.animations.alphaAnimation
import org.jhaard.memorygame.animations.scaleAnimation
import org.jhaard.memorygame.uiTheme.AppBorderSizing
import org.jhaard.memorygame.uiTheme.AppShapes
import org.jhaard.memorygame.uiTheme.BackgroundColor
import org.jhaard.memorygame.uiTheme.PrimaryColor
import org.jhaard.memorygame.uiTheme.PrimaryGradient

@Composable
fun GameButton(buttonText: String, animate: Boolean, onClick: () -> Unit) {

    val alphaAnimation = alphaAnimation()
    val scaleAnimation = scaleAnimation()

    Button(
        onClick = onClick,
        colors = ButtonColors(
            containerColor = BackgroundColor,
            contentColor = PrimaryColor,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.Gray
        ),
        modifier = Modifier
            .graphicsLayer {
                if (animate) {
                    scaleX = scaleAnimation
                    scaleY = scaleAnimation
                }
            }
            .fillMaxWidth(0.6f)
            .alpha(alphaAnimation)
            .border(
                brush = PrimaryGradient,
                width = AppBorderSizing.large,
                shape = AppShapes.large
            )


    ) {
        Text(
            text = buttonText,
            style = MaterialTheme.typography.titleMedium
        )
    }
}