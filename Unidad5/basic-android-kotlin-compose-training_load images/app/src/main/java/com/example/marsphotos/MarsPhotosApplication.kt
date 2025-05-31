/*
 * Copyright (C) 2023 The Android Open Source Project
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
package com.example.marsphotos
import android.app.Application
import com.example.marsphotos.data.AppContainer
import com.example.marsphotos.data.DefaultAppContainer

// Clase que extiende Application para inicializar la app y sus dependencias globales
class MarsPhotosApplication : Application() {

    /**
     * Instancia de AppContainer que contiene las dependencias compartidas
     * que otras clases de la app pueden usar para obtener datos, repositorios, etc.
     */
    lateinit var container: AppContainer

    // Método llamado cuando la aplicación se crea
    override fun onCreate() {
        super.onCreate()
        // Inicializa el contenedor de dependencias con la implementación por defecto
        container = DefaultAppContainer()
    }
}
