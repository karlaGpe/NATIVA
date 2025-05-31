package com.example.artspace
// Importaciones necesarias para Android y Jetpack Compose
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.R
import com.example.artspace.ui.theme.ArtSpaceTheme

// Clase principal que representa la actividad principal de la app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Define el contenido visual usando Jetpack Compose
        setContent {
            // Aplica el tema de la app
            ArtSpaceTheme {
                // Llama a la función composable que crea la UI principal
                ArtSpaceApp()
            }
        }
    }
}

// Función composable que contiene toda la interfaz principal
@Composable
fun ArtSpaceApp() {
    // Estado que controla qué obra se está mostrando (índice)
    var index by remember { mutableStateOf(0) }

    // Lista de datos de obras de arte: imagen, título, artista y año
    val artworks = listOf(
        ArtData(R.drawable.art1, "La noche estrellada", "Vincent van Gogh", "1889"),
        ArtData(R.drawable.art2, "La joven de la perla", "Johannes Vermeer", "1665"),
        ArtData(R.drawable.art3, "El grito", "Edvard Munch", "1893")
    )

    // Obra de arte actual según el índice
    val current = artworks[index]

    // Columna que contiene todos los elementos de la pantalla
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa toda la pantalla
            .padding(16.dp), // Agrega padding alrededor
        verticalArrangement = Arrangement.Center, // Centra verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente
    ) {
        // Tarjeta que muestra la imagen de la obra con bordes redondeados y sombra
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            // Imagen de la obra actual
            Image(
                painter = painterResource(id = current.image), // Carga la imagen desde recursos
                contentDescription = null, // No hay descripción para accesibilidad
                modifier = Modifier
                    .height(300.dp) // Altura fija para la imagen
                    .fillMaxWidth() // Ancho máximo disponible
            )
        }

        // Espacio vertical entre la imagen y el texto
        Spacer(modifier = Modifier.height(16.dp))

        // Título de la obra de arte
        Text(text = current.title, fontSize = 24.sp)

        // Texto que muestra el artista y el año, centrado
        Text(
            text = "${current.artist} (${current.year})",
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        // Espacio entre el texto y los botones
        Spacer(modifier = Modifier.height(16.dp))

        // Fila que contiene los botones para navegar entre obras
        Row {
            // Botón "Anterior": disminuye índice o vuelve al último si está en el primero
            Button(onClick = { index = if (index == 0) artworks.lastIndex else index - 1 }) {
                Text("Anterior")
            }

            // Espacio horizontal entre botones
            Spacer(modifier = Modifier.width(16.dp))

            // Botón "Siguiente": aumenta índice y vuelve a 0 al llegar al final
            Button(onClick = { index = (index + 1) % artworks.size }) {
                Text("Siguiente")
            }
        }
    }
}

// Data class que representa cada obra de arte con sus propiedades
data class ArtData(val image: Int, val title: String, val artist: String, val year: String)
