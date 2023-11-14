package com.anahitavakoli.apps.nightell.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artist (
    @SerializedName("id")
    val id: String,
    @SerializedName ("artist_name")
    val artistName: String,
    @SerializedName ("artist_image")
    val artistImage: String,
    @SerializedName ("artist_image_thumb")
    val artistImageThumb: String
        ) : Parcelable