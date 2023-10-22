package com.zezzi.eventzezziapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zezzi.eventzezziapp.ui.meals.view.DishScreen
import com.zezzi.eventzezziapp.ui.meals.view.MealsCategoriesScreen
import com.zezzi.eventzezziapp.ui.meals.view.MealsScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationState.Categories.route,
        modifier = modifier
    ) {
        composable(route = NavigationState.Categories.route) {
            MealsCategoriesScreen(navController)
        }
        composable(route = NavigationState.Meals.route + "/{category}") { backstackEntry ->
            MealsScreen(navController, backstackEntry.arguments?.getString("category") ?: "")
        }
        composable(route = NavigationState.Dish.route + "/{id}") { backstackEntry ->
            DishScreen(navController, backstackEntry.arguments?.getString("id") ?: "")
        }
    }
}