package com.github.mrpaulblack.personalrecipes.repository

class RecepiesOverviewListModel {
    var recepies: MutableList<RecepiesDetailedModel> = mutableListOf<RecepiesDetailedModel>()
}

class RecepiesDetailedModel {
    var calories: Int = 0
    var totalWeight: Int = 0
    var image: String = ""
    var label: String = ""
    var source: String = ""
    var uri: String = ""
    var healthLabels: List<String> = listOf()
    var tools: List<String> = listOf()
    var dietLabels: List<String> = listOf()
    var cautions: List<String> = listOf()
    //var ingredients: List<IngredientsModel> = listOf()
}

class IngredientsModel {
    var quantity: Double = 0.0
    var weight: Double = 0.0
    var text: String = ""
    var image: String = ""
    var measure: String = ""
    var foodId: String = ""
    var foodCategory: String = ""
    var food: String = ""
}