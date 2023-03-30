package com.example.mytestapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://collectionapi.metmuseum.org/public/collection/v1/"

class RetrofitInitializer {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun metService() = retrofit.create(MetService::class.java)
}