package com.anahitavakoli.apps.nightell.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LatestAudio(
    @SerializedName("ONLINE_MP3")
    @Expose
    var latestAudio: List<Audio>
)
