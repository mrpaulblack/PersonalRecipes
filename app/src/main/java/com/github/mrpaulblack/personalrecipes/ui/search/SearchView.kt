package com.github.mrpaulblack.personalrecipes.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel
import com.github.mrpaulblack.personalrecipes.ui.components.RecipeCard
import com.github.mrpaulblack.personalrecipes.ui.recipeslist.RecipesListView

object Search {
    const val route: String = "search"
    private val viewModel = FilterdRecipesListViewModel()
    val listView = RecipesListView

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Content(
            modifier: Modifier = Modifier,
            onClick: (route: String, recipe: RecipeModel) -> Unit,
        ) {
            val textState = remember { mutableStateOf(TextFieldValue()) }
            val recipesList: List<RecipeModel> by viewModel.query(textState).observeAsState(
                initial = listOf()
            )

            Surface(
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row() {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = textState.value,
                        label = { Text("Search") },
                        singleLine = true,
                        onValueChange = {
                            textState.value = it
                            viewModel.query(textState)
                        }
                    )
                }
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items (recipesList.size) {
                        RecipeCard.Content(recipesList[it], onClick)
                    }
                }
            }
        }
    }
}
