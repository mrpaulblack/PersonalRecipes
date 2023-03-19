package com.github.mrpaulblack.personalrecipes.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Calculate
import androidx.compose.material.icons.rounded.Dining
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import com.github.mrpaulblack.personalrecipes.R
import com.github.mrpaulblack.personalrecipes.ui.counter.CounterView
import com.github.mrpaulblack.personalrecipes.ui.recipe.RecipeView
import com.github.mrpaulblack.personalrecipes.ui.recipeslist.RecipesListView

object NavBar {
    private val navBarItems = listOf(
        NavBarItem(
            name = R.string.nav_home,
            route = RecipesListView.route,
            icon = Icons.Rounded.Home
        ),
        NavBarItem(
            name = R.string.nav_recipe,
            route = RecipeView.route,
            icon = Icons.Rounded.Dining
        ),
        NavBarItem(
            name = R.string.nav_counter,
            route = CounterView.route,
            icon = Icons.Rounded.Calculate
        )
    )

    @Composable
    fun Content(currentRoute: State<NavBackStackEntry?>, onClick: (route: String) -> Unit) {
        NavigationBar {
            navBarItems.forEach {
                NavigationBarItem(
                    icon = { Icon(it.icon, contentDescription = stringResource(it.name)) },
                    label = { Text(stringResource(it.name)) },
                    selected = currentRoute.value?.destination?.route == it.route,
                    onClick = { onClick(it.route) }
                )
            }
        }
    }
}
