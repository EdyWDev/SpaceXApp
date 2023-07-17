package com.example.spacexapp.ui.theme.service

import com.example.spacexapp.ui.theme.history.model.LinksModel
import com.example.spacexapp.ui.theme.history.model.SpaceXHistory
import com.example.spacexapp.ui.theme.service.model.HistoryDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HistoryRepository(
    private val spaceXService: SpaceXService
) {
    suspend fun getSpaceXHistory(): List<SpaceXHistory> =
        withContext(Dispatchers.IO) {
            spaceXService.getHistoryDetails(url = HISTORY).map { it.toDomainHistoryModel() }
        }
}

fun HistoryDTO?.toDomainHistoryModel(): SpaceXHistory {
    return SpaceXHistory(
            id = this?.id,
            title = this?.title,
            eventData = this?.eventData,
            flightNumber = this?.flightNumber,
            details = this?.details,
            links = LinksModel(
                reddit = this?.links?.reddit,
                wikipedia = this?.links?.wikipedia,
                article = this?.links?.article
            )
        )
    }

private const val HISTORY = "history"