package com.example.spacexapp.ui.theme.upcomingmissions

import com.example.spacexapp.ui.theme.upcomingmissions.model.UpcomingMissionsModel

data class UpcomingMissionsViewState (
    val upcomingMissionsList: List<UpcomingMissionsModel> = emptyList()
        )