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

// Importaciones necesarias para diseño y layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

// Importaciones para diseño adaptable a barras de navegación y áreas seguras
import androidx.compose.foundation.layout.WindowInsets.*
import androidx.compose.foundation.layout.WindowInsetsSides.*
import androidx.compose.foundation.layout.safeDrawing

// Importaciones para listas con desplazamiento
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

// Para dar forma redonda a elementos
import androidx.compose.foundation.shape.CircleShape

// Iconos por defecto
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.StarBorder

// Componentes de Material Design 3
import androidx.compose.material3.*

// Soporte para funciones composables y layout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

// Para obtener recursos desde res/
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

// Para ajustar textos y alineación
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

// Modelo de datos Email
import com.example.reply.R
import com.example.reply.data.Email

// ------------------- PANE PRINCIPAL CON LISTA DE CORREOS -------------------

@Composable
fun ReplyListPane(
    replyHomeUIState: ReplyHomeUIState, // Estado que contiene lista de correos
    onEmailClick: (Email) -> Unit,      // Callback al hacer clic en un correo
    modifier: Modifier = Modifier       // Modificador opcional para personalizar
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(), // Ocupa todo el ancho
        contentPadding = safeDrawing.only(Horizontal + Top).asPaddingValues() // Respeta áreas seguras
    ) {
        // Barra de búsqueda al principio de la lista
        item {
            ReplySearchBar(modifier = Modifier.fillMaxWidth())
        }
        // Crea un ítem por cada correo recibido
        items(replyHomeUIState.emails) { email ->
            ReplyEmailListItem(
                email = email,
                onEmailClick = onEmailClick
            )
        }
    }
}

// ------------------- PANEL DETALLE DE UN CORREO Y SUS RESPUESTAS -------------------

@Composable
fun ReplyDetailPane(
    email: Email,
    modifier: Modifier = Modifier
) {
    val layoutDirection = LocalLayoutDirection.current // Detecta si el idioma es LTR o RTL

    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = safeDrawing.only(Horizontal + Top).asPaddingValues()
    ) {
        // Muestra el correo original
        item {
            ReplyEmailThreadItem(email)
        }
        // Muestra cada respuesta al correo
        items(email.replies) { reply ->
            ReplyEmailThreadItem(reply)
        }
    }
}

// ------------------- CADA ELEMENTO DE LA LISTA DE CORREOS -------------------

@Composable
fun ReplyEmailListItem(
    email: Email,
    onEmailClick: (Email) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onEmailClick(email) }, // Al hacer clic, se selecciona el correo
        modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            // Fila con imagen, nombre, fecha y estrella
            Row(modifier = Modifier.fillMaxWidth()) {
                // Imagen del remitente
                ReplyProfileImage(
                    drawableResource = email.sender.avatar,
                    description = email.sender.fullName,
                )
                // Info del remitente y fecha
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = email.sender.firstName,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        text = email.createAt,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
                // Icono de favorito
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    Icon(
                        imageVector = Icons.Default.StarBorder,
                        contentDescription = "Favorite",
                        tint = MaterialTheme.colorScheme.outline
                    )
                }
            }

            // Asunto del correo
            Text(
                text = email.subject,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = 12.dp, bottom = 8.dp),
            )
            // Cuerpo del correo (solo 2 líneas)
            Text(
                text = email.body,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

// ------------------- CADA ELEMENTO DE LA CONVERSACIÓN -------------------

@Composable
fun ReplyEmailThreadItem(
    email: Email,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                ReplyProfileImage(
                    drawableResource = email.sender.avatar,
                    description = email.sender.fullName,
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = email.sender.firstName,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        text = email.createAt,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    Icon(
                        imageVector = Icons.Default.StarBorder,
                        contentDescription = "Favorite",
                        tint = MaterialTheme.colorScheme.outline
                    )
                }
            }

            Text(
                text = email.subject,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier.padding(top = 12.dp, bottom = 8.dp),
            )

            Text(
                text = email.body,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )

            // Botones de responder y responder a todos
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.inverseOnSurface)
                ) {
                    Text(
                        text = stringResource(id = R.string.reply),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.inverseOnSurface)
                ) {
                    Text(
                        text = stringResource(id = R.string.reply_all),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

// ------------------- IMAGEN DE PERFIL REDONDA -------------------

@Composable
fun ReplyProfileImage(
    drawableResource: Int,
    description: String,
    modifier: Modifier = Modifier,
) {
    Image(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape), // Hace la imagen circular
        painter = painterResource(id = drawableResource), // Imagen desde recursos
        contentDescription = description, // Para accesibilidad
    )
}

// ------------------- BARRA DE BÚSQUEDA -------------------

@Composable
fun ReplySearchBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(MaterialTheme.colorScheme.surface, CircleShape),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icono de lupa
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = stringResource(id = R.string.search),
            modifier = Modifier.padding(start = 16.dp),
            tint = MaterialTheme.colorScheme.outline
        )
        // Texto "Search replies"
        Text(
            text = stringResource(id = R.string.search_replies),
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.outline
        )
        // Imagen del usuario actual (perfil)
        ReplyProfileImage(
            drawableResource = R.drawable.avatar_6,
            description = stringResource(id = R.string.profile),
            modifier = Modifier
                .padding(12.dp)
                .size(32.dp)
        )
    }
}
