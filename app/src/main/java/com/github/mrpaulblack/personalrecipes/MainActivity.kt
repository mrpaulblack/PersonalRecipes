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

@Composable
fun MessageCard(msg: Message) {
    Column {
        Image(
            painter = painterResource(R.drawable.testpic),
            contentDescription = "test picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(150.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)

        )

        Spacer(modifier = Modifier.width(8.dp))
        Text(text = msg.author)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = msg.body)
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    ComposeTutorialTheme {
        Surface {
            MessageCard(
                msg = Message("Colleague", "Take a look at Jetpack Compose, it's great!")
            )
        }
    }
}


