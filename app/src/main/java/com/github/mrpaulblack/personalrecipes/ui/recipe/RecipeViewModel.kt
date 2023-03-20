package com.github.mrpaulblack.personalrecipes.ui.recipe

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.github.mrpaulblack.personalrecipes.data.IRepository
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel


class RecipeViewModel(
    private val data: IRepository
): ViewModel() {
    var recipe: MutableState<RecipeModel> = mutableStateOf(RecipeModel())


    fun setRecipe(recipeName: String) {
        recipe = data.getDetailedRecipe(recipeName)
    }
}
