package com.github.mrpaulblack.personalrecipes.ui.nav

import androidx.compose.ui.graphics.vector.ImageVector

data class NavBarItem(
    var name: String,
    var route: String,
    val icon: ImageVector
)
