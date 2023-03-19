package com.github.mrpaulblack.personalrecipes.ui.recipe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mrpaulblack.personalrecipes.data.IRepository
import com.github.mrpaulblack.personalrecipes.data.Repository
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel

class RecipeViewModel(): ViewModel() {
    private val data: IRepository = Repository()

    fun getRecipe(recipeName: String): MutableLiveData<RecipeModel> {
        return data.firebaseGetDetailedRecipe(recipeName)
    }
}
