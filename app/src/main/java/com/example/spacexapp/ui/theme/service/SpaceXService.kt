package com.example.spacexapp.ui.theme.service

import com.example.spacexapp.ui.theme.allLaunches.model.AllLaunchesDTO
import com.example.spacexapp.ui.theme.allLaunches.model.AllLaunchesModel
import com.example.spacexapp.ui.theme.missions.model.MissionsDTO
import com.example.spacexapp.ui.theme.history.model.HistoryDTO
import com.example.spacexapp.ui.theme.upcomingmissions.model.UpcomingMissionsDTO
import retrofit2.http.GET
import retrofit2.http.Url


interface SpaceXService {
    @GET
    suspend fun getHistoryDetails(@Url url: String): List<HistoryDTO>

    @GET
    suspend fun getMissionsDetails(@Url url: String): List<MissionsDTO>

    @GET
    suspend fun getUpcomingMissions(@Url url: String): List<UpcomingMissionsDTO>

    @GET
    suspend fun getAllLaunches(@Url url: String): List<AllLaunchesDTO>
}
