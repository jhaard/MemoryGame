package org.jhaard.memorygame.uiTheme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import memorygame.composeapp.generated.resources.Monofett_Regular
import memorygame.composeapp.generated.resources.Nunito_Regular
import memorygame.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

/**
 * Game theme file
 */

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
            fontStyle = FontStyle.Normal,
            brush = PrimaryGradient
        ),

        // Small headline - MONOFETT
        headlineLarge = TextStyle(
            fontFamily = mainFont,
            fontSize = 48.sp,
            letterSpacing = 4.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
            brush = PrimaryGradient
        ),

        // Timer text - NUNITO
        headlineSmall = TextStyle(
            fontFamily = plainFont,
            fontSize = 22.sp,
            letterSpacing = 2.sp,
            textAlign = TextAlign.End,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            brush = PrimaryGradient
        ),

        // timer number - NUNITO
        titleLarge = TextStyle(
            fontFamily = plainFont,
            fontSize = 22.sp,
            letterSpacing = 2.sp,
            textAlign = TextAlign.End,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            color = PrimaryColor
        ),

        // Button text - NUNITO
        titleMedium = TextStyle(
            fontFamily = plainFont,
            fontSize = 20.sp,
            letterSpacing = 2.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            brush = PrimaryGradient
        ),

        // Info text - NUNITO
        bodyLarge = TextStyle(
            fontFamily = plainFont,
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
            color = PrimaryColor
        ),

    )

    MaterialTheme(
        colorScheme = AppColors,
        typography = appTypography,
        shapes = AppShapes,
        content = content
    )
}