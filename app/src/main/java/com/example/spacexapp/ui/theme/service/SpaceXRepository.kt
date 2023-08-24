package com.example.spacexapp.ui.theme.service

import com.example.spacexapp.ui.theme.allLaunches.model.AllLaunchesDTO
import com.example.spacexapp.ui.theme.allLaunches.model.AllLaunchesModel
import com.example.spacexapp.ui.theme.history.model.HistoryDTO
import com.example.spacexapp.ui.theme.history.model.HistoryModel
import com.example.spacexapp.ui.theme.history.model.LinksModel
import com.example.spacexapp.ui.theme.missions.model.MissionsDTO
import com.example.spacexapp.ui.theme.missions.model.MissionsModel
import com.example.spacexapp.ui.theme.upcomingmissions.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SpaceXRepository(
    private val spaceXService: SpaceXService
) {
    suspend fun getSpaceXHistory(): List<HistoryModel> =
        withContext(Dispatchers.IO) {
            spaceXService.getHistoryDetails(url = HISTORY).map { it.toDomainHistoryModel() }
        }

    suspend fun getMissionsDetails(): List<MissionsModel> =
        withContext(Dispatchers.IO) {
            spaceXService.getMissionsDetails(url = MISSION).map { it.toDomainMissionModel() }
        }

    suspend fun getUpcomingMissions(): List<UpcomingMissionsModel> =
        withContext(Dispatchers.IO) {
            spaceXService.getUpcomingMissions(url = UPCOMINGMISSIONS)
                .map { it.toDomainUpcomingMissionsModel() }
        }

    suspend fun getAllLaunches(): List<AllLaunchesModel> =
        withContext(Dispatchers.IO) {
            spaceXService.getAllLaunches(url = ALLLAUNCHES).map { it.toDomainAllLaunchesModel() }
        }
}

fun AllLaunchesDTO.toDomainAllLaunchesModel(): AllLaunchesModel {
    return AllLaunchesModel(
        flightNumber = this.flightNumber,
        missionName = this.missionName,
        launchDateLocal = this.launchDateLocal
    )
}


fun UpcomingMissionsDTO.toDomainUpcomingMissionsModel(): UpcomingMissionsModel {
    return UpcomingMissionsModel(
        flightNumber = this.flightNumber,
        missionName = this.missionName,
        launchYear = this.launchYear,
        launchDateLocal = this.launchDateLocal,
        rocketInUpcoming = RocketModel(
            rocketId = this.rocketInUpcoming?.rocketId,
            rocketName = this.rocketInUpcoming?.rocketName,
            rocketType = this.rocketInUpcoming?.rocketType
        ),
        launchSite = LaunchSiteModel(

            siteId = this.launchSite?.siteId,
            siteName = this.launchSite?.siteName,
            siteNameLong = this.launchSite?.siteNameLong
        ),
        links = LinksUpcomingModel(
            missionsPatch = this.links?.missionsPatch,
            missionsPatchSmall = this.links?.missionsPatchSmall,
            redditCampaign = this.links?.redditCampaign
        ),
        details = this.details,
        lastDateUpdate = this.lastDateUpdate

    )
}

fun HistoryDTO?.toDomainHistoryModel(): HistoryModel {
    return HistoryModel(
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

fun MissionsDTO?.toDomainMissionModel(): MissionsModel {
    return MissionsModel(
        name = this?.name,
        id = this?.id,
        wikipedia = this?.wikipedia,
        website = this?.website,
        description = this?.description
    )
}

private const val HISTORY = "history"
private const val MISSION = "missions"
private const val UPCOMINGMISSIONS = "launches/upcoming"
private const val ALLLAUNCHES = "launches"