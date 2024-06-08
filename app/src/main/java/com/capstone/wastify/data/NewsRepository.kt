package com.capstone.wastify.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.capstone.wastify.api.response.ArticlesItem
import com.capstone.wastify.api.response.NewsResponse
import com.capstone.wastify.api.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {

    private val _news = MutableLiveData<List<ArticlesItem?>>()
    val news: LiveData<List<ArticlesItem?>> = _news

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    private fun findNews() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getNews("trash", "en", "778b51c9fda6417d8eece26ba0e2d706")
        client.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _news.postValue(responseBody.articles)
                    }
                } else {
                    Log.e("NewsRepository", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("NewsRepository", "onFailure: ${t.message}")
            }

        })
    }

}