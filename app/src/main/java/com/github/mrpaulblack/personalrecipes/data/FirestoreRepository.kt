package com.github.mrpaulblack.personalrecipes.data

import androidx.lifecycle.MutableLiveData
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

interface IFirebase {
    fun getOverview(): MutableLiveData<List<RecipeModel>>
    fun getDetailedRecipe(mealName: String): MutableLiveData<RecipeModel>
}

class Firebase : IFirebase {
    private val db = Firebase.firestore

    /**
     * @return List Of recipes
     */
    override fun getOverview(): MutableLiveData<List<RecipeModel>> {
        val mld: MutableLiveData<List<RecipeModel>> =
            MutableLiveData<List<RecipeModel>>()

        db.collection("recipes").addSnapshotListener {snapshot, _ ->
            mld.value = snapshot?.mapNotNull {
                it.toObject<RecipeModel>()
            }
        }

        return mld
    }

    /**
     * @param mealName name of a meal
     * @return detailed recipes
     */
    override fun getDetailedRecipe(mealName: String): MutableLiveData<RecipeModel> {
        val mld: MutableLiveData<RecipeModel> =
            MutableLiveData<RecipeModel>()

        db.collection("recipes").document(mealName).addSnapshotListener {snapshot, _ ->
            mld.value = snapshot?.toObject<RecipeModel>()
        }

        return mld
    }
}
