package com.github.mrpaulblack.personalrecipes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object IngredientCard {
    @Composable
    fun Content(modifier: Modifier = Modifier) {
        Column(modifier = modifier) {
            Divider(
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.secondary
            )
            Row {
                Text(text = "amount of ingredient")
                Column {
                    Text(text = "name of ingredient")
                    Text(text = "details")
                }
            }
        }
    }
}
