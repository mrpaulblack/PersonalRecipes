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
import org.koin.androidx.compose.koinViewModel

object SearchView {
    const val route: String = "search"

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Content(
        onClick: (route: String) -> Unit,
        modifier: Modifier = Modifier,
        viewModel: SearchViewModel = koinViewModel()
    ) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        val recipesList: List<RecipeModel> by viewModel.query(textState).observeAsState(
            initial = listOf()
        )

        Surface(
            modifier = modifier.fillMaxSize()
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
