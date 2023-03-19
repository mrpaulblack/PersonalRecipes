package com.github.mrpaulblack.personalrecipes.ui.search

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mrpaulblack.personalrecipes.data.IRepository
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel

class SearchViewModel(
    private val data: IRepository
) : ViewModel() {
    fun query(meal: MutableState<TextFieldValue>): MutableLiveData<List<RecipeModel>> {
        return data.firebaseQueryRecipe(meal)
    }
}
