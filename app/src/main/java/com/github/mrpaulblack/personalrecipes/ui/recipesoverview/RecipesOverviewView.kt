package com.github.mrpaulblack.personalrecipes.ui.recipesoverview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.github.mrpaulblack.personalrecipes.R
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel
import com.github.mrpaulblack.personalrecipes.data.models.RecipesDetailModel

object RecipesOverviewView {
    private val viewModel = RecipesOverviewViewModel()

    const val route: String = "recipesoverview"

    @Composable
    fun Content(modifier: Modifier = Modifier) {
        val recipesList: MutableList<RecipesDetailModel> by viewModel.recipesList.observeAsState(initial = mutableListOf<RecipesDetailModel>())

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = modifier
        ) {
            items (recipesList.size) {
                RecipeCard(RecipeModel(recipesList[it].label, recipesList[it].uri))
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun RecipeCard(rec: RecipeModel) {
        ElevatedCard(
            onClick = { /* Do something */ },
            modifier = Modifier.size(width = 180.dp, height = 154.dp)

        ) {
            Box(Modifier.fillMaxSize()) {
                Column {
                    Image(
                        painter = painterResource(R.drawable.testpic),
                        contentDescription = "test picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(180.dp)
                            .height(100.dp)
                    )
                    Row {
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = rec.title)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(text = rec.text)
                        }

                    }

                }
            }
        }
    }
}

