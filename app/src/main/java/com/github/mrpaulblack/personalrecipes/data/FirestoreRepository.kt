package com.github.mrpaulblack.personalrecipes.data

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.MutableLiveData
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


class Firebase : IRepository {
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


    override fun queryRecipe(query: MutableState<TextFieldValue>): MutableLiveData<List<RecipeModel>> {
        val mld: MutableLiveData<List<RecipeModel>> =
            MutableLiveData<List<RecipeModel>>()

        println(query.value.text) // Like schrödinger's cat -> Only work if we print this line here fsr

        db.collection("recipes")
                // FB DB supports some query but i dident get a partial word search to work
            .addSnapshotListener {snapshot, _ ->
            mld.value = snapshot?.mapNotNull { it ->
                val rec = it.toObject<RecipeModel>()
                rec.takeIf { i -> i.label.lowercase().contains(query.value.text.lowercase()) }
            }
        }

        return mld
    }
}
