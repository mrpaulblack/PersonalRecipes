package com.github.mrpaulblack.personalrecipes.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object HomeView {
    const val route: String = "home"
    @Composable
    fun Content(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Text(text = "Welcome!")
        }
    }
}
