package com.github.mrpaulblack.personalrecipes.data.models

data class ImageModel(
    val Large: ImagePropertiesModel = ImagePropertiesModel(),
    val Regular: ImagePropertiesModel = ImagePropertiesModel(),
    val Small: ImagePropertiesModel = ImagePropertiesModel(),
    val Thumbnail: ImagePropertiesModel = ImagePropertiesModel(),
)
