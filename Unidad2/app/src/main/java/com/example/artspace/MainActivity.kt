package com.example.artspace

// Importa clases necesarias del SDK de Android y de Jetpack Compose
import android.os.Bundle
import androidx.activity.ComponentActivity                      // Clase base para actividades que usan Compose
import androidx.activity.compose.setContent                   // Permite definir el contenido de la actividad en Compose
import androidx.activity.enableEdgeToEdge                     // Habilita el modo de pantalla completa (sin bordes)
import androidx.compose.foundation.layout.fillMaxSize         // Modificador para que un componente llene toda la pantalla
import androidx.compose.foundation.layout.padding              // Modificador para añadir márgenes internos
import androidx.compose.material3.Scaffold                    // Componente base de layout que estructura UI moderna
import androidx.compose.material3.Text                        // Composable para mostrar texto
import androidx.compose.runtime.Composable                    // Anotación para marcar funciones que construyen UI
import androidx.compose.ui.Modifier                           // Permite modificar propiedades visuales de los composables
import androidx.compose.ui.tooling.preview.Preview            // Permite ver una vista previa en el editor
import com.example.artspace.ui.theme.ArtSpaceTheme           // Tema personalizado definido en el proyecto

// Clase principal de la aplicación (la pantalla principal)
class MainActivity : ComponentActivity() {
    // Método que se llama cuando la actividad se crea
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge() // Habilita el uso completo de la pantalla (pantalla completa sin bordes)

        // Establece el contenido visual de la actividad usando Compose
        setContent {
            ArtSpaceTheme { // Aplica el tema visual personalizado "ArtSpaceTheme"

                // Scaffold es una estructura básica que permite usar barras de navegación, contenido y más
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    // Llama a la función Greeting y aplica un padding interno proporcionado por Scaffold
                    Greeting(
                        name = "Android", // Nombre que se usará en el saludo
                        modifier = Modifier.padding(innerPadding) // Aplica el padding necesario
                    )
                }
            }
        }
    }
}

// Función composable que recibe un nombre y un modificador, y muestra un saludo
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", // Muestra el texto con el nombre interpolado
        modifier = modifier    // Aplica los modificadores pasados (como el padding)
    )
}

// Función de vista previa para ver cómo se ve el composable Greeting en el editor
@Preview(showBackground = true) // Muestra fondo para que se vea mejor en la vista previa
@Composable
fun GreetingPreview() {
    ArtSpaceTheme { // Aplica el tema personalizado para la vista previa
        Greeting("Android") // Llama a Greeting con "Android" como nombre
    }
}
