package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.DishesCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.InstructionsCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {
    @GET("categories.php")
    suspend fun getMeals(): MealsCategoriesResponse

    @GET("filter.php")
    suspend fun getDishes(
        @Query("c") category: String
    ): DishesCategoriesResponse

    @GET("lookup.php")
    suspend fun getDish(
        @Query("i") id: String
    ): InstructionsCategoriesResponse
}