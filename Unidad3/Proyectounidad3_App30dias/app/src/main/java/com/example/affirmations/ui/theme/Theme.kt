
package com.example.affirmations.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Define esquema de colores para tema oscuro con colores personalizados
private val DarkColorScheme = darkColorScheme(
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    background = md_theme_dark_background
)

// Define esquema de colores para tema claro con colores personalizados
private val LightColorScheme = lightColorScheme(
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    background = md_theme_light_background
)

// Composable que aplica el tema a la UI
@Composable
fun AffirmationsTheme(
    // Detecta si el sistema está en modo oscuro por defecto
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Permite usar colores dinámicos en Android 12+ (desactivado aquí)
    dynamicColor: Boolean = false,
    // Contenido UI al que se le aplicará el tema
    content: @Composable () -> Unit
) {
    // Selecciona esquema de color: dinámico si está habilitado y es Android 12+, si no según tema oscuro/claro
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    // Obtiene la vista actual
    val view = LocalView.current
    // Si no está en modo edición (preview), actualiza color y apariencia de barra de estado
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Cambia color de barra de estado al color de fondo del esquema
            window.statusBarColor = colorScheme.background.toArgb()
            // Ajusta color de iconos en barra de estado según tema (claro u oscuro)
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    // Aplica el esquema de colores y contenido dentro del MaterialTheme
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
