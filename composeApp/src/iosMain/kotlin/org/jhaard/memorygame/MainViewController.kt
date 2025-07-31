package org.jhaard.memorygame

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    App(startViewModel = Modules.startViewModel())
}