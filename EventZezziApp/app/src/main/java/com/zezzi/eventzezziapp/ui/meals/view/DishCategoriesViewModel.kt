package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import kotlinx.coroutines.launch

class DishCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel()  {
    var instructionsUiState by mutableStateOf(DishUiState(emptyList()))
        private set
    fun getDish(id: String) {
        instructionsUiState = DishUiState(emptyList(), loading = true)

        viewModelScope.launch {
            instructionsUiState = DishUiState(
                meals = repository.getDish(id).meals
            )
        }
    }
}