package org.jhaard.memorygame.screens

import androidx.compose.animation.core.EaseInOutElastic
import androidx.compose.animation.core.RepeatMode
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import memorygame.composeapp.generated.resources.Res
import memorygame.composeapp.generated.resources.diamond_shape_backside
import org.jetbrains.compose.resources.painterResource
import org.jhaard.memorygame.animations.spinningAnimation
import org.jhaard.memorygame.components.ChooseTiles
import org.jhaard.memorygame.components.GameButton
import org.jhaard.memorygame.components.LoadingIndicator
import org.jhaard.memorygame.navigation.Screens
import org.jhaard.memorygame.uiTheme.AppBorderSizing
import org.jhaard.memorygame.uiTheme.AppImageSizing
import org.jhaard.memorygame.uiTheme.AppShapes
import org.jhaard.memorygame.uiTheme.AppSpacing
import org.jhaard.memorygame.uiTheme.BackgroundColor
import org.jhaard.memorygame.uiTheme.PrimaryGradient
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

    val spinning =
        spinningAnimation(target = 180f, easing = EaseInOutElastic, repeatMode = RepeatMode.Reverse)

    var showSets by remember { mutableStateOf(false) }

    val listOfKeys = listOf(
        "Vehicle",
        "Animal",
        "Plant"
    )

    LaunchedEffect(Unit) {
        listOfKeys.forEach {
            startViewModel.fetchImages(key = it)
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(top = AppSpacing.medium)
    ) {
        when (loading) {
            true -> LoadingIndicator()
            false ->
                if (showSets) {
                    ChooseTiles(
                        listOfKeys = listOfKeys,
                        onClick = {
                            val route = Screens.GameScreen.withArguments(it)
                            navController.navigate(route = route, navOptions = navOptions)
                        }
                    )
                } else {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .weight(1f)
                    ) {

                        Text(
                            text = "MEMORY GAME",
                            style = MaterialTheme.typography.displayLarge
                        )

                        Image(
                            painter = painterResource(Res.drawable.diamond_shape_backside),
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.Center,
                            contentDescription = "Tile at start",
                            modifier = Modifier
                                .size(AppImageSizing.largeImageSize)
                                .graphicsLayer {
                                    rotationY = spinning
                                    cameraDistance = 30f
                                }
                                .clip(shape = AppShapes.large)
                                .border(
                                    brush = PrimaryGradient,
                                    width = AppBorderSizing.large,
                                    shape = AppShapes.large
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
                                showSets = true
                            })

                        GameButton(
                            buttonText = "HIGH SCORE",
                            animate = false,
                            onClick = {
                                // Navigate
                            },
                        )

                    }

                }
        }
    }

}