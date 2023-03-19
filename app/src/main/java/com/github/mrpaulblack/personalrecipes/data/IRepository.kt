package com.github.mrpaulblack.personalrecipes.data

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.MutableLiveData
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel


interface IRepository {
    fun getOverview(): MutableLiveData<List<RecipeModel>>
    fun getDetailedRecipe(meal: String): MutableLiveData<RecipeModel>
    fun queryRecipe(query: MutableState<TextFieldValue>): MutableLiveData<List<RecipeModel>>
}
