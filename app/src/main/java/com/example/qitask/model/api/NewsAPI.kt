package com.example.qitask.model.api

import com.example.example.ExampleJson2KtKotlin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class NewsAPI {
    private lateinit var api:Newsapi
    init {
        val retrofit= Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api=retrofit.create(Newsapi::class.java)
    }
    //retrofit supports coroutines

    suspend fun getNews(): ExampleJson2KtKotlin{
        return api.getNews()
    }
    //interface
    interface Newsapi{
        @GET("v2/top-headlines?country=us&apiKey=daf1027326c64fffbcf2e0f48e7f5cb3")
        suspend fun getNews(): ExampleJson2KtKotlin
    }
}