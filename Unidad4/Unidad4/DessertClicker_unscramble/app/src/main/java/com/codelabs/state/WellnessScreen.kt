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

import androidx.compose.foundation.layout.Column       // Importa Column para organizar elementos en una columna vertical
import androidx.compose.runtime.Composable             // Importa Composable para crear funciones que definen UI en Compose
import androidx.compose.ui.Modifier                    // Importa Modifier para modificar la apariencia o comportamiento de composables
import androidx.lifecycle.viewmodel.compose.viewModel  // Importa viewModel para obtener una instancia de ViewModel en Compose

// Función composable que representa la pantalla principal de la app Wellness
@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,                     // Parámetro opcional para modificar el layout desde fuera
    wellnessViewModel: WellnessViewModel = viewModel()  // Obtiene automáticamente el ViewModel asociado a esta UI
) {
    // Organiza los elementos en una columna usando el modifier recibido
    Column(modifier = modifier) {
        StatefulCounter()   // Llama al composable StatefulCounter que muestra el contador con estado interno

        // Composable que muestra la lista de tareas de bienestar
        WellnessTasksList(
            list = wellnessViewModel.tasks,              // Pasa la lista de tareas desde el ViewModel
            onCheckedTask = { task, checked ->           // Callback que se ejecuta cuando cambia el estado "checked" de una tarea
                wellnessViewModel.changeTaskChecked(task, checked)  // Llama al ViewModel para actualizar el estado de la tarea
            },
            onCloseTask = { task ->                        // Callback que se ejecuta para eliminar una tarea
                wellnessViewModel.remove(task)             // Llama al ViewModel para eliminar la tarea de la lista
            }
        )
    }
}

