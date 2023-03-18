package com.github.mrpaulblack.personalrecipes.data

import androidx.lifecycle.MutableLiveData
import com.github.mrpaulblack.personalrecipes.data.models.RecepiesOverviewListModel

interface IRepository {
    fun firebaseGetOverview(): MutableLiveData<RecepiesOverviewListModel>
    fun firebaseGetDeatiledRecipe(meal: String)
}

class Repository : IRepository {

    private val firebaseDB: IFirebase = Firebase()
    override fun firebaseGetOverview(): MutableLiveData<RecepiesOverviewListModel> {
        return firebaseDB.getOverview();
    }
    override fun firebaseGetDeatiledRecipe(meal: String) {
        return firebaseDB.getDeatiledRecipe(meal);
    }
}
