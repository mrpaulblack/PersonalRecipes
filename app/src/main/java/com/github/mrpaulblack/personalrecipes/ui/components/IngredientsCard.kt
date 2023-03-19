package com.github.mrpaulblack.personalrecipes.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.github.mrpaulblack.personalrecipes.data.models.IngredientsModel

object IngredientsCard {
    @Composable
    fun Content(
        ingredients: List<IngredientsModel>,
        modifier: Modifier = Modifier
    ) {
        Column(modifier = modifier) {
            ingredients.forEach {
                Divider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.secondaryContainer
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "${it.quantity} ${it.measure}",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Bold
                    )
                    Column {
                        Text(
                            text = it.food,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = it.foodCategory,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }
            Divider(
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.secondaryContainer
            )
        }
    }
}
