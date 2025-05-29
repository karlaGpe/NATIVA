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
import androidx.compose.material.icons.Icons                // Importa conjunto de íconos predeterminados de Material
import androidx.compose.material.icons.filled.AttachMoney  // Importa icono "AttachMoney"
import androidx.compose.material.icons.filled.Money        // Importa icono "Money"
import androidx.compose.material.icons.filled.MoneyOff     // Importa icono "MoneyOff"
import androidx.compose.material.icons.filled.PieChart     // Importa icono "PieChart"
import androidx.compose.runtime.Composable                  // Importa Composable para funciones de UI
import androidx.compose.ui.graphics.vector.ImageVector      // Importa ImageVector, tipo para representar íconos vectoriales
import com.example.compose.rally.ui.accounts.AccountsScreen        // Importa composable de pantalla "Accounts"
import com.example.compose.rally.ui.accounts.SingleAccountScreen  // Importa composable de pantalla "SingleAccount"
import com.example.compose.rally.ui.bills.BillsScreen              // Importa composable de pantalla "Bills"
import com.example.compose.rally.ui.overview.OverviewScreen        // Importa composable de pantalla "Overview"

/**
 * Interfaz que define el contrato para las rutas de navegación en la app Rally.
 * Cada destino debe proveer un icono, una ruta y una pantalla composable.
 */
interface RallyDestination {
    val icon: ImageVector             // Icono que representa el destino en la UI
    val route: String                 // Ruta única que identifica el destino para la navegación
    val screen: @Composable () -> Unit  // Composable que define la UI a mostrar para este destino
}

/**
 * Objeto que representa la pantalla de Overview
 */
object Overview : RallyDestination {
    override val icon = Icons.Filled.PieChart          // Icono PieChart para esta pantalla
    override val route = "overview"                     // Ruta "overview" para navegación
    override val screen: @Composable () -> Unit = { OverviewScreen() }  // UI asociada: OverviewScreen composable
}

/**
 * Objeto que representa la pantalla de Accounts
 */
object Accounts : RallyDestination {
    override val icon = Icons.Filled.AttachMoney       // Icono AttachMoney para esta pantalla
    override val route = "accounts"                     // Ruta "accounts"
    override val screen: @Composable () -> Unit = { AccountsScreen() }  // UI asociada: AccountsScreen composable
}

/**
 * Objeto que representa la pantalla de Bills
 */
object Bills : RallyDestination {
    override val icon = Icons.Filled.MoneyOff          // Icono MoneyOff para esta pantalla
    override val route = "bills"                        // Ruta "bills"
    override val screen: @Composable () -> Unit = { BillsScreen() }     // UI asociada: BillsScreen composable
}

/**
 * Objeto que representa la pantalla de SingleAccount (cuenta individual)
 */
object SingleAccount : RallyDestination {
    // Comentario: este icono no se usa en la pestaña principal porque SingleAccount no está en el RallyTabRow
    override val icon = Icons.Filled.Money              // Icono Money para esta pantalla
    override val route = "single_account"                // Ruta "single_account"
    override val screen: @Composable () -> Unit = { SingleAccountScreen() }  // UI asociada: SingleAccountScreen composable

    const val accountTypeArg = "account_type"          // Constante para argumento de tipo de cuenta en la navegación
}

// Lista de pantallas que se mostrarán en la fila de pestañas principal RallyTabRow
val rallyTabRowScreens = listOf(Overview, Accounts, Bills)
