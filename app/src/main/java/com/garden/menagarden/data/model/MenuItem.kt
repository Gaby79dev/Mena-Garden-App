package com.garden.menagarden.data.model

data class MenuItem(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val category: String = "",
    val imageUrl: String? = null,
    val order: Long = 0
)
