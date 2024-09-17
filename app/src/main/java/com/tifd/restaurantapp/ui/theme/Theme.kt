package com.tifd.restaurantapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color

// Palet warna untuk Dark Mode
private val DarkColorPalette = darkColorScheme(
    primary = Color(0xFFBB86FC), // Purple200
    secondary = Color(0xFF03DAC5), // Teal200
    tertiary = Color(0xFF3700B3) // Purple700
)

// Palet warna untuk Light Mode
private val LightColorPalette = lightColorScheme(
    primary = Color(0xFF6200EE), // Purple500
    secondary = Color(0xFF03DAC5), // Teal200
    tertiary = Color(0xFF3700B3) // Purple700
)

@Composable
fun RestaurantsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors, // Ganti 'colors' menjadi 'colorScheme'
        typography = Typography,
        content = content
    )
}