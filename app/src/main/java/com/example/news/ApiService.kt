package com.example.news

import retrofit2.http.GET

interface ApiService {
    @GET("everything?q=Apple&from=2025-03-06&sortBy=popularity&apiKey=<key>")
    suspend fun getNews(): NewsResponse
}