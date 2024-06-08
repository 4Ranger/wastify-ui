package com.capstone.wastify.api.retrofit

import com.capstone.wastify.api.response.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("Authorization: token 778b51c9fda6417d8eece26ba0e2d706")
    @GET("top-headlines")
    fun getNews(
        @Query("q") q: String,
        @Query("language") language: String,
        @Query("apiKey") apiKey: String
    ): Call<NewsResponse>
}