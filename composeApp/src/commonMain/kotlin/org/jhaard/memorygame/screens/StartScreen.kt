package org.jhaard.memorygame.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import memorygame.composeapp.generated.resources.Monofett_Regular
import memorygame.composeapp.generated.resources.Res
import memorygame.composeapp.generated.resources.neon_backside
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jhaard.memorygame.animations.spinning
import org.jhaard.memorygame.components.GameButton
import org.jhaard.memorygame.components.LoadingIndicator
import org.jhaard.memorygame.viewModels.StartViewModel
import org.kodein.di.compose.viewmodel.rememberViewModel

/**
 * Start screen of the game. Load images here.
 *
 * @param navController For navigation.
 * @param navOptions Navigation options.
 *
 * TODO Restrict fetches.
 * TODO Adjust composable to custom theme.
 */
@Composable
fun StartScreen(
    navController: NavController,
    navOptions: NavOptions
) {
    val startViewModel: StartViewModel by rememberViewModel()

    val loading by startViewModel.isLoading.collectAsState(false)

    val spinning = spinning()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF232323))
            .padding(40.dp)
    ) {
        if (loading) {
            LoadingIndicator()
        } else {

            Text(
                text = "MEMORY GAME",
                fontFamily = FontFamily(Font(Res.font.Monofett_Regular)),
                letterSpacing = 4.sp,
                fontSize = 48.sp,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Green,
                            Color.Cyan
                        )
                    )
                ),
                modifier = Modifier
                    .weight(2f)
            )

            Image(
                painter = painterResource(Res.drawable.neon_backside),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                contentDescription = "Tile at start",
                modifier = Modifier
                    .size(width = 200.dp, height = 200.dp)
                    .graphicsLayer {
                        rotationY = spinning
                        cameraDistance = 30f
                    }
                    .clip(shape = RoundedCornerShape(20.dp))
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
            )

            /*
            TEMP BUTTON TO LOAD FROM API
             */

            Column(
                verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                    // .padding(20.dp)
                    .weight(3f)
            ) {
                GameButton(
                    navController = navController,
                    navOptions = navOptions,
                    route = "",
                    buttonText = "FETCH IMAGES - DEV",
                    onClick = {
                        startViewModel.fetchImages("animal")
                    },
                    modifier = Modifier

                )

                GameButton(
                    navController = navController,
                    navOptions = navOptions,
                    route = "game_screen",
                    buttonText = "PLAY",
                    onClick = {
                        navController.navigate(route = "game_screen", navOptions = navOptions)
                    },
                    modifier = Modifier
                )

            }

        }
    }

}