package org.jhaard.memorygame.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavOptions

@Composable
fun GameButton(navController: NavController, navOptions: NavOptions, modifier: Modifier,  route: String, buttonText: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonColors(
            containerColor = Color(0xFF232323),
            contentColor = Color.White,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.Gray
        ),
        modifier = modifier
            .fillMaxWidth()
            .border(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color.Green,
                        Color.Cyan
                    ),
                ),
                width = 4.dp,
                shape = RoundedCornerShape(size = 20.dp)
            )
    ) {
        Text(
            text = buttonText,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            style = TextStyle(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color.Green,
                        Color.Cyan
                    )
                )
            )
        )
    }
}