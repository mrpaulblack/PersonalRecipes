package com.github.mrpaulblack.personalrecipes.ui.recipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel

object Recipe {
    const val route: String = "recipe"

    @Composable
    fun Content(rec: RecipeModel, modifier: Modifier = Modifier) {
        Surface(
            modifier = modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = rec.label,
                    fontSize = 30.sp
                )
                Image(
                    painter = rememberAsyncImagePainter("https://picsum.photos/700/700"),
                    contentDescription = "My content description",
                )
                Row( modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row() {
                        Text(
                            text = "Total Weight: "
                        )
                        Text(
                            text = rec.totalWeight.toString()
                        )
                    }
                    Row() {
                        Text(
                            text = "Calories: "
                        )
                        Text(
                            text = rec.calories.toString()
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(
                        start = 12.dp,
                        end = 12.dp,
                        top = 12.dp,
                        bottom = 12.dp
                    )
            ) {
                RecipeCard("Health Labels: ", rec.healthLabels)
                RecipeCard("Tools: ", rec.tools)
                RecipeCard("Diet Labels: ", rec.dietLabels)
                RecipeCard("Cautions: ", rec.cautions)
            }
        }
    }
}

@Composable
fun RecipeCard(titel: String, list: List<String>) {
    Text(
        text = titel,
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
