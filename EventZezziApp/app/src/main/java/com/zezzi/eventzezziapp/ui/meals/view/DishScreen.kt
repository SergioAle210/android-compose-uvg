package com.zezzi.eventzezziapp.ui.meals.view

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.zezzi.eventzezziapp.navigation.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishScreen(
    navController: NavController,
    id: String,
    viewModel2: DishCategoriesViewModel = viewModel()
) {
    var i = 1
    val context = LocalContext.current
    if (viewModel2.instructionsUiState.meals.isEmpty()) {
        viewModel2.getDish(id)
    }

    Scaffold(
        topBar = {
            AppBar(title = "Meals for $id", navController = navController)
        }
    ) {
        if (viewModel2.instructionsUiState.loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LinearProgressIndicator(
                    modifier = Modifier.width(100.dp),
                    color = Color(229, 204, 255, 255)
                )
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                contentPadding = it,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(229, 204, 255, 255))
            ) {
                items(viewModel2.instructionsUiState.meals) { meal ->
                    val ingredients = listOf(
                        meal.ingredient1,
                        meal.ingredient2,
                        meal.ingredient3,
                        meal.ingredient4,
                        meal.ingredient5,
                        meal.ingredient6,
                        meal.ingredient7,
                        meal.ingredient8,
                        meal.ingredient9,
                        meal.ingredient10,
                        meal.ingredient11,
                        meal.ingredient12,
                        meal.ingredient13,
                        meal.ingredient14,
                        meal.ingredient15,
                        meal.ingredient16,
                        meal.ingredient17,
                        meal.ingredient18,
                        meal.ingredient19,
                        meal.ingredient20
                    )
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = meal.name,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            fontSize = 24.sp
                        )
                        AsyncImage(
                            model = meal.imageUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .height(200.dp)
                        )
                        Text(
                            text = "Ingredients:",
                            textAlign = TextAlign.Left,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            fontSize = 16.sp
                        )
                        //Mostrar todos los ingredientes
                        for (ingredient in ingredients) {
                            if (ingredient != "" && ingredient != null) {
                                Text(
                                    text = "$i) $ingredient",
                                    textAlign = TextAlign.Left,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                )
                            }
                            i++;
                        }

                        Text(
                            text = "Instructions:",
                            textAlign = TextAlign.Left,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            fontSize = 16.sp
                        )
                        Text(
                            text = meal.instructions,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )

                        if (meal.youtube == ""){
                            Text(
                                text = "No YouTube video available",
                                textAlign = TextAlign.Left,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )
                        }else{
                            Button(
                                onClick = {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(meal.youtube))
                                    context.startActivity(intent)
                                },
                                modifier = Modifier
                                    .width(250.dp)
                                    .align(Alignment.CenterHorizontally),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(80, 0, 131, 255),
                                )
                            )
                            {
                                Text(
                                    text = "Watch on YouTube",
                                    fontSize = 16.sp,
                                    color = Color(199, 158, 226, 255),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
