package org.jhaard.memorygame.uiTheme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


// Colors
val BackgroundColor = Color(0xFF232323)
val PrimaryColor = Color(0xFFFEFEFE)
val GradientGreen = Color(0xFF73F4A7)
val GradientBlue = Color(0xFF5FD0EA)
val TileFlipBorderColor = Color.Blue
val TileMatchBorderColor = Color.Green

// Gradient
val PrimaryGradient = Brush.linearGradient(
    colors = listOf(
        GradientGreen,
        GradientBlue
    )
)

// Color scheme
val AppColors = lightColorScheme(
    primary = GradientGreen,
    secondary = GradientBlue,
    background = BackgroundColor,
    onPrimary = PrimaryColor,
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

// Image size
object AppImageSizing {
    val smallImageSize = 50.dp
    val largeImageSize = 100.dp
    val tileSize = 70.dp
}