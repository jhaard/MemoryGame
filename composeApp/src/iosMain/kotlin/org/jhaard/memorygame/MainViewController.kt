package org.jhaard.memorygame

import androidx.compose.ui.window.ComposeUIViewController
import org.kodein.di.compose.withDI

fun MainViewController() = ComposeUIViewController {
    val platform = createIosModule()
    val appDI = createAppDI(platform = platform)

    withDI(appDI) {
        App()
    }

}