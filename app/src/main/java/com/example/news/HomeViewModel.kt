package com.example.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _news = MutableStateFlow<List<Article>>(emptyList())
    val news: StateFlow<List<Article>> = _news

    fun getNews() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = ApiInstance.service.getNews()

            response.articles?.let {
                _news.value = it
            }
        }
    }
}