package org.jhaard.memorygame.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Custom Loading indicator with text.
 */
@Composable
fun LoadingIndicator() {
    val mintGreen = Color(0xFF73F4A7)
    val skyBlue = Color(0xFF5FD0EA)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .padding(10.dp)
                .size(80.dp),
            color = Color.Black,
            trackColor = Color.Gray,
            strokeWidth = 8.dp
        )
        Text(
            text = "Activating service...\nThis might take up to 50 seconds.\n(Only the first time starting the app)",
            fontSize = 18.sp,
            color = Color.Green,
            textAlign = TextAlign.Center,
            style = TextStyle(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        mintGreen,
                        skyBlue
                    )
                )
            )
        )
    }
}