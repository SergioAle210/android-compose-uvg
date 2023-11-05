package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.repository.MealsRepository2
import kotlinx.coroutines.launch

class DishesCategoriesViewModel(private val repository: MealsRepository2 = MealsRepository2()): ViewModel() {
    var mealsUiState by mutableStateOf(DishesUiState(emptyList()))
        private set
    fun getDishes(category: String) {
        mealsUiState = DishesUiState(emptyList(), loading = true)

        viewModelScope.launch {
            mealsUiState = DishesUiState(
                meals = repository.getDishes(category).meals
            )
        }
    }
}