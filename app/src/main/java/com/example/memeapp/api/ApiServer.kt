package com.example.memeapp.api

import com.example.memeapp.model.MemeList
import retrofit2.Call
import retrofit2.http.GET

interface ApiServer {

    @GET("gimme")
    fun getData() : Call<MemeList>

}