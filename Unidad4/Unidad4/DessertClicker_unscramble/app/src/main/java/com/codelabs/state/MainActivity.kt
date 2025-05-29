/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codelabs.state

import android.os.Bundle                           // Importa la clase Bundle para manejar datos de estado de la actividad
import androidx.activity.ComponentActivity        // Importa ComponentActivity, clase base para actividades con Jetpack Compose
import androidx.activity.compose.setContent       // Importa setContent para definir el contenido Compose de la actividad
import androidx.compose.foundation.layout.fillMaxSize  // Importa modificador para que un elemento ocupe todo el tamaño disponible
import androidx.compose.material3.MaterialTheme    // Importa MaterialTheme para temas y colores en Compose (Material 3)
import androidx.compose.material3.Surface          // Importa Surface, contenedor visual con propiedades de fondo y elevación
import androidx.compose.ui.Modifier                 // Importa Modifier, para modificar el comportamiento o apariencia de composables
import com.codelabs.state.ui.theme.BasicStateCodelabTheme  // Importa el tema personalizado definido en el proyecto

// Define la actividad principal que hereda de ComponentActivity
class MainActivity : ComponentActivity() {

    // Función llamada cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  // Llama al método onCreate del padre para inicializar la actividad

        // Define el contenido visual de la actividad usando Jetpack Compose
        setContent {
            // Aplica el tema personalizado a todo el contenido Compose
            BasicStateCodelabTheme {

                // Surface es un contenedor visual que usa el color de fondo del tema
                Surface(
                    modifier = Modifier.fillMaxSize(),  // Hace que la Surface ocupe todo el espacio disponible
                    color = MaterialTheme.colorScheme.background  // Usa el color de fondo definido en el tema
                ) {
                    WellnessScreen()  // Composable que muestra la pantalla principal de la app
                }
            }
        }
    }
}

