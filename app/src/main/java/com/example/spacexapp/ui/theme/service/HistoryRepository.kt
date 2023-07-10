package com.example.spacexapp.ui.theme.service

import com.example.spacexapp.ui.theme.history.model.HistoryDetails
import com.example.spacexapp.ui.theme.history.model.SpaceXHistory
import com.example.spacexapp.ui.theme.service.model.HistoryListDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HistoryRepository(
    private val spaceXService: SpaceXService
) {

    suspend fun getSpaceXHistory(): HistoryDetails =
        withContext(Dispatchers.IO) {
            val url = "https://api.spacexdata.com/v3/"
            spaceXService.getHistoryDetails(url).toDomainHistoryModel()
        }
}

fun HistoryListDTO?.toDomainHistoryModel(): HistoryDetails {
    return HistoryDetails(historyDetails = this?.historyDetails?.map {
        SpaceXHistory(
            id = it.id,
            title = it.title,
            eventData = it.eventData,
            flightNumber = it.flightNumber,
            details = it.details,
            links1 = it.links1,
            links2 = it.links2,
            links3 = it.links3
        )
    }
    )
}

private const val HISTORY = "https://api.spacexdata.com/v3/history"