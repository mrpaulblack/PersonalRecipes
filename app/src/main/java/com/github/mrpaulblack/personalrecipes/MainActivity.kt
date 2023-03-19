package com.github.mrpaulblack.personalrecipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.mrpaulblack.personalrecipes.ui.nav.NavBar
import com.github.mrpaulblack.personalrecipes.ui.recipe.RecipeView
import com.github.mrpaulblack.personalrecipes.ui.recipeslist.RecipesListView
import com.github.mrpaulblack.personalrecipes.ui.search.SearchView
import com.github.mrpaulblack.personalrecipes.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppTheme {
                Scaffold(
                    bottomBar = { NavBar.Content(
                        currentRoute = navController.currentBackStackEntryAsState(),
                        onClick = { route -> navController.navigateSingleTop(route) }
                    )}
                ) { paddingValues ->
                    NavHost(navController, startDestination = RecipesListView.route) {
                        // search view on navbar
                        composable(SearchView.route) { SearchView.Content(
                            onClick = { route -> navController.navigate(route) },
                            modifier = Modifier.padding(paddingValues)
                        )}
                        // recipe list on navbar
                        composable(RecipesListView.route) { RecipesListView.Content(
                            onClick = { route -> navController.navigate(route) },
                            modifier = Modifier.padding(paddingValues)
                        )}
                        // recipe detail view for a specific recipe
                        composable(
                            route = "${RecipeView.route}/{recipeName}",
                            arguments = listOf(navArgument("recipeName") { type = NavType.StringType })
                        ) { backStackEntry ->
                            RecipeView.Content(
                                onBack = { navController.popBackStack() },
                                backStackEntry = backStackEntry,
                                modifier = Modifier.padding(paddingValues)
                            )
                        }
                    }
                }
            }
        }
    }
}

// NavController extension
// this prevents opening the same route multiple times on the stack
fun NavHostController.navigateSingleTop(route: String) =
    this.navigate(route) { launchSingleTop = true }
