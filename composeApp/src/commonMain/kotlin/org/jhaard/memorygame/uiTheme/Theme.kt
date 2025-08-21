package org.jhaard.memorygame.uiTheme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import memorygame.composeapp.generated.resources.Monofett_Regular
import memorygame.composeapp.generated.resources.Nunito_Regular
import memorygame.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

/**
 * Theme-file
 */

// Colors
val BackgroundColor = Color(0xFF232323)
val PrimaryColor = Color(0xFFFEFEFE)
val GradientGreen = Color(0xFF73F4A7)
val GradientBlue = Color(0xFF5FD0EA)

// Gradient
val PrimaryGradient = Brush.linearGradient(
    colors = listOf(
        GradientGreen,
        GradientBlue
    )
)

// Color scheme
private val AppColors = lightColorScheme(
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

// Paddings and spaces
object AppSpacing {
    val small = 10.dp
    val medium = 20.dp
    val large = 30.dp
}

// Game theme
@Composable
fun MemoryGameTheme(content: @Composable () -> Unit) {

    val mainFont = FontFamily(Font(Res.font.Monofett_Regular))
    val plainFont = FontFamily(Font(Res.font.Nunito_Regular))

    val appTypography = Typography(

        // App title - MONOFETT
        displayLarge = TextStyle(
            fontFamily = mainFont,
            fontSize = 72.sp,
            letterSpacing = 4.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal
        ),

        // Small headline - MONOFETT
        headlineLarge = TextStyle(
            fontFamily = mainFont,
            fontSize = 48.sp,
            letterSpacing = 4.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal
        ),

        // Button text - NUNITO
        titleMedium = TextStyle(
            fontFamily = plainFont,
            fontSize = 20.sp,
            letterSpacing = 2.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
        ),

        // Info text - NUNITO
        bodyLarge = TextStyle(
            fontFamily = plainFont,
            fontSize = 16.sp,
            letterSpacing = 2.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
        ),

    )

    MaterialTheme(
        colorScheme = AppColors,
        typography = appTypography,
        shapes = AppShapes,
        content = content
    )
}