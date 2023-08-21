package com.example.spacexapp.ui.theme.upcomingmissions.model

import com.google.gson.annotations.SerializedName

class UpcomingMissionsDTO (
    @SerializedName("flight_number")
    val flightNumber: String,
    @SerializedName("mission_name")
    val missionName: String,
    @SerializedName("launch_year")
    val launchYear : String,
    @SerializedName("launch_date_local")
    val launchDateLocal: String,
    @SerializedName("rocket")
    val rocketInUpcoming: RocketDTO,
    @SerializedName("launch_site")
    val launchSite: LaunchSiteDTO,
    val links: LinksDTO,
    val details: String,
    @SerializedName("last_date_update")
    val lastDateUpdate: String
)