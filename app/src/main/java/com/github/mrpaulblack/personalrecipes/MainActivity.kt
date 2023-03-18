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
import com.github.mrpaulblack.personalrecipes.ui.home.HomeView
import com.github.mrpaulblack.personalrecipes.ui.nav.NavBar
import com.github.mrpaulblack.personalrecipes.ui.recipesoverview.RecipesOverviewView
import com.github.mrpaulblack.personalrecipes.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppTheme {
                Scaffold(
                    topBar = { },
                    bottomBar = { NavBar.Content(
                        currentRoute= navController.currentBackStackEntryAsState(),
                        onClick = { route -> navController.navigateSingleTop(route) }
                    ) }
                ) { paddingValues ->
                    NavHost(navController, startDestination = HomeView.route) {
                        composable(HomeView.route) { HomeView.Content() }
                        composable(CounterView.route) { CounterView.Content() }
                        composable(RecipesOverviewView.route) {RecipesOverviewView.Content(modifier = Modifier.padding(paddingValues))}
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
