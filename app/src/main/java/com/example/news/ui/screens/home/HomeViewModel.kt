package com.example.news.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.Article
import com.example.news.Dependency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _news = MutableStateFlow<List<Article>>(emptyList())
    val news: StateFlow<List<Article>> = _news

    private val newsRepository = Dependency.getNewsRepository()

    fun getNews() {
        viewModelScope.launch(Dispatchers.IO) {
            _news.value = newsRepository.getAllNews()
        }
    }
}