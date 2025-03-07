package com.example.news

import com.example.news.data.NewsRepository
import com.example.news.data.NewsRepositoryImpl
import com.example.news.data.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Dependency {
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    fun getNewsRepository(): NewsRepository = NewsRepositoryImpl(apiService)
}
