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
import androidx.compose.foundation.layout.Row            // Importa Row para organizar elementos en una fila horizontal
import androidx.compose.foundation.layout.padding        // Importa padding para agregar espacio interno
import androidx.compose.material.icons.Icons             // Importa Icons para usar iconos predefinidos
import androidx.compose.material.icons.filled.Close      // Importa el icono "Close" (cerrar) rellenado
import androidx.compose.material3.Checkbox               // Importa Checkbox para mostrar casilla de verificación Material3
import androidx.compose.material3.Icon                   // Importa Icon para mostrar iconos en la UI
import androidx.compose.material3.IconButton             // Importa IconButton para botones con iconos
import androidx.compose.material3.Text                   // Importa Text para mostrar texto
import androidx.compose.runtime.Composable               // Importa Composable para crear funciones de UI en Compose
import androidx.compose.ui.Alignment                      // Importa Alignment para alinear elementos en layout
import androidx.compose.ui.Modifier                       // Importa Modifier para modificar apariencia y comportamiento de elementos
import androidx.compose.ui.unit.dp                         // Importa dp para definir medidas independientes de densidad

// Función composable que muestra un ítem individual de tarea en la lista de bienestar
@Composable
fun WellnessTaskItem(
    taskName: String,                      // Nombre o descripción de la tarea
    checked: Boolean,                     // Estado actual de la casilla (marcada o no)
    onCheckedChange: (Boolean) -> Unit,  // Callback para manejar cambios en la casilla de verificación
    onClose: () -> Unit,                  // Callback para manejar la acción de cerrar (eliminar) la tarea
    modifier: Modifier = Modifier         // Modifier opcional para personalizar el layout desde fuera
) {
    // Organiza los elementos en una fila horizontal con alineación vertical centrada
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Muestra el texto con el nombre de la tarea
        Text(
            modifier = Modifier
                .weight(1f)                // Ocupa todo el espacio horizontal disponible para el texto
                .padding(start = 16.dp),   // Padding a la izquierda para separación visual
            text = taskName                // Texto que muestra el nombre de la tarea
        )

        // Casilla de verificación que indica si la tarea está completada o no
        Checkbox(
            checked = checked,            // Estado actual de la casilla
            onCheckedChange = onCheckedChange  // Acción a ejecutar cuando cambia el estado
        )

        // Botón con ícono para cerrar o eliminar la tarea
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")  // Ícono "Close" con descripción para accesibilidad
        }
    }
}
