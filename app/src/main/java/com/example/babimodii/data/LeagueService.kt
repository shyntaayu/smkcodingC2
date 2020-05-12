package com.example.babimodii.data

import com.example.babimodii.model.League
import retrofit2.Call
import retrofit2.http.GET

interface LeagueService {
    @GET("all_leagues.php")
    fun getLeagues(): Call<League>
}