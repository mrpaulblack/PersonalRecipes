package com.github.mrpaulblack.personalrecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.mrpaulblack.personalrecipes.ui.counter.CounterView
import com.github.mrpaulblack.personalrecipes.ui.main.MainView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold {
                NavHost(navController, startDestination = MainView.route) {
                    composable(MainView.route) { MainView.Content { newScreen -> navController.navigate(newScreen) } }
                    composable(CounterView.route) { CounterView.Content() }
                }
            }
        }
    }
}
