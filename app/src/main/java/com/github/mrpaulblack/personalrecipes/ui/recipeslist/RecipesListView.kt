package com.github.mrpaulblack.personalrecipes.ui.recipeslist

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel

object RecipesListView {
    private val viewModel = RecipesListViewModel()

    const val route: String = "recipesList"

    @Composable
    fun Content(modifier: Modifier = Modifier) {
        val recipesList: List<RecipeModel> by viewModel.recipesList.observeAsState(
            initial = listOf()
        )

        Surface(
            modifier = modifier.fillMaxSize()
        ) {
            Column {
                AnimatedVisibility(visible = recipesList.isEmpty()) {
                    LinearProgressIndicator(modifier = Modifier
                        .height(2.dp)
                        .fillMaxWidth())
                }
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items (recipesList.size) {
                        RecipeCard(recipesList[it])
                    }
                }
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
            Column {
                AsyncImage(
                    model = rec.image,
                    contentDescription = rec.source,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(100.dp)
                )
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = rec.label,
                        style = MaterialTheme.typography.labelLarge,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = rec.source,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.secondary,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }
        }
    }
}
