package com.example.newsapp.data.repository

import com.example.newsapp.data.model.HeadlinesResponse
import com.example.newsapp.data.network.NewsServices
import io.reactivex.Single

abstract class NewsRepository(protected val newsServices: NewsServices) {


    abstract fun getTopHeadlines(): Single<HeadlinesResponse>
}