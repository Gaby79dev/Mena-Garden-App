package com.garden.menagarden.ui.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garden.menagarden.data.model.Menu
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

    private val _menu = MutableStateFlow<Menu?>(null)
    val menu: StateFlow<Menu?> = _menu

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchMenuData()
    }

    private fun fetchMenuData() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _menu.value = menuRepository.getMenu()
            } catch (e: Exception) {
                // Handle exceptions, e.g., logging or showing an error state
                 _menu.value = null // Or some error state
            } finally {
                _isLoading.value = false
            }
        }
    }
}
