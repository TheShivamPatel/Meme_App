package com.example.memeapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitHelper {

    private val BASE_URL = "https://meme-api.com/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiInterface by lazy {
        retrofit.create(ApiServer::class.java)
    }

}