package com.example.spacexapp.ui.theme.missions

import com.example.spacexapp.ui.theme.missions.model.SpaceXMissions

data class MissionsViewState (
    val missionsList: List<SpaceXMissions> = emptyList()
        )