package com.github.mrpaulblack.personalrecipes.data

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.MutableLiveData
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel


class Repository : IRepository {
    private val firebaseDB: IRepository = Firebase()


    override fun getOverview(): MutableLiveData<List<RecipeModel>> {
        return firebaseDB.getOverview()
    }


    override fun getDetailedRecipe(meal: String): MutableLiveData<RecipeModel> {
        return firebaseDB.getDetailedRecipe(meal)
    }


    override fun queryRecipe(query: MutableState<TextFieldValue>): MutableLiveData<List<RecipeModel>> {
        return firebaseDB.queryRecipe(query)
    }
}
