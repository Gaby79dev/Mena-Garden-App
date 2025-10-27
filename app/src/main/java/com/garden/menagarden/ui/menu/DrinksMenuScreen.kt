package com.garden.menagarden.ui.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.garden.menagarden.data.model.MenuItem

@Composable
fun DrinksMenuScreen(menuViewModel: MenuViewModel = hiltViewModel()) {
    val menu by menuViewModel.menu.collectAsStateWithLifecycle()
    val isLoading by menuViewModel.isLoading.collectAsStateWithLifecycle()

    val menuByCategory = remember(menu) {
        menu?.let {
            linkedMapOf<String, List<MenuItem>>().apply {
                if (it.bebidas.refrescos.isNotEmpty()) put("Refrescos", it.bebidas.refrescos.values.toList())
                if (it.bebidas.cervezas.isNotEmpty()) put("Cervezas", it.bebidas.cervezas.values.toList())
                if (it.bebidas.vinosCavas.isNotEmpty()) put("Vinos y Cavas", it.bebidas.vinosCavas.values.toList())
                if (it.bebidas.cocktails.isNotEmpty()) put("Cocktails", it.bebidas.cocktails.values.toList())
                if (it.bebidas.vodka.isNotEmpty()) put("Vodka", it.bebidas.vodka.values.toList())
                if (it.bebidas.gin.isNotEmpty()) put("Gin", it.bebidas.gin.values.toList())
                if (it.bebidas.ron.isNotEmpty()) put("Ron", it.bebidas.ron.values.toList())
                if (it.bebidas.whisky.isNotEmpty()) put("Whisky", it.bebidas.whisky.values.toList())
                if (it.bebidas.cafeInfusiones.isNotEmpty()) put("Café e Infusiones", it.bebidas.cafeInfusiones.values.toList())
            }
        } ?: emptyMap()
    }

    val categories = remember(menuByCategory) { menuByCategory.keys.toList() }

    var selectedCategory by remember { mutableStateOf<String?>(null) }
    var searchQuery by remember { mutableStateOf("") }
    var isSearchActive by remember { mutableStateOf(false) }

    LaunchedEffect(categories) {
        if (categories.isNotEmpty() && selectedCategory == null) {
            selectedCategory = categories.first()
        }
    }

    Scaffold(
        topBar = {
            MenuTopAppBar(
                isSearchActive = isSearchActive,
                searchQuery = searchQuery,
                onSearchQueryChange = { searchQuery = it },
                onToggleSearch = {
                    isSearchActive = !isSearchActive
                    if (!isSearchActive) {
                        searchQuery = ""
                    }
                }
            )
        },
        containerColor = BackgroundDark
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            if (isLoading && categories.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = PrimaryColor)
                }
            } else {
                if (!isSearchActive) {
                    MenuCategoryTabs(
                        categories = categories,
                        selectedCategory = selectedCategory,
                        onCategorySelected = { selectedCategory = it }
                    )
                }

                val itemsToDisplay = if (isSearchActive) {
                    menuByCategory.values.flatten().filter {
                        it.nombre.contains(searchQuery, ignoreCase = true) ||
                                (it.descripcion?.contains(searchQuery, ignoreCase = true) == true)
                    }
                } else {
                    selectedCategory?.let { menuByCategory[it] } ?: emptyList()
                }

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(itemsToDisplay) { item ->
                        MenuItemCard(item = item)
                    }
                }
            }
        }
    }
}
