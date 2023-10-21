package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.DishesCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.InstructionsCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse {
        return withContext(Dispatchers.IO) {
            webService.getMeals()
        }
    }
    suspend fun getDishes(category: String): DishesCategoriesResponse {
        return withContext(Dispatchers.IO) {
            webService.getDishes(category)
        }
    }

    suspend fun getDish(id: String): InstructionsCategoriesResponse {
        return withContext(Dispatchers.IO) {
            webService.getDish(id)
        }
    }
}