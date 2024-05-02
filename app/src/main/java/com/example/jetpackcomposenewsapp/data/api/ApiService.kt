package com.example.jetpackcomposenewsapp.data.api

import com.example.jetpackcomposenewsapp.data.entity.NewsResponse
import com.example.jetpackcomposenewsapp.ui.viewmodel.NewsViewModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // Goto https://newsapi.org/ to get your key and add it to here

    @GET("v2/top-headlines")
   suspend fun getNewsHeadline(
            @Query("country") country: String, @Query("apiKey") apiKey: String = ""
    ): Response<NewsResponse>
}

