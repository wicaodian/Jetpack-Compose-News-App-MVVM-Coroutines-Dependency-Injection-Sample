package com.example.jetpackcomposenewsapp.data.api

import com.example.jetpackcomposenewsapp.data.entity.NewsResponse
import com.example.jetpackcomposenewsapp.ui.viewmodel.NewsViewModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/top-headlines")
   suspend fun getNewsHeadline(
            @Query("country") country: String, @Query("apiKey") apiKey: String = "adb7e971b582499a9a720f4b204b71cd"
    ): Response<NewsResponse>
}

//GET https://newsapi.org/v2/top-headlines?country=us&apiKey=adb7e971b582499a9a720f4b204b71cd
