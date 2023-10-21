package com.zezzi.eventzezziapp.ui.meals.view

import com.zezzi.eventzezziapp.data.networking.response.InstructionsResponse

data class DishUiState(
    val meals: List<InstructionsResponse>,
    val loading: Boolean = false
)
