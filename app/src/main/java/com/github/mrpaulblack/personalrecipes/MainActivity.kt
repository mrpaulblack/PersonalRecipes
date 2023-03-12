package com.github.mrpaulblack.personalrecipes

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.mrpaulblack.personalrecipes.ui.counter.CounterView
import com.github.mrpaulblack.personalrecipes.ui.home.HomeView
import com.github.mrpaulblack.personalrecipes.ui.nav.NavBar
import com.github.mrpaulblack.personalrecipes.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppTheme {
                Scaffold(
                    topBar = { TopAppBar(title = { Text(navController.currentBackStackEntryAsState().value?.destination?.route ?: "Personal Recipes")}) },
                    bottomBar = { NavBar.Content(
                        currentRoute= navController.currentBackStackEntryAsState(),
                        onClick = { route -> navController.navigateSingleTop(route) }
                    ) }
                ) {
                    NavHost(navController, startDestination = HomeView.route) {
                        composable(HomeView.route) { HomeView.Content() }
                        composable(CounterView.route) { CounterView.Content() }
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

data class Message(val author: String, val body: String)
data class Recipe(val title: String, val text: String)

@Composable
fun RecipesGrid(amount: Int) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .padding(
                start = 12.dp,
                end = 12.dp,
                top = 12.dp,
                bottom = 12.dp
            )
    ) {
        items(amount) { i ->
            RecipeCard(Recipe("YumYum", "Schmackofatz"))
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeCard(rec: Recipe) {
    ElevatedCard(
        onClick = { /* Do something */ },
        modifier = Modifier.size(width = 180.dp, height = 250.dp)

    ) {
        Box(Modifier.fillMaxSize()) {
            Column {
                Image(
                    painter = painterResource(R.drawable.testpic),
                    contentDescription = "test picture",
                    modifier = Modifier
                        .size(180.dp)
                        .clip(CircleShape)

                )
                Row() {
                    Spacer(modifier = Modifier.width(8.dp))
                    Column() {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = rec.title)
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = rec.text)
                    }

                }

            }
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
        RecipesGrid(10)
}



