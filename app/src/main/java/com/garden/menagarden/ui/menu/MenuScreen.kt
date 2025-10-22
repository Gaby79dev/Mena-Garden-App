package com.garden.menagarden.ui.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

val PrimaryColor = Color(0xFF38e07b)
val BackgroundDark = Color(0xFF122017)
val CardBackgroundColor = Color(0xFF1c2620)
val TextColor = Color.White
val TextColorSecondary = Color.White.copy(alpha = 0.7f)

data class MenuItem(
    val name: String,
    val description: String,
    val price: String,
    val imageUrl: String
)

val menuItems = listOf(
    MenuItem(
        "Ensalada de queso de cabra",
        "Una refrescante combinación de lechugas, queso de cabra caramelizado, nueces y vinagreta de miel.",
        "12.50€",
        "https://lh3.googleusercontent.com/aida-public/AB6AXuCGc50FWMPzo9BdACtGI7mpuFTs2ypHVHTtK1BF-CqiDofcyp7nJS33-q7sN1NeR9GZ841kTehA8pUNqV1rkvO990sujbTuEMXY0c3tYw0_4npuUEgBI1q8c4atzCj1nuS1imtCVL-lZQSr6Lgf9lTu4BeW0c-IuTuuheZ5b40lSjksFC-2WzFo8HpWMt8kXHo4z8krTrPEMASNgUfoVMucJ4ce07niCv9ir91d_j78Fvj2qmFfbzEhJ4URJeStBBngtVM6mHjfyOg"
    ),
    MenuItem(
        "Croquetas de Jamón Ibérico",
        "Cremosas y crujientes, elaboradas con la receta tradicional de la abuela.",
        "9.00€",
        "https://lh3.googleusercontent.com/aida-public/AB6AXuBwWfa8jXktrkppw9P0fqM2QpxNCK8RlP13VHRwL3g_EcTdAvhin6L-oybLLCh0FFnX7qwO5mChQzQuLmV2QdlFslD2vtGyf78jvMVoNabUSxR31XjeEriDw8h_QsYanYdwvawtQ3ZfpXExWy_r_F_VTCQiH7IP1yxw0YB5KgdC_U49JDIki9-ngNWWeXn8-WqQ2LJwsOn-DG8xYy7DIK9fTJBM7mWl9iGdmYIGYQc0qJ56LHlZVAP-Kv8_MSinz0MFrhWn0U3795Q"
    ),
    MenuItem(
        "Pulpo a la Brasa",
        "Tierno pulpo a la brasa con puré de patata trufado y pimentón de la Vera.",
        "18.50€",
        "https://lh3.googleusercontent.com/aida-public/AB6AXuC1rHN5X0PLsFXDJVPyJTD_bfEWITySFXV6KAol8-e_AJh8m-s4AmXDsA2kAibPEKRU6wIvCUnEYADUVrJCFGR2cuPg_NP0rnC_Nt3ySTCyMzeOAPXH2Goze1PuPnEuFBmIIBeZzCrzrlaeSSC7nphxmhkldfAKsRRLOKSecEgsjurZc7rWql3v-KKxexutskhIf2r-ve-qh4JDDHuLIwrDqlxsLU7Wzq8J0et22Ob5oGZBkmsqLigAQpbPgLeigLEsRPn-N8OCdJE"
    )
)

val categories = listOf("Entrantes", "Principales", "Postres", "Bebidas", "Cócteles")

@Composable
fun MenuScreen() {
    var selectedCategory by remember { mutableStateOf(categories.first()) }

    Scaffold(
        topBar = { MenuTopAppBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO: Open shopping cart */ },
                containerColor = PrimaryColor,
                contentColor = BackgroundDark
            ) {
                Icon(Icons.Filled.ShoppingCart, contentDescription = "Carrito de compras")
            }
        },
        containerColor = BackgroundDark
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            MenuCategoryTabs(
                categories = categories,
                selectedCategory = selectedCategory,
                onCategorySelected = { selectedCategory = it }
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(menuItems) { item ->
                    MenuItemCard(item = item)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Mena Garden Nerja",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = TextColor,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.RestaurantMenu,
                contentDescription = "Menú",
                tint = TextColor,
                modifier = Modifier.padding(start = 16.dp)
            )
        },
        actions = {
            IconButton(onClick = { /* TODO: Implement search */ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Buscar",
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
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    PrimaryTabRow(
        selectedTabIndex = categories.indexOf(selectedCategory),
        containerColor = BackgroundDark,
        contentColor = PrimaryColor,
        indicator = {
            TabRowDefaults.PrimaryIndicator(
                modifier = Modifier.tabIndicatorOffset(categories.indexOf(selectedCategory)),
                color = PrimaryColor
            )
        }
    ) {
        categories.forEach { category ->
            Tab(
                selected = category == selectedCategory,
                onClick = { onCategorySelected(category) },
                text = {
                    Text(
                        text = category,
                        color = if (category == selectedCategory) PrimaryColor else TextColorSecondary
                    )
                }
            )
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
        Column {
            Image(
                painter = rememberAsyncImagePainter(item.imageUrl),
                contentDescription = item.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = item.name, color = TextColor, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.description, color = TextColorSecondary, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = item.price, color = PrimaryColor, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Button(
                        onClick = { /* TODO: Add to cart */ },
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Icon(Icons.Filled.AddShoppingCart, contentDescription = "Añadir al carrito", tint = BackgroundDark)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Añadir", color = BackgroundDark)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF122017)
@Composable
fun MenuScreenPreview() {
    MenuScreen()
}
