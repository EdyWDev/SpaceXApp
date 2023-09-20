package com.example.spacexapp.ui.theme.allLaunches.model

data class AllLaunchesModel (
    val flightNumber: String,
    val missionName: String,
    val launchYear: String,
    val launchDateLocal: String,
    val rocket: RocketAllLaunchesModel,
    val launchSite: LaunchSiteAllLaunchesModel,
    val details: String,
    val links: LinksAllLaunchesModel
        )