package com.github.mrpaulblack.personalrecipes.data

import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.mrpaulblack.personalrecipes.data.models.RecipesDetailModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

interface IFirebase {
    fun getOverview(): MutableLiveData<MutableList<RecipesDetailModel>>
    fun getDeatiledRecipe(mealName: String)
}

class Firebase : IFirebase {
    private val db = Firebase.firestore
    private var mld: MutableLiveData<MutableList<RecipesDetailModel>> =
        MutableLiveData<MutableList<RecipesDetailModel>>()

    /**
     * @return List Of recipes
     */
    override fun getOverview(): MutableLiveData<MutableList<RecipesDetailModel>> {
        //val docRef = db.collection("recipes").document("Chicken Noodle Soup")
        val docRef = db.collection("recipes")
            .get()
            .addOnSuccessListener { result ->
                var recepiesOverviewList = mutableListOf<RecipesDetailModel>()
                for (document in result) {
                    if (document.data != null) {
                        Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                        var recipe: RecipesDetailModel = RecipesDetailModel()
                        if (recipe != null) {
                            recipe = document.toObject<RecipesDetailModel>()!!
                            recepiesOverviewList.add(recipe)
                        }
                    }
                }
                mld.value = recepiesOverviewList
            }
        return mld
    }

    /**
     * @param Exact name of a meal
     * @return Deatiled recipes
     */
    override fun getDeatiledRecipe(mealName: String) {
        val docRef = db.collection("recipes").document(mealName)
            .get()
            .addOnSuccessListener { document ->
                if (document.data != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                    var recipe: RecipesDetailModel = RecipesDetailModel()
                    if (recipe != null) {
                        recipe = document.toObject<RecipesDetailModel>()!!
                        println(recipe)
                    }
                }
                // Set the MutableLiveData here
            }
    }
}
