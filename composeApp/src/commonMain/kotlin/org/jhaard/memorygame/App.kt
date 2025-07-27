package org.jhaard.memorygame

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jhaard.memorygame.components.StartScreen
import org.jhaard.memorygame.viewModels.StartViewModel

/**
 * Starting composable function for the applications.
 *
 * @param startViewModel The startViewModel for the StartScreen.
 */
@Composable
@Preview
fun App(startViewModel: StartViewModel) {

    MaterialTheme {
        StartScreen(startViewModel = startViewModel)
    }

}