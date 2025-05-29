package com.nabilbdev.fes

import android.os.Bundle                                  // Import para Bundle, usado en el ciclo de vida de Android
import androidx.activity.ComponentActivity               // Clase base para actividades que usan Jetpack Compose
import androidx.activity.compose.setContent               // Función para establecer contenido Compose en Activity
import androidx.compose.foundation.layout.fillMaxSize      // Modifier para que un componente llene todo el espacio disponible
import androidx.compose.material3.MaterialTheme.colorScheme  // Para acceder a la paleta de colores del tema material3
import androidx.compose.material3.Surface                   // Componente Surface que representa una superficie UI con fondo y forma
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi  // Anotación para APIs experimentales
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass  // Enum para clases de tamaño de ventana (Compact, Medium, Expanded)
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass  // Función para calcular tamaño de ventana actual
import androidx.compose.runtime.Composable                 // Anotación para funciones composables
import androidx.compose.ui.Modifier                         // Para modificar apariencia o comportamiento de composables
import androidx.compose.ui.tooling.preview.Devices          // Dispositivos predefinidos para preview en Android Studio
import androidx.compose.ui.tooling.preview.Preview          // Anotación para previews de composables en Android Studio
import com.nabilbdev.fes.ui.FesApp                         // Composable principal de la app (definido en otro archivo)
import com.nabilbdev.fes.ui.theme.FesTheme                 // Tema personalizado para la app

// Clase principal Activity que extiende ComponentActivity para Jetpack Compose
class MainActivity : ComponentActivity() {

    // Se indica que se usa una API experimental para WindowSizeClass
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  // Llamada al método onCreate de la superclase

        // setContent reemplaza el setContentView tradicional y define el contenido con Compose
        setContent {
            // Aplicar el tema personalizado FesTheme a todo el contenido
            FesTheme {

                // Surface es una superficie de UI con un fondo que toma todo el espacio disponible
                Surface(
                    modifier = Modifier.fillMaxSize(),     // Ocupa toda la pantalla
                    color = colorScheme.background         // Fondo según color de tema (background)
                ) {
                    // Calcula el tamaño actual de la ventana para hacer UI responsiva
                    val windowSize = calculateWindowSizeClass(activity = this)

                    // Llama al composable principal FesApp, pasando el tamaño de ventana calculado
                    FesApp(
                        windowSize = windowSize.widthSizeClass
                    )
                }
            }
        }
    }
}

// Previews para facilitar el diseño y pruebas desde Android Studio sin emular dispositivo real

// Preview para tamaño Compact (teléfonos pequeños)
@Preview(showBackground = true)
@Composable
fun FesAppCompactPreview() {
    FesTheme {
        FesApp(
            windowSize = WindowWidthSizeClass.Compact
        )
    }
}

// Preview para tamaño Medium (tablets o plegables)
@Preview(device = Devices.FOLDABLE, showSystemUi = true)
@Composable
fun FesAppMediumPreview() {
    FesTheme {
        FesApp(
            windowSize = WindowWidthSizeClass.Medium
        )
    }
}

// Preview para tamaño Expanded (pantallas grandes, escritorio)
@Preview(device = Devices.DESKTOP, showSystemUi = true)
@Composable
fun FesAppExpandedPreview() {
    FesTheme {
        FesApp(
            windowSize = WindowWidthSizeClass.Expanded
        )
    }
}
