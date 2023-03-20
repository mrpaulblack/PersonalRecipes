package com.github.mrpaulblack.personalrecipes.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel
import com.github.mrpaulblack.personalrecipes.ui.recipe.RecipeView


@OptIn(ExperimentalMaterial3Api::class)
object RecipeListItem {
    @Composable
    fun Content(
        recipe: RecipeModel,
        onClick: (route: String) -> Unit,
        modifier: Modifier = Modifier
    ) {
        Column(modifier = modifier) {
            Divider(
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.secondaryContainer
            )
            Surface(
                onClick = {onClick("${RecipeView.route}/${recipe.label}")},
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {
                    androidx.compose.material3.Text(
                        text = recipe.label,
                        style = MaterialTheme.typography.labelLarge,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    androidx.compose.material3.Text(
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
