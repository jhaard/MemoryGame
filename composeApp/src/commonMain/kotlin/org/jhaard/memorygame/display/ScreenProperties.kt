package org.jhaard.memorygame.display

enum class ScreenOrientation {
    PORTRAIT, LANDSCAPE
}

data class ScreenSize(
    val width: Int,
    val height: Int,
    val orientation: ScreenOrientation
)