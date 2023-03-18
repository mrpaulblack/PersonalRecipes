package com.github.mrpaulblack.personalrecipes.ui.recipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

object DetailedRecipes {
    const val route: String = "recipe"

    val label: String = "NoTitel"
    val calories: Int = 0
    val totalWeight: Int = 0
    val healthLabels: List<String> = listOf("Not Available")
    val tools: List<String> = listOf("Not Available")
    val cautions: List<String> = listOf("Not Available")
    val dietLabels: List<String> = listOf("Not Available")

    @Composable
    fun Content() {
        ElevatedCard(
            modifier = Modifier
                .size(
                    width = LocalConfiguration.current.screenWidthDp.dp,
                    height = (LocalConfiguration.current.screenHeightDp.dp)
                )
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )

        ) {
            Column(Modifier.fillMaxSize()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row() {
                        Text(
                            text = label,
                            fontSize = 30.sp
                        )
                    }
                    Row() {
                        Image(
                            painter = rememberImagePainter("https://picsum.photos/700/700"),
                            contentDescription = "My content description",
                        )
                    }
                    Row( modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Row() {
                            Text(
                                text = "Total Weight: "
                            )
                            Text(
                                text = totalWeight.toString()
                            )
                        }
                        Row() {
                            Text(
                                text = "Calories: "
                            )
                            Text(
                                text = calories.toString()
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
                    RecipeCard("Health Labels: ", healthLabels)
                    RecipeCard("Tools: ", tools)
                    RecipeCard("Diet Labels: ", dietLabels)
                    RecipeCard("Cautions: ", cautions)
                }
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
