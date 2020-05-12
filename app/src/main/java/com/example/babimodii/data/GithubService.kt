package com.example.babimodii.data

import com.example.babimodii.GithubUserItem
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("users")
    fun getUsers(): Call<List<GithubUserItem>>
}