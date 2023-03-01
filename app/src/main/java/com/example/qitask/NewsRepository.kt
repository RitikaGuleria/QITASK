package com.example.qitask

import com.example.example.Articles
import com.example.example.ExampleJson2KtKotlin
import com.example.qitask.model.api.NewsAPI


class NewsRepository(private val webservice:NewsAPI = NewsAPI()) {

    private var cachedNews= listOf<Articles>()

    suspend fun getNews(): ExampleJson2KtKotlin
    {
        val response=webservice.getNews()
        cachedNews=response.articles
        return response
    }
    fun getNew(id:String): Articles {
        return cachedNews.first(){
            it.source?.id==id
        }
    }
    companion object{
        @Volatile
        private var instance: NewsRepository?=null
        fun getInstance()= instance?: synchronized(this){
            instance ?: NewsRepository().also { instance=it }
        }
    }
}