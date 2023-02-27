package com.example.trees.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = LightGreen,
    primaryVariant = Corail,
    background = TreeBackground,
    surface = LightGreen2
)

private val LightColorPalette = lightColors(
    primary = LightGreen,
    primaryVariant = Corail,
    background = TreeBackground,
    surface = LightGreen2
)

@Composable
fun TreeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
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