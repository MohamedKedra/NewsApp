package com.example.newsapp.data.network

import com.example.newsapp.data.model.HeadlinesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsServices {

    @GET("/top-headlines")
    fun getTopHeadlines(
        @Query("apiKey") key: String,
        @Query("country") country: String,
    ): Single<HeadlinesResponse>
}