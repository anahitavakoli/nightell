package com.anahitavakoli.apps.nightell.network

import com.anahitavakoli.apps.nightell.model.ArtistList
import com.anahitavakoli.apps.nightell.model.IResponse
import com.anahitavakoli.apps.nightell.model.LatestAudio
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiCaller {
    var iService : IService = ApiService.retrofit.create(IService::class.java)

    fun getLatestStory(listener: IResponse<LatestAudio>){
        iService.getLatestAudio().enqueue(object : Callback<LatestAudio>{
            override fun onResponse(call: Call<LatestAudio>, response: Response<LatestAudio>) {
                response.body()?.let { listener.onSuccess(it) }
            }

            override fun onFailure(call: Call<LatestAudio>, t: Throwable) {
                listener.onFailure(t.toString())
            }

        })
    }

    fun getArtists(listener : IResponse<ArtistList>){
        iService.getArtistList().enqueue(object : Callback<ArtistList>{
            override fun onResponse(call: Call<ArtistList>, response: Response<ArtistList>) {
                response.body()?.let { listener.onSuccess(it) }
            }

            override fun onFailure(call: Call<ArtistList>, t: Throwable) {
                listener.onFailure(t.toString())
            }

        })
    }

//    fun getCategories(listener : IResponse<CategoryList>){
//        iService.getCategories().enqueue(object: Callback<CategoryList>{
//            override fun onResponse(call: Call<CategoryList>, response: Response<CategoryList>) {
//                response.body()?.let { listener.onSuccess(it) }
//            }
//
//            override fun onFailure(call: Call<CategoryList>, t: Throwable) {
//                listener.onFailure(t.toString())
//            }
//
//        })
//    }
}