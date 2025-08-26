package org.jhaard.memorygame

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jhaard.memorygame.navigation.Navigation
import org.jhaard.memorygame.uiTheme.MemoryGameTheme

/**
 * Starting composable function for the applications.
 */
@Composable
@Preview
fun App() {

    MemoryGameTheme {
        Navigation()
    }

}