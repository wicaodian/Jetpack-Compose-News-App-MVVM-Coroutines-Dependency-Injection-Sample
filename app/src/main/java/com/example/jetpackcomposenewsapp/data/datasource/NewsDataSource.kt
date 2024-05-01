package com.example.jetpackcomposenewsapp.data.datasource

import com.example.jetpackcomposenewsapp.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {
  suspend  fun getNewsHeadline(
        country: String,
    ): Response<NewsResponse>
}