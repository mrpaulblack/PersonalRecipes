package com.github.mrpaulblack.personalrecipes.data.models

data class IngredientsModel (
    val quantity: Double = 0.0,
    val weight: Double = 0.0,
    val text: String = "",
    val image: String = "",
    val measure: String = "",
    val foodId: String = "",
    val foodCategory: String = "",
    val food: String = ""
)
