

package com.example.reply.ui
// Importa clases necesarias del sistema operativo Android y Jetpack Compose
import android.os.Build // Proporciona información sobre la versión del sistema operativo
import android.os.Bundle // Contenedor para pasar datos entre componentes de Android

// Importa clases para actividades con Jetpack Compose
import androidx.activity.ComponentActivity // Actividad base para Compose
import androidx.activity.compose.setContent // Permite establecer contenido Compose en una actividad
import androidx.activity.enableEdgeToEdge // Habilita el diseño de borde a borde (sin barras visibles)
import androidx.activity.viewModels // Permite obtener ViewModels vinculados al ciclo de vida

// Importa funciones y anotaciones de Compose
import androidx.compose.runtime.Composable // Marca funciones que generan UI con Compose
import androidx.compose.runtime.getValue // Permite desestructurar valores de estados con 'by'
import androidx.compose.ui.tooling.preview.Preview // Permite crear vistas previas de componentes Compose

// Importa extensiones de Compose para trabajar con LiveData o StateFlow
import androidx.lifecycle.compose.collectAsStateWithLifecycle // Observa flujos con el ciclo de vida de Compose

// Importa datos simulados (falsos) para mostrar correos electrónicos
import com.example.reply.data.local.LocalEmailsDataProvider

// Importa el tema de la aplicación personalizado
import com.example.reply.ui.theme.ReplyTheme

// Define la actividad principal de la aplicación
class MainActivity : ComponentActivity() {

    // Obtiene una instancia del ViewModel de forma automática asociada al ciclo de vida de la actividad
    private val viewModel: ReplyHomeViewModel by viewModels()

    // Método que se ejecuta cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilita que la UI ocupe toda la pantalla, incluyendo detrás de las barras del sistema
        enableEdgeToEdge()

        // Verifica si la versión del sistema es Android 10 (Q) o superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // Desactiva el refuerzo de contraste en la barra de navegación para que no cambie de color automáticamente
            window.isNavigationBarContrastEnforced = false
        }

        // Establece el contenido de la UI utilizando Compose
        setContent {
            // Aplica el tema visual de la app a todos los elementos dentro del bloque
            ReplyTheme {
                // Observa el estado del ViewModel como un State Compose, gestionado por el ciclo de vida
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()

                // Llama a la función composable principal de la aplicación
                ReplyApp(
                    replyHomeUIState = uiState, // Proporciona el estado de la interfaz de usuario
                    onEmailClick = viewModel::setSelectedEmail // Pasa una función de callback para manejar clics en correos
                )
            }
        }
    }
}

// ---------- VISTAS PREVIAS (Previews) ----------

// Vista previa de la aplicación en tamaño de teléfono con fondo visible
@Preview(showBackground = true)
@Composable
fun ReplyAppPreview() {
    // Aplica el tema visual a la vista previa
    ReplyTheme {
        // Llama a la función principal de la app con datos de prueba
        ReplyApp(
            replyHomeUIState = ReplyHomeUIState(
                emails = LocalEmailsDataProvider.allEmails // Usa todos los correos simulados como estado
            ),
            onEmailClick = {} // No se hace nada al hacer clic (para pruebas)
        )
    }
}

// Vista previa para dispositivos tipo tablet (700dp de ancho)
@Preview(showBackground = true, widthDp = 700)
@Composable
fun ReplyAppPreviewTablet() {
    ReplyTheme {
        ReplyApp(
            replyHomeUIState = ReplyHomeUIState(
                emails = LocalEmailsDataProvider.allEmails
            ),
            onEmailClick = {}
        )
    }
}

// Vista previa para escritorio o pantallas grandes (1000dp de ancho)
@Preview(showBackground = true, widthDp = 1000)
@Composable
fun ReplyAppPreviewDesktop() {
    ReplyTheme {
        ReplyApp(
            replyHomeUIState = ReplyHomeUIState(
                emails = LocalEmailsDataProvider.allEmails
            ),
            onEmailClick = {}
        )
    }
}


