package com.example.spacexapp.ui.theme.allLaunches.model

import com.google.gson.annotations.SerializedName

data class AllLaunchesDTO (
    @SerializedName("flight_number")
    val flightNumber: String,
    @SerializedName("mission_name")
    val missionName: String,
    @SerializedName("launch_date_local")
    val launchDateLocal: String
        )