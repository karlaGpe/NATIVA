package com.example.taskmanager
// Importa la clase Bundle, usada para pasar datos entre componentes de Android
import android.os.Bundle

// Importa ComponentActivity, que es una actividad base para usar Jetpack Compose
import androidx.activity.ComponentActivity

// Importa la función setContent para establecer la UI con Composables
import androidx.activity.compose.setContent

// Importa el composable Image para mostrar imágenes
import androidx.compose.foundation.Image

// Importa Arrangement para definir cómo se distribuyen los elementos en Column o Row
import androidx.compose.foundation.layout.Arrangement

// Importa Column, un contenedor que organiza elementos en una columna vertical
import androidx.compose.foundation.layout.Column

// Importa fillMaxSize, que hace que un elemento ocupe todo el espacio disponible
import androidx.compose.foundation.layout.fillMaxSize

// Importa padding para añadir espacio alrededor de los elementos
import androidx.compose.foundation.layout.padding

// Importa MaterialTheme para acceder a los colores y estilos del tema Material
import androidx.compose.material.MaterialTheme

// Importa Surface, un contenedor con fondo que puede aplicar color y elevación
import androidx.compose.material.Surface

// Importa Text, composable que permite mostrar texto
import androidx.compose.material.Text

// Importa Composable, una anotación para funciones que definen la interfaz en Compose
import androidx.compose.runtime.Composable

// Importa Alignment para alinear contenido en Column o Row
import androidx.compose.ui.Alignment

// Importa ContentScale para definir cómo escalar y ajustar imágenes
import androidx.compose.ui.layout.ContentScale

// Importa painterResource para cargar imágenes desde recursos (res/drawable)
import androidx.compose.ui.res.painterResource

// Importa FontWeight para aplicar negrita u otros pesos de fuente al texto
import androidx.compose.ui.text.font.FontWeight

// Importa Preview para generar una vista previa del composable en Android Studio
import androidx.compose.ui.tooling.preview.Preview

// Importa dp (density-independent pixels) para definir tamaños de padding, márgenes, etc.
import androidx.compose.ui.unit.dp

// Importa sp (scale-independent pixels) para definir tamaños de fuente
import androidx.compose.ui.unit.sp

// Importa el tema personalizado definido en el módulo de UI
import com.example.taskmanager.ui.theme.TaskManagerTheme

// Define la clase principal MainActivity que hereda de ComponentActivity
class MainActivity : ComponentActivity() {

    // Método que se llama al crear la actividad (equivalente a "onCreate" tradicional)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establece la UI utilizando Jetpack Compose
        setContent {

            // Aplica el tema personalizado de la app
            TaskManagerTheme {

                // Surface es un contenedor de fondo que usa el color de fondo del tema
                Surface(
                    modifier = Modifier.fillMaxSize(), // Ocupa toda la pantalla
                    color = MaterialTheme.colors.background // Usa el color de fondo del tema
                ) {
                    // Llama a la función composable que define el contenido principal
                    TaskComplete()
                }
            }
        }
    }
}

// Función composable que define la interfaz principal cuando todas las tareas están completas
@Composable
fun TaskComplete() {
    // Column organiza los elementos verticalmente
    Column(
        modifier = Modifier.fillMaxSize(), // Ocupa toda la pantalla
        verticalArrangement = Arrangement.Center, // Centra los elementos verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
    ) {
        // Carga una imagen desde los recursos (R.drawable.ic_task_completed)
        val image = painterResource(id = R.drawable.ic_task_completed)

        // Muestra la imagen en pantalla
        Image(
            painter = image, // Imagen cargada
            contentDescription = "checkmark image", // Descripción para accesibilidad
            contentScale = ContentScale.Inside // Ajusta la imagen dentro del contenedor sin recortarla
        )

        // Primer texto con mensaje principal
        Text(
            text = "All tasks completed", // Texto que se muestra
            fontWeight = FontWeight.Bold, // Texto en negrita
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp) // Espaciado arriba y abajo
        )

        // Segundo texto con mensaje adicional
        Text(
            text = "Nice work!", // Texto que se muestra
            fontSize = 16.sp // Tamaño del texto en puntos escalables
        )
    }
}

// Vista previa del diseño en Android Studio
@Preview(showBackground = true) // Muestra un fondo blanco en la vista previa
@Composable
fun DefaultPreview() {
    // Aplica el tema para que la vista previa coincida con la app real
    TaskManagerTheme {
        // Muestra el composable principal en la vista previa
        TaskComplete()
    }
}
