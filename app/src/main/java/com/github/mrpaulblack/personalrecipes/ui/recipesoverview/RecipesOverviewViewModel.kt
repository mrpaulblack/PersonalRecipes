package com.github.mrpaulblack.personalrecipes.ui.recipesoverview

import androidx.lifecycle.ViewModel
import com.github.mrpaulblack.personalrecipes.data.IRepository
import com.github.mrpaulblack.personalrecipes.data.Repository

class RecipesOverviewViewModel : ViewModel() {
    private val data: IRepository = Repository()

    val recipesList = data.firebaseGetOverview()
}
