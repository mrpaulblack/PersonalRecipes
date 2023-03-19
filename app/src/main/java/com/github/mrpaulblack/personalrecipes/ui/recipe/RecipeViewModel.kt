package com.github.mrpaulblack.personalrecipes.ui.recipe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mrpaulblack.personalrecipes.data.IRepository
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel


class RecipeViewModel(
    private val data: IRepository
): ViewModel() {
    var recipe: MutableLiveData<RecipeModel> = MutableLiveData(RecipeModel())


    fun setRecipe(recipeName: String) {
        recipe = data.getDetailedRecipe(recipeName)
    }
}
