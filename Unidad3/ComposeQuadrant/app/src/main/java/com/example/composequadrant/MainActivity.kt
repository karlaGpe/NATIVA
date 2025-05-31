package com.example.composequadrant
// Importa la clase Bundle, necesaria para el ciclo de vida de actividades
import android.os.Bundle

// Importa la clase base para actividades que usan Jetpack Compose
import androidx.activity.ComponentActivity

// Permite establecer el contenido de la actividad con composables
import androidx.activity.compose.setContent

// Importa funciones y clases para diseño como fondo (background), espaciado (padding, fill, etc.)
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

// Importa los elementos de Material Design
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text

// Importa anotación para composables
import androidx.compose.runtime.Composable

// Permite alinear elementos dentro de los layouts
import androidx.compose.ui.Alignment

// Permite modificar composables (relleno, tamaño, etc.)
import androidx.compose.ui.Modifier

// Permite usar colores (como Color.Green, Color.Yellow, etc.)
import androidx.compose.ui.graphics.Color

// Permite aplicar grosor a la fuente de texto (bold, etc.)
import androidx.compose.ui.text.font.FontWeight

// Permite alinear el texto (centrado, justificado, etc.)
import androidx.compose.ui.text.style.TextAlign

// Permite ver vistas previas en Android Studio
import androidx.compose.ui.tooling.preview.Preview

// Permite definir unidades de medida (dp)
import androidx.compose.ui.unit.dp

// Importa el tema personalizado de la app
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

// Clase principal de la aplicación que hereda de ComponentActivity
class MainActivity : ComponentActivity() {

    // Método que se ejecuta cuando la actividad es creada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Se establece el contenido visual de la actividad usando Jetpack Compose
        setContent {
            // Se aplica el tema personalizado
            ComposeQuadrantTheme {
                // Se crea una superficie usando el color de fondo del tema
                Surface(
                    modifier = Modifier.fillMaxSize(), // Ocupa toda la pantalla
                    color = MaterialTheme.colors.background // Color de fondo definido por el tema
                ) {
                    // Llama al composable principal que dibuja la cuadrícula
                    Quadrant()
                }
            }
        }
    }
}

// Composable que organiza los cuatro cuadrantes
@Composable
fun Quadrant() {
    // Columna que contiene dos filas
    Column(
        modifier = Modifier.fillMaxSize() // Ocupa todo el alto disponible
    ) {
        // Primera fila: contiene 2 cuadrantes de colores verde y amarillo
        QuadrantRow(
            listOf(Color.Green, Color.Yellow), // Lista de colores para las dos columnas
            listOf(
                listOf("Text composable", "Displays text and follows Material Design guidelines."), // Título y descripción
                listOf("Image composable", "Creates a composable that lays out and draws a given Painter class object.") // Título y descripción
            ),
            modifier = Modifier.weight(1f) // Distribuye el espacio vertical uniformemente
        )

        // Segunda fila: contiene 2 cuadrantes de colores cyan y gris claro
        QuadrantRow(
            listOf(Color.Cyan, Color.LightGray),
            listOf(
                listOf("Row composable", "A layout composable that places its children in a horizontal sequence."), // Título y descripción
                listOf("Column composable", "A layout composable that places its children in a vertical sequence.") // Título y descripción
            ),
            modifier = Modifier.weight(1f) // Distribuye el espacio vertical uniformemente
        )
    }
}

// Composable que representa una fila con dos columnas de contenido
@Composable
fun QuadrantRow(
    rowColors: List<Color>, // Lista de 2 colores, uno por columna
    rowTexts: List<List<String>>, // Lista de 2 listas de strings (título y descripción por columna)
    modifier: Modifier = Modifier
) {
    // Fila horizontal que ocupa todo el ancho y alto disponible dentro del peso recibido
    Row(
        modifier = modifier.fillMaxSize()
    ) {
        // Primer cuadrante (columna izquierda)
        ComposeCardColumn(rowColors[0], rowTexts[0], Modifier.weight(1f))

        // Segundo cuadrante (columna derecha)
        ComposeCardColumn(rowColors[1], rowTexts[1], Modifier.weight(1f))
    }
}

// Composable que representa una columna con color de fondo, título y descripción
@Composable
fun ComposeCardColumn(
    color: Color, // Color de fondo del cuadrante
    textList: List<String>, // Lista de 2 elementos: título y descripción
    modifier: Modifier = Modifier
) {
    // Columna vertical que organiza el contenido centrado
    Column(
        modifier = modifier
            .fillMaxSize() // Ocupa todo el espacio disponible
            .background(color = color) // Color de fondo del cuadrante
            .padding(16.dp), // Espaciado interior
        verticalArrangement = Arrangement.Center, // Centra el contenido verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centra el contenido horizontalmente
    ) {
        // Texto con estilo de título en negrita
        Text(
            text = textList[0], // Primer string: título
            fontWeight = FontWeight.Bold, // Texto en negrita
            modifier = Modifier.padding(bottom = 16.dp) // Espacio inferior
        )

        // Texto con estilo normal y alineado justificado
        Text(
            text = textList[1], // Segundo string: descripción
            textAlign = TextAlign.Justify // Justifica el texto
        )
    }
}

// Composable de vista previa que muestra el diseño en Android Studio
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    // Aplica el tema personalizado
    ComposeQuadrantTheme {
        // Llama al composable principal
        Quadrant()
    }
}
