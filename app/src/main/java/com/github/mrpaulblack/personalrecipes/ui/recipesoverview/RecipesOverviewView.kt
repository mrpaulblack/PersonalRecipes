package com.github.mrpaulblack.personalrecipes.ui.recipesoverview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mrpaulblack.personalrecipes.R


data class Recipe(val title: String, val text: String)


@Preview
@Composable
fun PreviewConversation() {
    RecipesOverviewView.Content(10)
}


object RecipesOverviewView {
    const val route: String = "recipesoverview"

    @Composable
    fun Content(amount: Int, modifier: Modifier = Modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = modifier
        ) {
            items(amount) { i ->
                RecipeCard(Recipe("YumYum", i.toString()))
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun RecipeCard(rec: Recipe) {
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
                    Row() {
                        Spacer(modifier = Modifier.width(16.dp))
                        Column() {
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
