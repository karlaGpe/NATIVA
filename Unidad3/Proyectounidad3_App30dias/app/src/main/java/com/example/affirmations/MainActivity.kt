
package com.example.affirmations
// Importa la clase Bundle para manejar datos cuando se crea una Activity
import android.os.Bundle

// Importa ComponentActivity, la base para actividades que usan Jetpack Compose
import androidx.activity.ComponentActivity

// Importa setContent, que define la interfaz de usuario usando funciones Composable
import androidx.activity.compose.setContent

// Importa Image, un Composable para mostrar imágenes
import androidx.compose.foundation.Image

// Importa Column, un layout que coloca elementos de forma vertical
import androidx.compose.foundation.layout.Column

// Hace que un componente llene todo el tamaño disponible (ancho y alto)
import androidx.compose.foundation.layout.fillMaxSize

// Hace que un componente llene todo el ancho disponible
import androidx.compose.foundation.layout.fillMaxWidth

// Define la altura de un componente
import androidx.compose.foundation.layout.height

// Agrega espacio alrededor de un componente
import androidx.compose.foundation.layout.padding

// Importa LazyColumn, un Composable que lista elementos de forma eficiente
import androidx.compose.foundation.lazy.LazyColumn

// items permite iterar sobre una lista dentro de una LazyColumn
import androidx.compose.foundation.lazy.items

// Importa Card de Material3 para crear tarjetas con estilo
import androidx.compose.material3.Card

// Importa MaterialTheme para acceder a los estilos y colores del tema Material 3
import androidx.compose.material3.MaterialTheme

// Surface es un contenedor de fondo que respeta el tema actual
import androidx.compose.material3.Surface

// Composable para mostrar texto en la UI
import androidx.compose.material3.Text

// Anotación para declarar funciones Composable
import androidx.compose.runtime.Composable

// Modificador para aplicar cambios visuales o estructurales a composables
import androidx.compose.ui.Modifier

// Define cómo se ajusta una imagen a su contenedor
import androidx.compose.ui.layout.ContentScale

// Permite acceder al contexto actual (por ejemplo, para obtener strings)
import androidx.compose.ui.platform.LocalContext

// Carga imágenes desde recursos con ID
import androidx.compose.ui.res.painterResource

// Carga cadenas desde recursos con ID
import androidx.compose.ui.res.stringResource

// Habilita la vista previa del Composable en Android Studio
import androidx.compose.ui.tooling.preview.Preview

// Unidad de medida en píxeles independientes de densidad (dp)
import androidx.compose.ui.unit.dp

// Importa la clase Datasource, que carga la lista de afirmaciones
import com.example.affirmations.data.Datasource

// Importa la clase Affirmation, que representa un objeto con texto e imagen
import com.example.affirmations.model.Affirmation

// Importa el tema personalizado para la aplicación
import com.example.affirmations.ui.theme.AffirmationsTheme

// Clase principal de la app que extiende ComponentActivity
class MainActivity : ComponentActivity() {

    // Método que se llama al crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define la interfaz de usuario con Jetpack Compose
        setContent {
            // Aplica el tema definido para la app
            AffirmationsTheme {

                // Contenedor de fondo que respeta el color del tema
                Surface(
                    modifier = Modifier.fillMaxSize(), // Ocupa toda la pantalla
                    color = MaterialTheme.colorScheme.background // Usa el color de fondo del tema actual
                ) {
                    // Llama al Composable principal de la app
                    AffirmationsApp()
                }
            }
        }
    }
}

// Composable principal de la app
@Composable
fun AffirmationsApp() {
    // Llama a AffirmationList y le pasa la lista de afirmaciones cargadas desde Datasource
    AffirmationList(
        affirmationList = Datasource().loadAffirmations(),
    )
}

// Composable que muestra una lista de afirmaciones
@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    // LazyColumn permite mostrar una lista de forma eficiente
    LazyColumn(modifier = modifier) {
        // Itera sobre cada afirmación y crea un componente AffirmationCard
        items(affirmationList) { affirmation ->
            AffirmationCard(
                affirmation = affirmation, // Afirmación individual
                modifier = Modifier.padding(8.dp) // Espaciado alrededor de cada tarjeta
            )
        }
    }
}

// Composable que muestra una afirmación en una tarjeta
@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    // Crea una tarjeta (Card) con el modificador recibido
    Card(modifier = modifier) {
        // Organiza la imagen y el texto en una columna vertical
        Column {
            // Muestra la imagen de la afirmación
            Image(
                painter = painterResource(affirmation.imageResourceId), // Carga la imagen desde recursos
                contentDescription = stringResource(affirmation.stringResourceId), // Descripción para accesibilidad
                modifier = Modifier
                    .fillMaxWidth() // Ocupa todo el ancho
                    .height(194.dp), // Altura fija
                contentScale = ContentScale.Crop // Recorta la imagen para llenar el espacio
            )
            // Muestra el texto de la afirmación
            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId), // Carga el string desde recursos
                modifier = Modifier.padding(16.dp), // Espaciado alrededor del texto
                style = MaterialTheme.typography.headlineSmall // Estilo de texto del tema
            )
        }
    }
}

// Vista previa en Android Studio de una tarjeta de afirmación
@Preview
@Composable
private fun AffirmationCardPreview() {
    // Muestra un ejemplo de AffirmationCard con datos simulados
    AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image1))
}
