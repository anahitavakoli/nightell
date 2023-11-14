package com.anahitavakoli.apps.nightell.model

import com.google.gson.annotations.SerializedName

data class CategoryList(
    @SerializedName("ONLINE_MP3")
    val categories: List<Category>
)
