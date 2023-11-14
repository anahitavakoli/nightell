package com.anahitavakoli.apps.nightell.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    var retrofit: Retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://apps.anahitavakoli.com/nightell/").build()
}