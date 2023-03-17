package com.github.mrpaulblack.personalrecipes.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import com.github.mrpaulblack.personalrecipes.ui.counter.CounterView
import com.github.mrpaulblack.personalrecipes.ui.home.HomeView

object NavBar {
    private val navBarItems = listOf(
        NavBarItem(
            name = "Home",
            route = HomeView.route,
            icon = Icons.Default.Home
        ),
        NavBarItem(
            name = "Counter",
            route = CounterView.route,
            icon = Icons.Default.Calculate
        )
    )

    @Composable
    fun Content() {
        //define content
    }
}
