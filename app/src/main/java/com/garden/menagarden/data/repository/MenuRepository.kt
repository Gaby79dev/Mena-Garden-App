package com.garden.menagarden.data.repository

import com.garden.menagarden.data.model.Category
import com.garden.menagarden.data.model.MenuItem


interface MenuRepository {
    suspend fun getCategories(): List<Category>
    suspend fun getMenuItems(): Map<String, List<MenuItem>>
}
