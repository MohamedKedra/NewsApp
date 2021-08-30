package com.example.newsapp.data.network

import com.example.newsapp.utils.EndPoints
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsClient {

    companion object {

        fun getInstance(): NewsServices {

            return Retrofit.Builder()
                .baseUrl(EndPoints.BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(NewsServices::class.java)
        }
    }
}