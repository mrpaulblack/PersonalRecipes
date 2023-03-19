package com.github.mrpaulblack.personalrecipes.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel
import com.github.mrpaulblack.personalrecipes.ui.recipe.RecipeView


object RecipeCard {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Content(
        recipe: RecipeModel,
        onClick: (route: String) -> Unit,
        modifier: Modifier = Modifier
    ) {
        ElevatedCard(
            onClick = { onClick("${RecipeView.route}/${recipe.label}") },
            modifier = modifier.height(height = 160.dp).fillMaxWidth()
        ) {
            Column {
                RecipeImage.Content(
                    model = recipe.image,
                    contentDescription = recipe.source,
                    Modifier.height(100.dp)
                )
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = recipe.label,
                        style = MaterialTheme.typography.labelLarge,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = recipe.source,
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
