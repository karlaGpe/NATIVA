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
// Importa la anotación @StringRes para indicar que un parámetro representa un recurso de tipo string (R.string.*)
import androidx.annotation.StringRes

// Importa el conjunto de íconos por defecto de Material (Material Icons)
import androidx.compose.material.icons.Icons

// Importa el ícono "Article" en su versión rellena (filled)
import androidx.compose.material.icons.filled.Article

// Importa el ícono "Inbox" en su versión rellena (filled)
import androidx.compose.material.icons.filled.Inbox

// Importa el ícono "Chat" en su versión contorneada (outlined)
import androidx.compose.material.icons.outlined.Chat

// Importa el ícono "People" en su versión contorneada (outlined)
import androidx.compose.material.icons.outlined.People

// Importa el tipo ImageVector, que representa un vector gráfico como un ícono
import androidx.compose.ui.graphics.vector.ImageVector

// Importa el archivo de recursos R generado automáticamente, donde están los strings (como R.string.tab_inbox)
import com.example.reply.R


/**
 * Navigation destinations in the app.
 * Comentario de documentación: define los destinos de navegación dentro de la app.
 */
enum class ReplyDestination(
    @StringRes val labelRes: Int,    // Parámetro que almacena un ID de string de recursos (como R.string.tab_inbox)
    val icon: ImageVector,           // Parámetro que almacena un ícono vectorial (ImageVector)
) {

    // Primer destino: "Inbox", con el string R.string.tab_inbox y el ícono relleno Inbox
    Inbox(R.string.tab_inbox, Icons.Default.Inbox),

    // Segundo destino: "Articles", con el string R.string.tab_article y el ícono Article
    Articles(R.string.tab_article, Icons.Default.Article),

    // Tercer destino: "Messages", con el string R.string.tab_dm y el ícono Chat (versión contorneada)
    Messages(R.string.tab_dm, Icons.Outlined.Chat),

    // Cuarto destino: "Groups", con el string R.string.tab_groups y el ícono People (versión contorneada)
    Groups(R.string.tab_groups, Icons.Outlined.People),
}
