package com.garden.menagarden.data.repository

import com.garden.menagarden.data.model.Menu

interface MenuRepository {
    suspend fun getMenu(): Menu
}
