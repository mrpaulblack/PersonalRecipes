package com.github.mrpaulblack.personalrecipes.ui.recipeslist

import androidx.lifecycle.ViewModel
import com.github.mrpaulblack.personalrecipes.data.IRepository

class RecipesListViewModel(
    private val data: IRepository
) : ViewModel() {
    val recipesList = data.firebaseGetOverview()
}
