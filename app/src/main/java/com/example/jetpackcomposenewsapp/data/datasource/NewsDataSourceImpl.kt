package com.example.jetpackcomposenewsapp.data.datasource

import com.example.jetpackcomposenewsapp.data.api.ApiService
import com.example.jetpackcomposenewsapp.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource {

    override suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadline(country)
    }
}