package com.github.mrpaulblack.personalrecipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.mrpaulblack.personalrecipes.ui.counter.CounterView
import com.github.mrpaulblack.personalrecipes.ui.nav.NavBar
import com.github.mrpaulblack.personalrecipes.ui.recipe.RecipeView
import com.github.mrpaulblack.personalrecipes.ui.recipeslist.RecipesListView
import com.github.mrpaulblack.personalrecipes.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppTheme {
                Scaffold(
                    bottomBar = { NavBar.Content(
                        currentRoute= navController.currentBackStackEntryAsState(),
                        onClick = { route -> navController.navigateSingleTop(route) }
                    ) }
                ) { paddingValues ->
                    NavHost(navController, startDestination = RecipesListView.route) {
                        composable(RecipesListView.route) {RecipesListView.Content(
                            onClick = { route, recipe ->
                                RecipeView.viewModel.recipe.value = recipe
                                navController.navigate(route)
                            },
                            modifier = Modifier.padding(paddingValues)
                        )}
                        composable(CounterView.route) { CounterView.Content() }
                        composable(RecipeView.route) { RecipeView.Content() }
                    }
                }
            }
        }
    }
}

// NavController extension
// this prevents opening the same route multiple times on the stack when for example the same tab is pressed on an always visible nav bar
fun NavHostController.navigateSingleTop(route: String) =
    this.navigate(route) { launchSingleTop = true }
