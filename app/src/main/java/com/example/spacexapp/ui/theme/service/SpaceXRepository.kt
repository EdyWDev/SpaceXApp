package com.example.spacexapp.ui.theme.service

import com.example.spacexapp.ui.theme.history.model.LinksModel
import com.example.spacexapp.ui.theme.history.model.SpaceXHistory
import com.example.spacexapp.ui.theme.missions.model.MissionsDTO
import com.example.spacexapp.ui.theme.missions.model.SpaceXMissions
import com.example.spacexapp.ui.theme.history.model.HistoryDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SpaceXRepository(
    private val spaceXService: SpaceXService
) {
    suspend fun getSpaceXHistory(): List<SpaceXHistory> =
        withContext(Dispatchers.IO) {
            spaceXService.getHistoryDetails(url = HISTORY).map { it.toDomainHistoryModel() }
        }
    suspend fun getMissionsDetails(): List<SpaceXMissions> =
        withContext(Dispatchers.IO) {
            spaceXService.getMissionsDetails(url = MISSION).map { it.toDomainMissionModel() }
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

fun MissionsDTO?.toDomainMissionModel(): SpaceXMissions {
    return SpaceXMissions(
        name = this?.name,
        id = this?.id,
        wikipedia = this?.wikipedia,
        website = this?.website,
        description = this?.description
    )
}

private const val HISTORY = "history"
private const val MISSION = "missions"