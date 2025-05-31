package com.example.happybirthday

// Importaciones necesarias para una app Compose en Android
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.happybirthday.ui.theme.HappyBirthdayTheme // Tema personalizado

// Actividad principal de la app
class MainActivity : ComponentActivity() {
    // Función que se ejecuta al crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el contenido de la actividad usando Compose
        setContent {
            HappyBirthdayTheme { // Aplica el tema personalizado
                Surface(
                    modifier = Modifier.fillMaxSize(), // Ocupa todo el espacio disponible
                    color = MaterialTheme.colorScheme.background // Fondo del tema
                ) {
                    BusinessCard() // Llama al componente que muestra la tarjeta
                }
            }
        }
    }
}

// Composable que representa la tarjeta de presentación
@Composable
fun BusinessCard() {
    // Layout en columna principal que divide la tarjeta en dos partes
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa toda la pantalla
            .padding(16.dp), // Márgenes alrededor
        verticalArrangement = Arrangement.SpaceBetween, // Distribuye espacio entre los elementos
        horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
    ) {
        // Columna interna para la parte superior (foto, nombre, título)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(248.dp)) // Espacio superior para bajar el contenido

            // Imagen del logo
            Image(
                painter = painterResource(R.drawable.logo), // Imagen desde recursos
                contentDescription = null, // No se necesita descripción para accesibilidad aquí
                modifier = Modifier.size(120.dp) // Tamaño de la imagen
            )

            // Nombre de la persona
            Text(
                text = "Sergio Barcenaz",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            // Título profesional
            Text(
                text = "Desarrollador Android",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.primary // Usa el color primario del tema
            )
        }

        // Sección de información de contacto
        ContactInfo(
            phone = "+52 123 456 7890", // Teléfono ficticio
            email = "salma@example.com" // Correo ficticio
        )
    }
}

// Composable para mostrar la sección de contacto (teléfono y correo)
@Composable
fun ContactInfo(phone: String, email: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 24.dp) // Espacio inferior
    ) {
        ContactRow(icon = Icons.Default.Phone, info = phone) // Fila de teléfono
        Spacer(modifier = Modifier.height(8.dp)) // Espacio entre filas
        ContactRow(icon = Icons.Default.Email, info = email) // Fila de correo
    }
}

// Composable reutilizable para mostrar un icono con texto al lado (fila)
@Composable
fun ContactRow(icon: ImageVector, info: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically // Alinea los elementos en el centro vertical
    ) {
        Icon(
            imageVector = icon, // Icono (teléfono o correo)
            contentDescription = null, // Sin descripción accesible
            modifier = Modifier.padding(end = 8.dp) // Espacio entre el icono y el texto
        )
        Text(text = info) // Información (número o email)
    }
}

// Función de vista previa para mostrar cómo se ve la tarjeta en el editor de Android Studio
@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    HappyBirthdayTheme {
        BusinessCard() // Muestra la tarjeta dentro del tema
    }
}

