package com.github.mrpaulblack.personalrecipes.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.mrpaulblack.personalrecipes.R
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel
import com.github.mrpaulblack.personalrecipes.ui.components.RecipeListItem
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
        val textState = remember { viewModel.textState }
        viewModel.query(textState)
        val recipesList: MutableState<List<RecipeModel>> = remember {viewModel.recipes}

        Surface(
            modifier = modifier.fillMaxSize()
        ) {
            Column {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
                    value = textState.value,
                    label = { Text(stringResource(R.string.nav_search)) },
                    singleLine = true,
                    onValueChange = {
                        textState.value = it
                        viewModel.query(textState)
                    }
                )
                Spacer(modifier = Modifier.height(12.dp))
                LazyVerticalGrid(columns = GridCells.Fixed(1)) {
                    if (textState.value.text != "") {
                        items (recipesList.value.size) {
                            RecipeListItem.Content(recipe = recipesList.value[it], onClick = onClick)
                        }
                    }
                }
            }
        }
    }
}
