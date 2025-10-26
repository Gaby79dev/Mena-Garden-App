package com.garden.menagarden.data.model

import com.google.firebase.database.PropertyName

data class Menu(
    val bebidas: Bebidas = Bebidas(),
    val comidas: Comidas = Comidas()
)

data class Bebidas(
    val refrescos: Map<String, MenuItem> = emptyMap(),
    val cervezas: Map<String, MenuItem> = emptyMap(),
    @get:PropertyName("vinos_cavas") @set:PropertyName("vinos_cavas")
    var vinosCavas: Map<String, MenuItem> = emptyMap(),
    val cocktails: Map<String, MenuItem> = emptyMap(),
    val vodka: Map<String, MenuItem> = emptyMap(),
    val gin: Map<String, MenuItem> = emptyMap(),
    val ron: Map<String, MenuItem> = emptyMap(),
    val whisky: Map<String, MenuItem> = emptyMap(),
    @get:PropertyName("cafe_infusiones") @set:PropertyName("cafe_infusiones")
    var cafeInfusiones: Map<String, MenuItem> = emptyMap()
)

data class Comidas(
    val desayunos: Map<String, MenuItem> = emptyMap()
)

data class MenuItem(
    val nombre: String = "",
    val precio: Double = 0.0,
    val descripcion: String? = null
)
