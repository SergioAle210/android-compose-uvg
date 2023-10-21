package com.zezzi.eventzezziapp.ui.meals.view

import com.zezzi.eventzezziapp.data.networking.response.DishesResponse

data class DishesUiState(
    val meals: List<DishesResponse>,
    val loading: Boolean = false
)


