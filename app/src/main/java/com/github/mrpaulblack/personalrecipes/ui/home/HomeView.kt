package com.github.mrpaulblack.personalrecipes.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

object HomeView {
    const val route: String = "home"
    @Composable
    fun Content() {
        Column {
            Text(text = "Welcome!")
        }
    }
}
