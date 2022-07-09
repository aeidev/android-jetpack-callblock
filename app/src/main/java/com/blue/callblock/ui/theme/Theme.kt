package com.blue.callblock.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Blue499,
    primaryVariant = Blue499,
    secondary = Grey242
)

private val LightColorPalette = lightColors(
    primary = Blue499,
    primaryVariant = Blue499,
    secondary = Grey242,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@androidx.compose.Composable
val Colors.cardBackground: Color
    get() = if (isLight) Color(0xFFFBFBFB) else Color(0xFF424141)

@androidx.compose.Composable
val Colors.warningBackground: Color
    get() = if (isLight) Color(0xFFC4562e) else Color(0xFFA54c2c)


@androidx.compose.Composable
val Colors.warningFont: Color
    get() = if (isLight) Color.Black else Color.White

@Composable
fun CallBlockTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}