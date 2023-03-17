package com.github.mrpaulblack.personalrecipes.ui.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment

object CounterView {
    private val viewModel = CounterViewModel()

    @Composable
    fun Content() {
        // define State<T> for recomposition
        // needs to be defined inside @composable or setContent{}
        val counter: Int by viewModel.counter.observeAsState(initial = 0)

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { viewModel.onCounterClicked() }) {
                Text("COUNT")
            }
            Text(counter.toString())
        }
    }
}
