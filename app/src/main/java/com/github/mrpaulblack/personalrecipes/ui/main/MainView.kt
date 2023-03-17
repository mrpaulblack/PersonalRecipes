package com.github.mrpaulblack.personalrecipes.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

object MainView {
    @Composable
    fun Content(navController: NavController) {
        Column {
            Text(text = "Welcome!")
            Button(onClick = { navController.navigate("counter") }) {
                Text(text = "Continue")
            }
        }
    }
}
