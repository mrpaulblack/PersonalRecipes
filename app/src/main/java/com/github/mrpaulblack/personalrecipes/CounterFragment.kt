package com.github.mrpaulblack.personalrecipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.mrpaulblack.personalrecipes.repository.DatabaseRepository
import com.github.mrpaulblack.personalrecipes.repository.LocaleDatabase

class CounterFragment : Fragment() {
    private val viewModel by viewModels<CounterViewModel>();

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
    : View = ComposeView(requireContext()).apply {
        setContent {
            // define State<T> for recomposition
            // needs to be defined inside @composable or setContent{}
            val counter: Int by viewModel.counter.observeAsState(initial = 0)
            val db: LocaleDatabase = DatabaseRepository()

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { viewModel.onCounterClicked() }) {
                    Text("COUNT")
                    println(db.fetchDatabase()[1] + db.fetchDatabase()[0])
                }
                Text(counter.toString())
            }
        }
    }
}
