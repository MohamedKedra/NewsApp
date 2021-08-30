package com.example.newsapp.data.repository

import com.example.newsapp.data.model.HeadlinesResponse
import com.example.newsapp.data.network.NewsServices
import com.example.newsapp.utils.EndPoints
import io.reactivex.Single
import kotlinx.coroutines.flow.flow

class NewsRepositoryImpl(newsServices: NewsServices) : NewsRepository(newsServices) {
    override fun getTopHeadlines(): Single<HeadlinesResponse> =
        newsServices.getTopHeadlines(EndPoints.KEY, "us")
}