package com.zezzi.eventzezziapp.data.networking.response

import com.google.gson.annotations.SerializedName

data class DishesCategoriesResponse(val meals: List<DishesResponse>)

data class DishesResponse(
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String,
    @SerializedName("idMeal") val id: String,
)