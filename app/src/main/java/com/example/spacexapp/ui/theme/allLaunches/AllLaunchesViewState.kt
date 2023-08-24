package com.example.spacexapp.ui.theme.allLaunches

import com.example.spacexapp.ui.theme.allLaunches.model.AllLaunchesModel

data class AllLaunchesViewState (
    val allLaunchesList: List<AllLaunchesModel> = emptyList()
        )