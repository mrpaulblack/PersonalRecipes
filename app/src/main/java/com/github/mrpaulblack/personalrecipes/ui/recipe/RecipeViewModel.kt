package com.github.mrpaulblack.personalrecipes.ui.recipe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel

class RecipeViewModel: ViewModel() {
    var recipe = MutableLiveData(RecipeModel())
}
