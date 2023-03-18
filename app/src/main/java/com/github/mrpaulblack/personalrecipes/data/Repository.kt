package com.github.mrpaulblack.personalrecipes.data

import androidx.lifecycle.MutableLiveData
import com.github.mrpaulblack.personalrecipes.data.models.RecipesDetailModel

interface IRepository {
    fun firebaseGetOverview(): MutableLiveData<MutableList<RecipesDetailModel>>
    fun firebaseGetDeatiledRecipe(meal: String)
}

class Repository : IRepository {

    private val firebaseDB: IFirebase = Firebase()
    override fun firebaseGetOverview(): MutableLiveData<MutableList<RecipesDetailModel>> {
        return firebaseDB.getOverview();
    }
    override fun firebaseGetDeatiledRecipe(meal: String) {
        return firebaseDB.getDeatiledRecipe(meal);
    }
}
