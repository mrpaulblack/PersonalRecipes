package com.github.mrpaulblack.personalrecipes.ui.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

object CounterView {
    private val viewModel = CounterViewModel()

    const val route: String = "counter"

    @Composable
    fun Content(modifier: Modifier = Modifier) {
        // define State<T> for recomposition
        // needs to be defined inside @composable or setContent{}
        val counter: Int by viewModel.counter.observeAsState(initial = 0)

        Surface(
            modifier = modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { viewModel.onCounterClicked() }) {
                    Text("COUNT")
                }
                Text(
                    text = counter.toString(),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.displayLarge
                )
            }
        }
    }
}
