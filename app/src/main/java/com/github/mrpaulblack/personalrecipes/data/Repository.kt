package com.github.mrpaulblack.personalrecipes.data

import androidx.lifecycle.MutableLiveData
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel

interface IRepository {
    fun firebaseGetOverview(): MutableLiveData<List<RecipeModel>>
    fun firebaseGetDetailedRecipe(meal: String): MutableLiveData<RecipeModel>
}

class Repository : IRepository {
    private val firebaseDB: IFirebase = Firebase()

    override fun firebaseGetOverview(): MutableLiveData<List<RecipeModel>> {
        return firebaseDB.getOverview()
    }
    override fun firebaseGetDetailedRecipe(meal: String): MutableLiveData<RecipeModel> {
        return firebaseDB.getDetailedRecipe(meal)
    }
}
