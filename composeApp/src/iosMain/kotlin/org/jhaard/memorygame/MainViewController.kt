package org.jhaard.memorygame

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    App(startViewModel = remember { Modules.startViewModel() })
}