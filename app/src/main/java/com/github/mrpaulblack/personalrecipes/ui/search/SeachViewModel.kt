package com.github.mrpaulblack.personalrecipes.ui.search

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mrpaulblack.personalrecipes.data.IRepository
import com.github.mrpaulblack.personalrecipes.data.Repository
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel

class FilterdRecipesListViewModel : ViewModel() {
    private val data: IRepository = Repository()

    fun query(meal: MutableState<TextFieldValue>): MutableLiveData<List<RecipeModel>> {
        return data.firebaseQueryRecipe(meal)
    }
}
