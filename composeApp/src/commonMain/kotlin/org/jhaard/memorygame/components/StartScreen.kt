package org.jhaard.memorygame.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.jhaard.memorygame.viewModels.StartViewModel

/**
 * Start screen of the game. Load images here.
 * TODO Restrict fetches.
 */
@Composable
fun StartScreen(startViewModel: StartViewModel) {

    val loading by startViewModel.isLoading.collectAsState(false)

    LaunchedEffect(Unit) {
        startViewModel.fetchImages()
    }

    Column {
        if (loading) {
            LoadingIndicator()
        }
    }

}