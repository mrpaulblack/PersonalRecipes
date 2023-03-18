package com.github.mrpaulblack.personalrecipes.data.models

data class RecipesDetailModel(
    var calories: Int = 0,
    var totalWeight: Int = 0,
    var image: String = "",
    var label: String = "",
    var source: String = "",
    var uri: String = "",
    val healthLabels: List<String> = listOf(),
    val tools: List<String> = listOf(),
    val dietLabels: List<String> = listOf(),
    val cautions: List<String> = listOf()
)
