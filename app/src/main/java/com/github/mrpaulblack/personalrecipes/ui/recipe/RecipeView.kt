package com.github.mrpaulblack.personalrecipes.ui.recipe

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.MonitorWeight
import androidx.compose.material.icons.rounded.Scale
import androidx.compose.material.icons.rounded.Source
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.github.mrpaulblack.personalrecipes.R
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel
import com.github.mrpaulblack.personalrecipes.ui.components.InfoCard
import com.github.mrpaulblack.personalrecipes.ui.components.IngredientsCard
import com.github.mrpaulblack.personalrecipes.ui.components.RecipeImage
import org.koin.androidx.compose.koinViewModel

object RecipeView {
    const val route: String = "recipe"

    @Composable
    fun Content(
        onBack: () -> Unit,
        backStackEntry: NavBackStackEntry,
        modifier: Modifier = Modifier,
        viewModel: RecipeViewModel = koinViewModel()
    ) {

        val recipeName: String = backStackEntry.arguments?.getString("recipeName") ?: ""
        val recipe: RecipeModel by viewModel.getRecipe(recipeName).observeAsState(initial = RecipeModel())

        Surface(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.BottomStart
                ) {
                    RecipeImage.Content(
                        model = recipe.image,
                        contentDescription = recipe.source,
                        Modifier.height(240.dp)
                    )
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {
                        IconButton(onClick = { onBack() }) {
                            Icon(
                                imageVector = Icons.Rounded.ArrowBack,
                                contentDescription = stringResource(R.string.app_nav_back),
                                tint = Color.White
                            )
                        }
                        Text(
                            text = recipe.label,
                            style = MaterialTheme.typography.headlineLarge.copy(
                                shadow = Shadow (
                                    color = Color.Black,
                                    offset = Offset (4f, 4f),
                                    blurRadius = 8f
                                )
                            ),
                            color = Color.White,
                            maxLines = 4
                        )
                    }
                }
                Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        InfoCard.Content(
                            icon = Icons.Rounded.Scale,
                            label = stringResource(R.string.recipe_weight),
                            value = String.format("%.2f", recipe.totalWeight)
                        )
                        InfoCard.Content(
                            icon = Icons.Rounded.MonitorWeight,
                            label = stringResource(R.string.recipe_calories),
                            value = String.format("%.2f", recipe.calories)
                        )
                        InfoCard.Content(
                            icon = Icons.Rounded.Source,
                            label = stringResource(R.string.recipe_source),
                            value = recipe.source
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = stringResource(R.string.recipe_ingredients),
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    IngredientsCard.Content(recipe.ingredients)
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {
                        RecipeCard("Health Labels: ", recipe.healthLabels)
                        RecipeCard("Tools: ", recipe.tools)
                        RecipeCard("Diet Labels: ", recipe.dietLabels)
                        RecipeCard("Cautions: ", recipe.cautions)
                    }
                }
            }
        }
    }

    @Composable
    private fun RecipeCard(title: String, list: List<String>) {
        Text(
            text = title,
            modifier = Modifier
                .padding(
                    top = 12.dp,
                )
        )
        for (l in list) {
            Row( modifier = Modifier
                .padding(
                    start = 12.dp,
                )
            ) {
                Text(
                    text = l
                )
            }
        }
    }
}
