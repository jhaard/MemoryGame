package org.jhaard.memorygame

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jhaard.memorygame.navigation.Navigation
import org.kodein.di.compose.withDI

/**
 * Starting composable function for the applications.
 */
@Composable
@Preview
fun App() {
    withDI(appDI) {

        MaterialTheme {
            Navigation()
        }

    }
}