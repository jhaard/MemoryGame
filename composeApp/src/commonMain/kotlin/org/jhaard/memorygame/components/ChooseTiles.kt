package org.jhaard.memorygame.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import memorygame.composeapp.generated.resources.Monofett_Regular
import memorygame.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun ChooseTiles(listOfKeys: List<String>, onClick: (String) -> Unit) {
    val mintGreen = Color(0xFF73F4A7)
    val skyBlue = Color(0xFF5FD0EA)

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize(0.9f)
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(Color(0xFF232323))

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

            Text(
                text = "TILES",
                fontFamily = FontFamily(Font(Res.font.Monofett_Regular)),
                letterSpacing = 4.sp,
                fontSize = 48.sp,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            mintGreen,
                            skyBlue
                        )
                    )
                ),
            )
            listOfKeys.forEach {
                GameButton(
                    buttonText = it,
                    animate = false,
                    onClick = { onClick(it) },
                )
            }

        }



}