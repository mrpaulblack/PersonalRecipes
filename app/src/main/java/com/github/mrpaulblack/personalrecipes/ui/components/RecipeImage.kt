package com.github.mrpaulblack.personalrecipes.ui.components

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage


object RecipeImage {
    @Composable
    fun Content(model: Any, contentDescription: String, modifier: Modifier = Modifier) {
        AsyncImage(
            model = model,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = modifier.background(
                color = MaterialTheme.colorScheme.secondaryContainer
            )
        )
    }
}
