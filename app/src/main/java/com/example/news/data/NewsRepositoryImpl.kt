package com.example.news.data

class NewsRepositoryImpl(private val apiService: ApiService) : NewsRepository {
    override suspend fun getAllNews(): List<Article> {
        val response = apiService.getNews("Apple", "2025-03-06", "popularity")

        return if (response.isSuccessful) response.body()?.articles ?: emptyList()
        else emptyList()
    }
}
