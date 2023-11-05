package com.zezzi.eventzezziapp.data.repository

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.zezzi.eventzezziapp.data.networking.response.DishesCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.DishesResponse
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class MealsRepository2 {

    val db = Firebase.firestore
    suspend fun getMeals(): MealsCategoriesResponse {
        return withContext(Dispatchers.IO) {
            //Se bajan todos los documentos de la coleccion Meals
            val documents = db.collection("Categories")
                .get().await().documents

            MealsCategoriesResponse(
                documents.map {
                    MealResponse(
                        it.id,
                        it.getString("strCategory") ?: "",
                        it.getString("strCategoryDescription") ?: "",
                        it.getString("strCategoryThumb") ?: ""
                    )
                }
            )
        }
    }

    suspend fun getDishes(category: String): DishesCategoriesResponse {
        return withContext(Dispatchers.IO) {
            //Se bajan todos los documentos de la coleccion Meals
            val documents = db.collection("Categories")
                .document(category).collection("Dishes")
                .get().await().documents

            DishesCategoriesResponse(
                documents.map {
                    DishesResponse(
                        it.getString("strMeal") ?: "",
                        it.getString("strMealThumb") ?: "",
                        it.id
                    )
                }
            )
        }
    }

    //No se implemento esto porque hacer la lista de todos los ingredientes es muy tardado
    /*
    suspend fun getDish(): InstructionsCategoriesResponse {
        return withContext(Dispatchers.IO) {
            //Se bajan todos los documentos de la coleccion Meals
            val documents = db.collection("Categories")
                .get().await().documents

            InstructionsCategoriesResponse(
                documents.map {
                    InstructionsResponse(
                        it.id,
                        it.getString("name") ?: "",
                        it.getString("category") ?: "",
                        it.getString("instructions") ?: "",
                        it.getString("imageUrl") ?: "",
                        it.getString("youtube") ?: "",
                        it.getString("ingredient1") ?: "",
                        it.getString("ingredient2") ?: "",
                        it.getString("ingredient3") ?: "",
                        it.getString("ingredient4") ?: "",
                        it.getString("ingredient5") ?: "",
                        it.getString("ingredient6") ?: "",
                        it.getString("ingredient7") ?: "",
                        it.getString("ingredient8") ?: "",
                        it.getString("ingredient9") ?: "",
                        it.getString("ingredient10") ?: "",
                        it.getString("ingredient11") ?: "",
                        it.getString("ingredient12") ?: "",
                        it.getString("ingredient13") ?: "",
                        it.getString("ingredient14") ?: "",
                        it.getString("ingredient15") ?: "",
                        it.getString("ingredient16") ?: "",
                        it.getString("ingredient17") ?: "",
                        it.getString("ingredient18") ?: "",
                        it.getString("ingredient19") ?: "",
                        it.getString("ingredient20") ?: "",
                        it.getString("source") ?: ""
                    )
                }
            )
        }
    }*/
}