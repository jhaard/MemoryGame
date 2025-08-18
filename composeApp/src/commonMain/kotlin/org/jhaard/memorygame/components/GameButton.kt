package org.jhaard.memorygame.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import org.jhaard.memorygame.animations.alphaAnimation
import org.jhaard.memorygame.animations.scaleAnimation

@Composable
fun GameButton(buttonText: String, animate: Boolean, onClick: () -> Unit) {

    val alphaAnimation = alphaAnimation()
    val scaleAnimation = scaleAnimation()

    val mintGreen = Color(0xFF73F4A7)
    val skyBlue = Color(0xFF5FD0EA)

    Button(
        onClick = onClick,
        colors = ButtonColors(
            containerColor = Color(0xFF232323),
            contentColor = Color.White,
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
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        mintGreen,
                        skyBlue
                    ),
                ),
                width = 4.dp,
                shape = RoundedCornerShape(size = 20.dp)
            )


    ) {
        Text(
            text = buttonText,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            style = TextStyle(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        mintGreen,
                        skyBlue
                    )
                )
            ),
            letterSpacing = 2.sp,
            modifier = Modifier
        )
    }
}