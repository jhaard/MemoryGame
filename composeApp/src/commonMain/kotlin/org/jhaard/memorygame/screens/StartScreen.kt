package org.jhaard.memorygame.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.jhaard.memorygame.components.LoadingIndicator
import org.jhaard.memorygame.viewModels.StartViewModel

/**
 * Start screen of the game. Load images here.
 *
 * @param navController For navigation.
 * @param startViewModel The viewmodel for the start screen.
 *
 * TODO Restrict fetches.
 * TODO Adjust composable to custom theme.
 */
@Composable
fun StartScreen(
    navController: NavController,
    startViewModel: StartViewModel
) {

    val loading by startViewModel.isLoading.collectAsState(false)

    LaunchedEffect(Unit) {
        startViewModel.fetchImages("vehicle")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(20.dp)
    ) {
        if (loading) {
            LoadingIndicator()
        } else {
            Text(
                text = "MEMORY GAME",
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Button(
                onClick = ({
                    navController.navigate("game_screen")
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
                    text = "PLAY",
                    fontSize = 18.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}