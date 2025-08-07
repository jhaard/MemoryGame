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

@Composable
fun GameButton(navController: NavController, route: String, buttonText: String) {
    Button(
        onClick = ({
            navController.navigate(route = route)
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
            text = buttonText,
            fontSize = 18.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}