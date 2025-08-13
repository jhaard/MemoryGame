package org.jhaard.memorygame.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import org.jhaard.memorygame.components.GameButton
import org.jhaard.memorygame.components.LoadingIndicator
import org.jhaard.memorygame.viewModels.StartViewModel
import org.kodein.di.compose.localDI
import org.kodein.di.instance

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
    val di = localDI()
    val startViewModel: StartViewModel by di.instance()

    val loading by startViewModel.isLoading.collectAsState(false)

//    LaunchedEffect(Unit) {
//        startViewModel.fetchImages("vehicle")
//    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF232323))
            .padding(20.dp)
    ) {
        if (loading) {
            LoadingIndicator()
        } else {

            /*
            TEMP BUTTON TO LOAD FROM API
             */

            GameButton(
                navController = navController,
                navOptions = navOptions,
                route = "",
                buttonText = "FETCH IMAGES - DEV",
                onClick = {
                    startViewModel.fetchImages("vehicle")
                }

                )
            Text(
                text = "MEMORY GAME",
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            GameButton(
                navController = navController,
                navOptions = navOptions,
                route = "game_screen",
                buttonText = "PLAY",
                onClick = {
                    navController.navigate(route = "game_screen", navOptions = navOptions)
                }
            )
        }
    }

}