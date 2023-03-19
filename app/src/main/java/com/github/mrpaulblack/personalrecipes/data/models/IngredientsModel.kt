package com.github.mrpaulblack.personalrecipes.data.models

data class IngredientsModel (
    val food: String = "",
    val foodCategory: String = "",
    val foodId: String = "",
    val image: String = "",
    val measure: String? = "",
    val quantity: Double = 0.0,
    val text: String = "",
    val weight: Double = 0.0
)
