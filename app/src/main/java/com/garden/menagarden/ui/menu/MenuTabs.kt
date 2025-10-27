package com.garden.menagarden.ui.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier


@Composable
fun MenuTabs(selectedTab: String? = null) {
    val tabs = listOf("Comida", "Bebidas")
    val initialTabIndex = tabs.indexOf(selectedTab).coerceAtLeast(0)
    var selectedTabIndex by remember { mutableStateOf(initialTabIndex) }

    LaunchedEffect(selectedTab) {
        val newIndex = tabs.indexOf(selectedTab).coerceAtLeast(0)
        if (newIndex != selectedTabIndex) {
            selectedTabIndex = newIndex
        }
    }

    Column {
        // Usamos TabRow en lugar de PrimaryTabRow para evitar el error
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = BackgroundDark,
            contentColor = PrimaryColor,
            indicator = { tabPositions ->
                // Verificamos que el índice sea válido antes de acceder a la lista
                if (selectedTabIndex < tabPositions.size) {
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        color = PrimaryColor
                    )
                }
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) },
                    selectedContentColor = PrimaryColor,
                    unselectedContentColor = TextColorSecondary
                )
            }
        }
        when (selectedTabIndex) {
            0 -> FoodMenuScreen()
            1 -> DrinksMenuScreen()
        }
    }
}