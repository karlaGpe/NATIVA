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

package com.example.compose.rally
import android.os.Bundle                                // Importa Bundle para guardar estado de la actividad
import androidx.activity.ComponentActivity             // Importa ComponentActivity, base para actividades con Compose
import androidx.activity.compose.setContent             // Importa setContent para definir UI con Compose dentro de la actividad
import androidx.compose.foundation.layout.Box            // Importa Box, contenedor para colocar elementos uno encima de otro
import androidx.compose.foundation.layout.padding        // Importa padding para agregar espacio interno
import androidx.compose.material.Scaffold                // Importa Scaffold, estructura básica para layout con topBar, bottomBar, etc.
import androidx.compose.runtime.Composable               // Importa Composable para crear funciones UI en Compose
import androidx.compose.runtime.getValue                 // Importa getValue para delegados de estado (by)
import androidx.compose.runtime.mutableStateOf           // Importa mutableStateOf para declarar estado mutable observable
import androidx.compose.runtime.remember                  // Importa remember para recordar estado a través de recomposiciones
import androidx.compose.runtime.setValue                 // Importa setValue para delegados de estado (by)
import androidx.compose.ui.Modifier                      // Importa Modifier para modificar apariencia o comportamiento de composables
import com.example.compose.rally.ui.components.RallyTabRow   // Importa el componente personalizado RallyTabRow (fila de pestañas)
import com.example.compose.rally.ui.theme.RallyTheme    // Importa tema personalizado RallyTheme

/**
 * Actividad principal que recrea parte del estudio de Material Design Rally
 * Fuente: https://material.io/design/material-studies/rally.html
 */
class RallyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {                   // Define la UI con Compose cuando se crea la actividad
            RallyApp()                 // Llama al composable principal de la app Rally
        }
    }
}

/**
 * Composable principal de la app Rally
 */
@Composable
fun RallyApp() {
    RallyTheme {                     // Aplica el tema Rally personalizado a la UI
        // Estado para controlar la pantalla actual, inicializada en Overview
        var currentScreen: RallyDestination by remember { mutableStateOf(Overview) }

        Scaffold(                   // Scaffold para estructurar la UI con topBar y contenido principal
            topBar = {
                RallyTabRow(         // Barra de pestañas personalizada en la parte superior
                    allScreens = rallyTabRowScreens,   // Lista de pantallas para las pestañas
                    onTabSelected = { screen -> currentScreen = screen },  // Cambia la pantalla actual al seleccionar una pestaña
                    currentScreen = currentScreen       // Indica la pestaña/pantalla seleccionada actualmente
                )
            }
        ) { innerPadding ->           // Contenido principal dentro del Scaffold, recibe padding interno para no solaparse con topBar
            Box(Modifier.padding(innerPadding)) {  // Caja que aplica el padding recibido al contenido
                currentScreen.screen()               // Muestra la UI correspondiente a la pantalla actual seleccionada
            }
        }
    }
}
