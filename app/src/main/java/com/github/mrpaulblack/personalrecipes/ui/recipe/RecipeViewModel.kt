package com.github.mrpaulblack.personalrecipes.ui.recipe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mrpaulblack.personalrecipes.data.IRepository
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel

class RecipeViewModel(
    private val data: IRepository
): ViewModel() {
    fun getRecipe(recipeName: String): MutableLiveData<RecipeModel> {
        return data.firebaseGetDetailedRecipe(recipeName)
    }
}
