package org.jhaard.memorygame.screens

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import memorygame.composeapp.generated.resources.diamond_shape_backside
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jhaard.memorygame.animations.spinningAnimation
import org.jhaard.memorygame.components.ChooseTilesPopUp
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

    val spinning = spinningAnimation()

    var showPopup by remember { mutableStateOf(false) }
    var fetching by remember { mutableStateOf(false) }


    val listOfKeys = listOf(
        "Vehicle",
        "Animal",
        "Plant",
        "Last set"
    )

    val mintGreen = Color(0xFF73F4A7)
    val skyBlue = Color(0xFF5FD0EA)

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF232323))
            .padding(top = 20.dp)
    ) {
        if (showPopup) {
            when (loading) {
                true -> LoadingIndicator()
                false -> ChooseTilesPopUp(
                    listOfKeys = listOfKeys,
                    onClick = {
                        startViewModel.fetchImages(key = it)
                        navController.navigate(route = "game_screen", navOptions = navOptions)
                    },
                    onDismiss = {
                        showPopup = false
                    }
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .weight(1f)
        ) {

            Text(
                text = "MEMORY GAME",
                fontFamily = FontFamily(Font(Res.font.Monofett_Regular)),
                letterSpacing = 4.sp,
                fontSize = 72.sp,
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

            Image(
                painter = painterResource(Res.drawable.diamond_shape_backside),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                contentDescription = "Tile at start",
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)
                    .graphicsLayer {
                        rotationY = spinning
                        cameraDistance = 30f
                    }
                    .clip(shape = RoundedCornerShape(20.dp))
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
            )

        }

        Column(
            verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                .weight(1f)
        ) {

            GameButton(
                buttonText = "PLAY",
                animate = true,
                onClick = {
                    showPopup = true
                })
            //navController.navigate(route = "game_screen", navOptions = navOptions)

            GameButton(
                buttonText = "FETCH - DEV",
                animate = false,
                onClick = {
                    //startViewModel.fetchImages("vehicle")
                },
            )

        }


    }

}