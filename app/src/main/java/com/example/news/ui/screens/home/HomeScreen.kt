package com.example.news.ui.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.news.ui.theme.NewsTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val homeViewModel = HomeViewModel()
    val news by homeViewModel.news.collectAsState()

    LaunchedEffect(true) {
        homeViewModel.getNews()
    }

    LazyColumn(modifier = modifier) {
        items(news) { article ->
            Text(text = article.title ?: "")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    NewsTheme {
        HomeScreen()
    }
}