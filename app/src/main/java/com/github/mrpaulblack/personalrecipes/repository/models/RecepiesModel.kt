package com.github.mrpaulblack.personalrecipes.repository

class RecepiesOverviewListModel {
    var recepies: MutableList<RecepiesDetailedModel> = mutableListOf<RecepiesDetailedModel>()
}

data class RecepiesDetailedModel(
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
