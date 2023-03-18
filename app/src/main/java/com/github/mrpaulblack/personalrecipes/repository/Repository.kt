package com.github.mrpaulblack.personalrecipes.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun firebaseGetOverview(): MutableLiveData<RecepiesOverviewListModel>
    fun firebaseGetDeatiledRecipe(meal: String)
    fun setLocaleStorageData(key: String, value: String)
    fun getLocaleStorageData(key: String): Flow<String?>
}

class Repository(context: Context) : IRepository {
    private val firebaseDB: IFirebase = Firebase()
    private val localeStorage: ILocaleStorage = LocaleStorage(context)

    override fun firebaseGetOverview(): MutableLiveData<RecepiesOverviewListModel> {
        return firebaseDB.getOverview();
    }
    override fun firebaseGetDeatiledRecipe(meal: String) {
        return firebaseDB.getDeatiledRecipe(meal);
    }

    override fun setLocaleStorageData(key: String, value: String) {
        return localeStorage.setData(key, value);
    }
    override fun getLocaleStorageData(key: String): Flow<String?> {
        return localeStorage.getData(key);
    }
}
