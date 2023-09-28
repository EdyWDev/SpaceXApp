package com.example.spacexapp.ui.theme.allLaunches.model

import com.google.gson.annotations.SerializedName

data class AllLaunchesDTO (
    @SerializedName("flight_number")
    val flightNumber: String,
    @SerializedName("mission_name")
    val missionName: String,
    @SerializedName("launch_year")
    val launchYear: String,
    @SerializedName("launch_date_local")
    val launchDateLocal: String,
    val rocket: RocketAllLaunchesDTO,
    @SerializedName("launch_site")
    val launchSite: LaunchSiteAllLaunchesDTO,
    val details: String,
    val links: LinksAllLaunchesDTO,
        )