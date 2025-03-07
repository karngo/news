package com.example.news.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("everything?apiKey=0eb2d7c262e643c19c5d5dda39945dae")
    suspend fun getNews(
        @Query("q") topic: String,
        @Query("from") date: String,
        @Query("sortBy") sortBy: String
    ): Response<NewsResponse>
}