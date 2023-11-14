package com.anahitavakoli.apps.nightell.network

import com.anahitavakoli.apps.nightell.model.ArtistList
import com.anahitavakoli.apps.nightell.model.CategoryList
import com.anahitavakoli.apps.nightell.model.LatestAudio
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface IService {

    @GET("api.php?latest")
    fun getLatestAudio(): Call<LatestAudio>

    @GET("api.php?artist_list")
    fun getArtistList(): Call<ArtistList>

    @GET("api.php?cat_list")
    suspend fun getCategories() : Response<CategoryList>
}