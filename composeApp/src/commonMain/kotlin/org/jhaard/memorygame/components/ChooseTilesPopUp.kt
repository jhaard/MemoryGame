package org.jhaard.memorygame.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup

@Composable
fun ChooseTilesPopUp(listOfKeys: List<String>, onClick: (String) -> Unit, onDismiss: () -> Unit) {
    val mintGreen = Color(0xFF73F4A7)
    val skyBlue = Color(0xFF5FD0EA)

    Popup(alignment = Alignment.Center, onDismissRequest = onDismiss) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.8f)
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(Color.White)

                .border(

                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            mintGreen,
                            skyBlue
                        ),
                    ),
                    width = 10.dp,
                    shape = RoundedCornerShape(size = 20.dp)
                )
        ) {
            listOfKeys.forEach {
                GameButton(
                    buttonText = it,
                    animate = false,
                    onClick = { onClick(it) },
                )
            }

        }

    }

}