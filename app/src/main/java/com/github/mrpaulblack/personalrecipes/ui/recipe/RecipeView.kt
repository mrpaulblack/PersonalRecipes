package com.github.mrpaulblack.personalrecipes.ui.recipe

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonitorWeight
import androidx.compose.material.icons.rounded.Scale
import androidx.compose.material.icons.rounded.Source
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.github.mrpaulblack.personalrecipes.R
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel
import com.github.mrpaulblack.personalrecipes.ui.components.InfoCard
import com.github.mrpaulblack.personalrecipes.ui.components.RecipeImage

object RecipeView {
    val viewModel = RecipeViewModel()

    const val route: String = "recipe"

    @Composable
    fun Content(modifier: Modifier = Modifier) {
        val recipe: RecipeModel by viewModel.recipe.observeAsState(initial = RecipeModel())

        Surface(
            modifier = modifier.fillMaxSize()
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
                        modifier = Modifier.padding(12.dp)
                    )
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
                    Text(text = stringResource(R.string.recipe_ingredients))
                }
            }
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = rec.label,
//                    fontSize = 30.sp
//                )
//                Image(
//                    painter = rememberAsyncImagePainter("https://picsum.photos/700/700"),
//                    contentDescription = "My content description",
//                )
//                Row( modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    Row() {
//                        Text(
//                            text = "Total Weight: "
//                        )
//                        Text(
//                            text = rec.totalWeight.toString()
//                        )
//                    }
//                    Row() {
//                        Text(
//                            text = "Calories: "
//                        )
//                        Text(
//                            text = rec.calories.toString()
//                        )
//                    }
//                }
//            }
//            Column(
//                modifier = Modifier
//                    .padding(
//                        start = 12.dp,
//                        end = 12.dp,
//                        top = 12.dp,
//                        bottom = 12.dp
//                    )
//            ) {
//                RecipeCard("Health Labels: ", rec.healthLabels)
//                RecipeCard("Tools: ", rec.tools)
//                RecipeCard("Diet Labels: ", rec.dietLabels)
//                RecipeCard("Cautions: ", rec.cautions)
//            }
        }
    }
}

@Composable
fun RecipeCard(title: String, list: List<String>) {
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
