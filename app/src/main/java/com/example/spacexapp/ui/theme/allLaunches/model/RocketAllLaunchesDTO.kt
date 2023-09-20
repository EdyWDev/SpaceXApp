package com.example.spacexapp.ui.theme.allLaunches.model

import com.google.gson.annotations.SerializedName

data class RocketAllLaunchesDTO (
    @SerializedName("rocket_name")
    val rocketName: String,
    @SerializedName("rocket_type")
    val rocketType: String
        )