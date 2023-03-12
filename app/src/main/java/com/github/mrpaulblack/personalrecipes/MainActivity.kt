package com.github.mrpaulblack.personalrecipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    RecipesGrid(10)
                }
            }
        }
    }
}

data class Recipe(val title: String, val text: String)

@Composable
fun RecipesGrid(amount: Int) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .padding(
                start = 12.dp,
                end = 12.dp,
                top = 12.dp,
                bottom = 12.dp
            )
    ) {
        items(amount) { i ->
            RecipeCard(Recipe("YumYum", "Schmackofatz"))
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeCard(rec: Recipe) {
    ElevatedCard(
        onClick = { /* Do something */ },
        modifier = Modifier.size(width = 180.dp, height = 250.dp)

    ) {
        Box(Modifier.fillMaxSize()) {
            Column {
                Image(
                    painter = painterResource(R.drawable.testpic),
                    contentDescription = "test picture",
                    modifier = Modifier
                        .size(180.dp)
                        .clip(CircleShape)

                )
                Row() {
                    Spacer(modifier = Modifier.width(8.dp))
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

@Preview
@Composable
fun PreviewConversation() {
        RecipesGrid(10)
}



