/*
 * Copyright 2022 Google LLC
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

package com.example.reply.ui
// Importa la clase base para ViewModels de Android
import androidx.lifecycle.ViewModel

// Importa el scope para lanzar corrutinas dentro de un ViewModel
import androidx.lifecycle.viewModelScope

// Importa el modelo de datos Email
import com.example.reply.data.Email

// Importa interfaces y clases concretas del repositorio de correos
import com.example.reply.data.EmailsRepository
import com.example.reply.data.EmailsRepositoryImpl

// Importa clases de flujo (Flow) para manejar estados reactivos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch

// Importa funciones para trabajar con corrutinas
import kotlinx.coroutines.launch

// --------------------- VIEWMODEL PRINCIPAL ---------------------

// ViewModel que contiene y gestiona el estado de la pantalla principal
class ReplyHomeViewModel(
    private val emailsRepository: EmailsRepository = EmailsRepositoryImpl() // Inyección del repositorio
): ViewModel() {

    // Estado interno mutable que guarda el estado de la UI
    private val _uiState = MutableStateFlow(ReplyHomeUIState(loading = true))

    // Exposición del estado como solo lectura hacia la UI (público)
    val uiState: StateFlow<ReplyHomeUIState> = _uiState

    // Se ejecuta al instanciar el ViewModel
    init {
        observeEmails() // Inicia la observación de correos
    }

    // Observa los correos emitidos por el repositorio
    private fun observeEmails() {
        viewModelScope.launch {
            // Obtiene un flujo de correos desde el repositorio
            emailsRepository.getAllEmails()
                // Si hay error, actualiza el estado con el mensaje de error
                .catch { ex ->
                    _uiState.value = ReplyHomeUIState(error = ex.message)
                }
                // Cuando se reciben correos exitosamente, actualiza el estado con la lista
                .collect { emails ->
                    _uiState.value = ReplyHomeUIState(emails = emails)
                }
        }
    }

    // Función para seleccionar un correo, a implementar
    fun setSelectedEmail(email: Email) {
        // You will implement email selection here.
        // Aquí podrías actualizar el estado con el correo seleccionado, por ejemplo.
    }
}

// --------------------- ESTADO DE LA UI ---------------------

// Data class que representa el estado completo de la pantalla
data class ReplyHomeUIState(
    val emails : List<Email> = emptyList(),   // Lista de correos
    val loading: Boolean = false,             // Indicador de carga
    val error: String? = null                 // Mensaje de error, si lo hay
)
