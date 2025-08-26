package org.jhaard.memorygame.screens

import androidx.compose.animation.core.EaseInOutElastic
import androidx.compose.animation.core.RepeatMode
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import org.jhaard.memorygame.animations.alphaAnimation
import org.jhaard.memorygame.animations.spinningAnimation
import org.jhaard.memorygame.components.ChooseTiles
import org.jhaard.memorygame.components.LoadingIndicator
import org.jhaard.memorygame.navigation.Screens
import org.jhaard.memorygame.screens.views.StartView
import org.jhaard.memorygame.uiTheme.AppSpacing
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

    val alphaAnimation = alphaAnimation()

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

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = AppSpacing.small)
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
                        StartView(
                            animations = arrayOf(alphaAnimation, spinning),
                            onPlay = {
                                showSets = true
                            },
                            onHighScore = {
                                // Navigate
                            },
                        )

                    }
            }
        }
    }

}