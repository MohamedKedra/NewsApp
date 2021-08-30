package com.example.newsapp.data.model

data class HeadlinesResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)