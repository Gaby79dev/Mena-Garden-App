package com.garden.menagarden.ui.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garden.menagarden.data.model.Category
import com.garden.menagarden.data.model.MenuItem
import com.garden.menagarden.data.repository.MenuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val menuRepository: MenuRepository
) : ViewModel() {

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    private val _menuItems = MutableStateFlow<Map<String, List<MenuItem>>>(emptyMap())
    val menuItems: StateFlow<Map<String, List<MenuItem>>> = _menuItems

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchMenuData()
    }

    private fun fetchMenuData() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // Fetch categories and items using the repository
                val categoryList = menuRepository.getCategories()
                _categories.value = categoryList

                val menuItemMap = menuRepository.getMenuItems()
                _menuItems.value = menuItemMap

            } catch (e: Exception) {
                // Handle exceptions, e.g., logging or showing an error state
            } finally {
                _isLoading.value = false
            }
        }
    }
}
