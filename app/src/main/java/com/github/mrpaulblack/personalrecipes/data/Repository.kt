package com.github.mrpaulblack.personalrecipes.data

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.MutableLiveData
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel

interface IRepository {
    fun firebaseGetOverview(): MutableLiveData<List<RecipeModel>>
    fun firebaseGetDetailedRecipe(meal: String): MutableLiveData<RecipeModel>
    fun firebaseQueryRecipe(meal: MutableState<TextFieldValue>): MutableLiveData<List<RecipeModel>>
}

class Repository : IRepository {
    private val firebaseDB: IFirebase = Firebase()

    override fun firebaseGetOverview(): MutableLiveData<List<RecipeModel>> {
        return firebaseDB.getOverview()
    }
    override fun firebaseGetDetailedRecipe(meal: String): MutableLiveData<RecipeModel> {
        return firebaseDB.getDetailedRecipe(meal)
    }
    override fun firebaseQueryRecipe(query: MutableState<TextFieldValue>): MutableLiveData<List<RecipeModel>> {
        return firebaseDB.query(query)
    }
}
