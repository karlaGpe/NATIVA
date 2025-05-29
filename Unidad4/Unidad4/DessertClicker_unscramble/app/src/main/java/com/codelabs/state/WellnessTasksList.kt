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
import androidx.compose.foundation.lazy.LazyColumn       // Importa LazyColumn para listas verticales perezosas (solo renderiza lo visible)
import androidx.compose.foundation.lazy.items            // Importa función para generar ítems en LazyColumn fácilmente
import androidx.compose.runtime.Composable               // Importa Composable para definir funciones de UI en Compose
import androidx.compose.ui.Modifier                      // Importa Modifier para modificar apariencia o comportamiento

// Composable que muestra una lista de tareas Wellness usando LazyColumn
@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,                          // Lista de tareas que se mostrarán
    onCheckedTask: (WellnessTask, Boolean) -> Unit,   // Callback cuando cambia el estado "checked" de una tarea
    onCloseTask: (WellnessTask) -> Unit,               // Callback para eliminar una tarea
    modifier: Modifier = Modifier                       // Modifier opcional para personalización externa
) {
    // LazyColumn para mostrar una lista vertical que renderiza solo los elementos visibles
    LazyColumn(
        modifier = modifier
    ) {
        // Genera ítems en la LazyColumn a partir de la lista de tareas
        items(
            items = list,
            /**
             * Usar parámetro key para asignar una clave única a cada ítem (por ejemplo, su id),
             * en lugar de usar la posición por defecto en la lista.
             * Esto ayuda a evitar recomposiciones innecesarias cuando la lista cambia.
             */
            key = { task -> task.id }
        ) { task ->
            // Para cada tarea, muestra un WellnessTaskItem con sus propiedades y callbacks
            WellnessTaskItem(
                taskName = task.label,                            // Nombre de la tarea
                checked = task.checked,                           // Estado de la casilla
                onCheckedChange = { checked -> onCheckedTask(task, checked) },  // Maneja cambio del estado de la tarea
                onClose = { onCloseTask(task) }                   // Maneja cierre/eliminación de la tarea
            )
        }
    }
}
