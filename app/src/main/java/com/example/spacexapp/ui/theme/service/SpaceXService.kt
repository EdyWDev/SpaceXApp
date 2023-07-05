package com.example.spacexapp.ui.theme.service

import com.example.spacexapp.ui.theme.service.model.HistoryDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Url
import javax.inject.Inject


interface SpaceXService {
    @GET
    suspend fun getHistoryDetails(@Url url: String): HistoryDTO
}
