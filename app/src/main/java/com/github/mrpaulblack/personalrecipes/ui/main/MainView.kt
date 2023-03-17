package com.github.mrpaulblack.personalrecipes.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.github.mrpaulblack.personalrecipes.ui.counter.CounterView

object MainView {
    const val route: String = "main"
    @Composable
    fun Content(onClick: (newScreen: String) -> Unit) {
        Column {
            Text(text = "Welcome!")
            Button(onClick = { onClick(CounterView.route) }) {
                Text(text = "Continue")
            }
        }
    }
}
