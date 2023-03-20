package com.github.mrpaulblack.personalrecipes.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import com.github.mrpaulblack.personalrecipes.data.models.RecipeModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


class Firebase : IRepository {
    private val db = Firebase.firestore


    /**
     * @return List Of recipes
     */
    override fun getOverview(): MutableState<List<RecipeModel>> {
        val mld: MutableState<List<RecipeModel>> =
            mutableStateOf(listOf ())

        db.collection("recipes").addSnapshotListener {snapshot, _ ->
            mld.value = snapshot?.mapNotNull {
                it.toObject<RecipeModel>()
            } ?: listOf()
        }

        return mld
    }


    /**
     * @param meal name of a meal
     * @return detailed recipes
     */
    override fun getDetailedRecipe(meal: String): MutableState<RecipeModel> {
        val mld: MutableState<RecipeModel> =
            mutableStateOf(RecipeModel())

        db.collection("recipes").document(meal).addSnapshotListener {snapshot, _ ->
            mld.value = snapshot?.toObject<RecipeModel>() ?: RecipeModel()
        }

        return mld
    }

    /**
     * @param query Search query for names of recipes
     * @return List of Recipes that contain the given query
     */
    override fun queryRecipe(query: MutableState<TextFieldValue>): MutableState<List<RecipeModel>> {
        val mld: MutableState<List<RecipeModel>> =
            mutableStateOf(listOf ())

        db.collection("recipes").orderBy("label").startAt(query.value.text).endAt(query.value.text + '~')
                // FB DB supports some query but i didn't get a partial word search to work
            .addSnapshotListener {snapshot, _ ->
            mld.value = snapshot?.mapNotNull {
                it.toObject<RecipeModel>()
            } ?: listOf()
        }

        return mld
    }
}
