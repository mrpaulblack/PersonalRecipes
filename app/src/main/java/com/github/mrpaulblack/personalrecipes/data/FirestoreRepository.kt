package com.github.mrpaulblack.personalrecipes.data

import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.mrpaulblack.personalrecipes.data.models.RecepiesOverviewListModel
import com.github.mrpaulblack.personalrecipes.data.models.RecipesDetailModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

interface IFirebase {
    fun getOverview(): MutableLiveData<RecepiesOverviewListModel>
    fun getDeatiledRecipe(mealName: String)
}

class Firebase : IFirebase {
    private val db = Firebase.firestore
    private var mld: MutableLiveData<RecepiesOverviewListModel> =
        MutableLiveData<RecepiesOverviewListModel>()

    /**
     * @return List Of recipes
     */
    override fun getOverview(): MutableLiveData<RecepiesOverviewListModel> {
        //val docRef = db.collection("recipes").document("Chicken Noodle Soup")
        val docRef = db.collection("recipes")
            .get()
            .addOnSuccessListener { result ->
                var recepiesOverviewList = RecepiesOverviewListModel()
                for (document in result) {
                    if (document.data != null) {
                        Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                        var recipe: RecipesDetailModel = RecipesDetailModel()
                        if (recipe != null) {
                            recipe = document.toObject<RecipesDetailModel>()!!
                            recepiesOverviewList.recepies.add(recipe)
                        }
                    }
                }
                // Set the MutableLiveData here
            }
        return mld // Should not be needed
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
