package com.github.mrpaulblack.personalrecipes.data.models

data class RecipeModel(
    val Images: ImageModel = ImageModel(),
    var calories: Double = 0.0,
    val cautions: List<String> = listOf(),
    val dietLabels: List<String> = listOf(),
    val healthLabels: List<String> = listOf(),
    var image: String = "",
    val ingredients: List<IngredientsModel> = listOf(),
    var label: String = "",
    var source: String = "",
    var sourceUrl: String = "",
    val tools: List<String> = listOf(),
    var totalWeight: Double = 0.0,
    var uri: String = ""
)
