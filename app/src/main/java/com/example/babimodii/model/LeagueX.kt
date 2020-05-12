package com.example.babimodii.model


import com.google.gson.annotations.SerializedName

data class LeagueX(
    @SerializedName("idLeague")
    val idLeague: String,
    @SerializedName("strLeague")
    val strLeague: String,
    @SerializedName("strLeagueAlternate")
    val strLeagueAlternate: String,
    @SerializedName("strSport")
    val strSport: String
)