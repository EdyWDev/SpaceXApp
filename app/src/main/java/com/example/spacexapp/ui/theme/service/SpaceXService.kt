package com.example.spacexapp.ui.theme.service

import com.example.spacexapp.ui.theme.service.model.HistoryDTO
import retrofit2.http.GET
import retrofit2.http.Url


interface SpaceXService {
    @GET
    suspend fun getHistoryDetails(@Url url: String): List<HistoryDTO>
}
