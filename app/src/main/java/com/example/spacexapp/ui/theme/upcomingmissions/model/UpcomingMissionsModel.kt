package com.example.spacexapp.ui.theme.upcomingmissions.model

data class UpcomingMissionsModel(
    val flightNumber: String?,
    val missionName: String,
    val launchYear : String,
    val launchDateLocal: String,
    val rocketInUpcoming: RocketModel,
    val launchSite: LaunchSiteModel,
    val links: LinksUpcomingModel,
    val details: String,
    val lastDateUpdate: String
)