package com.github.mrpaulblack.personalrecipes.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.navigation.NavBackStackEntry
import com.github.mrpaulblack.personalrecipes.ui.counter.CounterView
import com.github.mrpaulblack.personalrecipes.ui.recipesoverview.RecipesListView

object NavBar {
    private val navBarItems = listOf(
        NavBarItem(
            name = "Home",
            route = RecipesListView.route,
            icon = Icons.Default.Home
        ),
        NavBarItem(
            name = "Counter",
            route = CounterView.route,
            icon = Icons.Default.Calculate
        )
    )

    @Composable
    fun Content(currentRoute: State<NavBackStackEntry?>, onClick: (route: String) -> Unit) {
        NavigationBar {
            navBarItems.forEach {
                NavigationBarItem(
                    icon = { Icon(it.icon, contentDescription = it.name) },
                    label = { Text(it.name)},
                    selected = currentRoute.value?.destination?.route == it.route,
                    onClick = { onClick(it.route) }
                )
            }
        }
    }
}
