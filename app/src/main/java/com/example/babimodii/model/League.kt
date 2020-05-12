package com.example.babimodii.model


import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("leagues")
    val leagues: List<LeagueX>
)