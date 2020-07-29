package com.example.jetpack.model

import com.google.gson.annotations.SerializedName

data class DogBreed (
    @SerializedName("id")
    val breedId: String?,

    @SerializedName("name")
    val dogBreed: String?,

    @SerializedName("life_span")
    val lifeSpan: String?,

    @SerializedName("url")
    val imageView: String?
)