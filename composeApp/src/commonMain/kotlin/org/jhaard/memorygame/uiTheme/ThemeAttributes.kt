package org.jhaard.memorygame.uiTheme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


val BackgroundColor = Color(0xFF424242)
val ForegroundColor = Color(0xFFfafafa)
val ButtonTextColor = Color(0xFFfafafa)

val AppLightGreen = Color(0xFF82E895)
val AppRed = Color(0xFFED1216)
val AppGreen = Color(0xFF1D9F35)
val AppPink = Color(0xFFf361ff)
val AppPurple = Color(0xFFa271ff)
val TileFlipBorderColor = AppRed
val TileMatchBorderColor = AppGreen

val GradientBrush = Brush.linearGradient(
    colors = listOf(AppPink, AppPurple, AppPink)
)

// Color scheme
val AppColors = lightColorScheme(
    primary = AppLightGreen,
    secondary = AppRed,
    background = BackgroundColor,
    onPrimary = ForegroundColor,
    tertiary = AppGreen,
    surface = AppPurple,
    onSurface = ButtonTextColor,
    onSecondary = TileFlipBorderColor,
    onTertiary = TileMatchBorderColor
)

// Shapes
val AppShapes = Shapes(
    small = RoundedCornerShape(5.dp),
    medium = RoundedCornerShape(10.dp),
    large = RoundedCornerShape(20.dp)
)

// Border width
object AppBorderSizing {
    val small = 2.dp
    val large = 4.dp
    val xlarge = 10.dp
}

// Paddings and spaces
object AppSpacing {
    val xSmall = 5.dp
    val small = 10.dp
    val medium = 20.dp
    val large = 25.dp
}

// Elevation
object AppCardElevation {
    val small = 2.dp
}

// Elevation
object AppButtonElevation {
    val pressed = 0.dp
    val unPressed = 8.dp
}

// Image size
object AppImageSizing {
    val smallImageSize = 50.dp
    val largeImageSize = 100.dp
    val largeTileSize = 70.dp
    val mediumTileSize = 60.dp
    val smallTileSize = 55.dp
    val defaultTileSize = 50.dp
}