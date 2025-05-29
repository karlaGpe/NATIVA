

package com.example.reply.ui

// Importa funciones y componentes para el diseño (layout) y fondos (background)
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

// Importa componentes de Material 3
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text

// Importa herramientas de Compose para manejar estados y funciones composables
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// Importa modificadores de UI
import androidx.compose.ui.Modifier

// Permite obtener textos desde archivos de recursos (strings.xml)
import androidx.compose.ui.res.stringResource

// Importa clase Email usada como modelo de datos
import com.example.reply.data.Email

// ------------------- FUNCIÓN PRINCIPAL DE LA UI -------------------

@Composable
fun ReplyApp(
    replyHomeUIState: ReplyHomeUIState, // Estado de la UI que contiene la lista de correos, etc.
    onEmailClick: (Email) -> Unit,      // Callback que se dispara al hacer clic en un correo
) {
    // Envolvemos el contenido dentro de un contenedor de navegación adaptable
    ReplyNavigationWrapperUI {
        // Llama al contenido principal de la app, pasándole el estado y callback
        ReplyAppContent(
            replyHomeUIState = replyHomeUIState,
            onEmailClick = onEmailClick
        )
    }
}

// ------------------- ENVOLTORIO CON NAVEGACIÓN -------------------

@Composable
private fun ReplyNavigationWrapperUI(
    content: @Composable () -> Unit = {} // Slot composable para mostrar contenido dentro
) {
    // Estado que guarda la pantalla seleccionada actualmente (inicialmente es "Inbox")
    var selectedDestination: ReplyDestination by remember {
        mutableStateOf(ReplyDestination.Inbox)
    }

    // Aquí se implementará la navegación adaptable (por ejemplo, para tablets o escritorio)
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el tamaño disponible de la pantalla
            .background(MaterialTheme.colorScheme.inverseOnSurface) // Aplica un color de fondo del tema
    ) {
        // Contenedor para el contenido principal de la pantalla, que ocupa el peso restante
        Box(modifier = Modifier.weight(1f)) {
            content() // Inserta el contenido recibido como parámetro
        }

        // Barra de navegación inferior (como en muchas apps móviles)
        NavigationBar(modifier = Modifier.fillMaxWidth()) {
            // Recorre cada destino (Inbox, Sent, etc.) definido en ReplyDestination
            ReplyDestination.entries.forEach {
                // Crea un ítem de navegación por cada destino
                NavigationBarItem(
                    selected = it == selectedDestination, // Marca como seleccionado si coincide
                    onClick = { /*TODO update selection*/ }, // Aquí se actualizará la selección (pendiente)
                    icon = {
                        Icon(
                            imageVector = it.icon, // Muestra el ícono del destino
                            contentDescription = stringResource(it.labelRes) // Descripción para accesibilidad
                        )
                    },
                    label = {
                        Text(text = stringResource(it.labelRes)) // Muestra el texto del destino
                    },
                )
            }
        }
    }
}

// ------------------- CONTENIDO PRINCIPAL DE LA APP -------------------

@Composable
fun ReplyAppContent(
    replyHomeUIState: ReplyHomeUIState, // Estado actual de la interfaz de usuario
    onEmailClick: (Email) -> Unit,      // Acción a ejecutar al hacer clic en un correo
) {
    // Aquí se implementará un diseño adaptativo con dos paneles (ej. lista y detalle)

    // Por ahora solo se muestra el panel de lista de correos
    ReplyListPane(
        replyHomeUIState = replyHomeUIState,
        onEmailClick = onEmailClick,
    )
}
