package org.jhaard.memorygame.uiTheme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import memorygame.composeapp.generated.resources.Nunito_Regular
import memorygame.composeapp.generated.resources.Res
import memorygame.composeapp.generated.resources.RubikDoodleShadow_Regular
import org.jetbrains.compose.resources.Font

/**
 * Game theme file
 */

@Composable
fun MemoryGameTheme(content: @Composable () -> Unit) {

    val mainFont = FontFamily(Font(Res.font.RubikDoodleShadow_Regular))
    val plainFont = FontFamily(Font(Res.font.Nunito_Regular))

    val appTypography = Typography(

        // App title
        displayLarge = TextStyle(
            fontFamily = mainFont,
            fontSize = 62.sp,
            letterSpacing = 4.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
            color = AppPink,
            shadow = Shadow(color = AppPink, offset = Offset.Zero, blurRadius = 1f)
        ),

        displaySmall = TextStyle(
            fontFamily = mainFont,
            fontSize = 28.sp,
            letterSpacing = 2.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            color = AppPink
        ),

        // Small headline
        headlineLarge = TextStyle(
            fontFamily = mainFont,
            fontSize = 48.sp,
            letterSpacing = 4.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
            color = AppPink
        ),

        // Score
        headlineMedium = TextStyle(
            fontFamily = mainFont,
            fontSize = 16.sp,
            letterSpacing = 2.sp,
            textAlign = TextAlign.End,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            color = AppAqua
        ),

        // Timer text
        headlineSmall = TextStyle(
            fontFamily = mainFont,
            fontSize = 16.sp,
            letterSpacing = 2.sp,
            textAlign = TextAlign.End,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            color = ForegroundColor
        ),

        // timer number
        titleLarge = TextStyle(
            fontFamily = mainFont,
            fontSize = 16.sp,
            letterSpacing = 2.sp,
            textAlign = TextAlign.End,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            color = AppPink
        ),

        // Button text
        titleMedium = TextStyle(
            fontFamily = mainFont,
            fontSize = 20.sp,
            letterSpacing = 4.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.SemiBold,
            color = ForegroundColor,
            shadow = Shadow(color = BackgroundColor, offset = Offset.Zero, blurRadius = 1f)

    ),

        // Info text - NUNITO
        bodyLarge = TextStyle(
            fontFamily = plainFont,
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
            color = ForegroundColor
        ),

    )

    MaterialTheme(
        colorScheme = AppColors,
        typography = appTypography,
        shapes = AppShapes,
        content = content
    )
}