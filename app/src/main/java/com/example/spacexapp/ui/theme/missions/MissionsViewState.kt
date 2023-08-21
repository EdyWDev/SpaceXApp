package com.example.spacexapp.ui.theme.missions

import com.example.spacexapp.ui.theme.missions.model.MissionsModel

data class MissionsViewState (
    val missionsList: List<MissionsModel> = emptyList()
        )