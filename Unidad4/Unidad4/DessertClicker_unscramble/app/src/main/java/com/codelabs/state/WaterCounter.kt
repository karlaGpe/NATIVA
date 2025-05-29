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
import androidx.compose.foundation.layout.Column       // Importa Column para organizar elementos en columna vertical
import androidx.compose.foundation.layout.padding      // Importa padding para agregar espacio interno a un elemento
import androidx.compose.material3.Button               // Importa Button para crear botones Material3
import androidx.compose.material3.Text                 // Importa Text para mostrar texto en la UI
import androidx.compose.runtime.Composable             // Importa Composable para definir funciones composables de UI
import androidx.compose.runtime.getValue               // Importa getValue para delegados de estado (delegación by)
import androidx.compose.runtime.mutableStateOf         // Importa mutableStateOf para definir estados observables
import androidx.compose.runtime.saveable.rememberSaveable  // Importa rememberSaveable para guardar estado que persiste tras cambios de configuración
import androidx.compose.runtime.setValue               // Importa setValue para delegados de estado (delegación by)
import androidx.compose.ui.Modifier                    // Importa Modifier para modificar composables (estilos, layout, etc.)
import androidx.compose.ui.unit.dp                      // Importa dp para definir dimensiones en densidad independiente de píxeles

// Función composable que maneja su propio estado (contador)
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    // Variable de estado 'count' que recuerda su valor y se guarda tras rotación o recreación de actividad
    var count by rememberSaveable { mutableStateOf(0) }

    // Llama a StatelessCounter, pasando el estado actual y la función para incrementar el contador
    StatelessCounter(
        count = count,                    // Valor actual del contador
        onIncrement = { count++ },        // Lambda que incrementa el contador cuando se llama
        modifier = modifier               // Modifier que puede venir de afuera para modificar el layout
    )
}

// Función composable sin estado que recibe datos y eventos desde fuera
@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    // Organiza los elementos en columna y aplica padding de 16 dp
    Column(modifier = modifier.padding(16.dp)) {

        // Muestra el texto sólo si count es mayor que 0
        if (count > 0) {
            Text("You've had $count glasses.")  // Texto que muestra la cantidad actual
        }

        // Botón para incrementar el contador
        Button(
            onClick = onIncrement,          // Acción que se ejecuta al pulsar el botón
            enabled = count < 10,           // Botón habilitado sólo si count es menor que 10
            modifier = Modifier.padding(top = 8.dp)  // Padding arriba para separar del texto
        ) {
            Text("Add one")                 // Texto del botón
        }
    }
}
