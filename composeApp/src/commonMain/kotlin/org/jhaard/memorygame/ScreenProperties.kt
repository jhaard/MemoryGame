package org.jhaard.memorygame

enum class ScreenOrientation {
    PORTRAIT, LANDSCAPE
}

data class ScreenSize(
    val width: Int,
    val height: Int,
    val orientation: ScreenOrientation
)