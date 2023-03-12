package com.github.mrpaulblack.personalrecipes.repository

import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


interface FetchDatabase {
    fun fetchDatabase(): List<String>
}

class Database: FetchDatabase {
    // in contructor : connectin to firebase sdk

    override fun  fetchDatabase() : List<String> {
        val db = Firebase.firestore
        val docRef = db.collection("test").document("test")
        docRef.get()
                // Here it gets Async
            .addOnSuccessListener { document ->
                if (document != null) {
                    // Set the data here
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }

        return listOf("BUG", "DE");
    }
}

////////////////////////////////////////////////////