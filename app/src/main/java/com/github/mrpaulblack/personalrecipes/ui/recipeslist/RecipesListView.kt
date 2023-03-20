package com.github.mrpaulblack.personalrecipes.ui.recipeslist

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel
import com.github.mrpaulblack.personalrecipes.ui.components.RecipeCard
import org.koin.androidx.compose.koinViewModel


object RecipesListView {
    const val route: String = "recipesList"


    @Composable
    fun Content(
        onClick: (route: String) -> Unit,
        modifier: Modifier = Modifier,
        viewModel: RecipesListViewModel = koinViewModel()
    ) {
        val recipesList: MutableState<List<RecipeModel>> = remember {viewModel.recipesList}

        Surface(
            modifier = modifier.fillMaxSize()
        ) {
            Column {
                AnimatedVisibility(visible = recipesList.value.isEmpty()) {
                    LinearProgressIndicator(modifier = Modifier
                        .height(2.dp)
                        .fillMaxWidth())
                }
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    items (recipesList.value.size) {
                        RecipeCard.Content(recipesList.value[it], onClick)
                    }
                }
            }
        }
    }
}
