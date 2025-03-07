package com.example.news.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.news.ui.theme.NewsTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val homeViewModel = HomeViewModel()
    val news by homeViewModel.news.collectAsState()

    LaunchedEffect(true) {
        homeViewModel.getNews()
    }

    LazyColumn(modifier = modifier.padding(12.dp)) {
        items(news) { article ->
            Column(
                modifier = Modifier
                    .border(BorderStroke(1.dp, SolidColor(Color.Blue)))
                    .padding(12.dp)
            ) {
                Text(text = article.title ?: "", fontWeight = FontWeight.Bold)
                Text(text = article.description ?: "")
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun HomePreview() {
    NewsTheme {
        HomeScreen()
    }
}