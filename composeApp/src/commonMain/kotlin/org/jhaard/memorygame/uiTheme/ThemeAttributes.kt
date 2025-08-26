package org.jhaard.memorygame.uiTheme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


// Colors
val BackgroundColor = Color(0xFF404040)
val PrimaryColor = Color(0xFFFEFEFE)
val GradientBlue = Color(0xFF5FD0EA)
val ComplementaryRed = Color(0xFFEA795F)
val TileFlipBorderColor = Color(0xFF1c5de6)
val TileMatchBorderColor = Color(0xFF11D962)

// Gradient
val PrimaryGradient = Brush.linearGradient(
    colors = listOf(
        PrimaryColor,
        GradientBlue,
        GradientBlue,
        GradientBlue,
        GradientBlue,
    )
)

// Color scheme
val AppColors = lightColorScheme(
    primary = GradientBlue,
    secondary = ComplementaryRed,
    background = BackgroundColor,
    onPrimary = PrimaryColor,
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
}

// Elevation
object AppCardElevation {
    val small = 2.dp
}

// Elevation
object AppButtonElevation {
    val pressed = 0.dp
    val unPressed = 10.dp
}

// Image size
object AppImageSizing {
    val smallImageSize = 50.dp
    val largeImageSize = 100.dp
    val largeTileSize = 70.dp
    val smallTileSize = 55.dp
    val defaultTileSize = 50.dp
}