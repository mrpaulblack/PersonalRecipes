package com.github.mrpaulblack.personalrecipes.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import com.github.mrpaulblack.personalrecipes.R
import com.github.mrpaulblack.personalrecipes.ui.recipeslist.RecipesListView
import com.github.mrpaulblack.personalrecipes.ui.search.SearchView

object NavBar {
    private val navBarItems = listOf(
        NavBarItem(
            name = R.string.nav_search,
            route = SearchView.route,
            icon = Icons.Rounded.Search
        ),
        NavBarItem(
            name = R.string.nav_home,
            route = RecipesListView.route,
            icon = Icons.Rounded.Home
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
