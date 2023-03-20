package com.github.mrpaulblack.personalrecipes.data

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel


interface IRepository {
    fun getOverview(): MutableState<List<RecipeModel>>
    fun getDetailedRecipe(meal: String): MutableState<RecipeModel>
    fun queryRecipe(query: MutableState<TextFieldValue>): MutableState<List<RecipeModel>>
}
