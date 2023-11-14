package com.anahitavakoli.apps.nightell.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("ONLINE_MP3")
    @Expose
    var Artists: List<Artist>
)
