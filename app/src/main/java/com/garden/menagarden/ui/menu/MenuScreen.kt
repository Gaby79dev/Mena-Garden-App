package com.garden.menagarden.ui.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.garden.menagarden.data.model.MenuItem

val PrimaryColor = Color(0xFF38e07b)
val BackgroundDark = Color(0xFF122017)
val CardBackgroundColor = Color(0xFF1c2620)
val TextColor = Color.White
val TextColorSecondary = Color.White.copy(alpha = 0.7f)

@Composable
fun FoodMenuScreen(menuViewModel: MenuViewModel = hiltViewModel()) {
    val menu by menuViewModel.menu.collectAsStateWithLifecycle()
    val isLoading by menuViewModel.isLoading.collectAsStateWithLifecycle()

    val menuByCategory = remember(menu) {
        menu?.let {
            linkedMapOf<String, List<MenuItem>>().apply {
                if (it.comidas.desayunos.isNotEmpty()) put("Desayunos", it.comidas.desayunos.values.toList())
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopAppBar(
    isSearchActive: Boolean,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onToggleSearch: () -> Unit
) {
    TopAppBar(
        title = {
            if (isSearchActive) {
                TextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,
                    placeholder = { Text("Buscar en el menú...") },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = PrimaryColor,
                        unfocusedIndicatorColor = TextColorSecondary,
                        cursorColor = PrimaryColor,
                        focusedTextColor = TextColor,
                        unfocusedTextColor = TextColor,
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                Text(
                    text = "Mena Garden Nerja",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = TextColor,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        navigationIcon = {
            if (!isSearchActive) {
                Icon(
                    imageVector = Icons.Default.RestaurantMenu,
                    contentDescription = "Menu Icon",
                    tint = TextColor,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = onToggleSearch) {
                Icon(
                    imageVector = if (isSearchActive) Icons.Default.Close else Icons.Default.Search,
                    contentDescription = if (isSearchActive) "Cerrar búsqueda" else "Buscar",
                    tint = TextColor
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BackgroundDark.copy(alpha = 0.8f)
        )
    )
}

@Composable
fun MenuCategoryTabs(
    categories: List<String>,
    selectedCategory: String?,
    onCategorySelected: (String) -> Unit
) {
    if (categories.isNotEmpty()) {
        val selectedIndex = categories.indexOf(selectedCategory).coerceIn(0, categories.size - 1)

        PrimaryTabRow(
            selectedTabIndex = selectedIndex,
            containerColor = BackgroundDark,
            indicator = {
                TabRowDefaults.PrimaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(selectedIndex),
                    color = PrimaryColor
                )
            }
        ) {
            categories.forEach { category ->
                Tab(
                    selected = category == selectedCategory,
                    onClick = { onCategorySelected(category) },
                    text = { Text(text = category) },
                    selectedContentColor = PrimaryColor,
                    unselectedContentColor = TextColorSecondary
                )
            }
        }
    }
}

@Composable
fun MenuItemCard(item: MenuItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackgroundColor)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.nombre, color = TextColor, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            if (!item.descripcion.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.descripcion, color = TextColorSecondary, fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "%.2f€".format(item.precio),
                color = PrimaryColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}
