package com.example.news.data

data class NewsResponse(
    val articles: List<Article>? = null,
    val status: String? = null,
    val totalResults: Int? = null
)

data class Article(
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val source: Source? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null
)

data class Source(
    val id: String? = null,
    val name: String? = null
)
