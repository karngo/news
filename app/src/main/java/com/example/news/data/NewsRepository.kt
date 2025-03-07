package com.example.news.data

interface NewsRepository {
    suspend fun getAllNews(): List<Article>
}