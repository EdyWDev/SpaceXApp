package com.example.spacexapp.ui.theme.service

import com.example.spacexapp.ui.theme.allLaunches.model.*
import com.example.spacexapp.ui.theme.history.model.HistoryDTO
import com.example.spacexapp.ui.theme.history.model.HistoryModel
import com.example.spacexapp.ui.theme.history.model.LinksModel
import com.example.spacexapp.ui.theme.missions.model.MissionsDTO
import com.example.spacexapp.ui.theme.missions.model.MissionsModel
import com.example.spacexapp.ui.theme.rocket.model.*
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

    suspend fun getRocket(): List<RocketModel> =
        withContext(Dispatchers.IO){
            spaceXService.getRocketModel(url = ROCKET).map { it.toDomainRocketsModel() }
        }
    }

fun RocketDTO.toDomainRocketsModel(): RocketModel{
    return RocketModel(
        rocketName = rocketName,
        description = description,
        height = RocketHeightModel(
            feet = this.height.feet,
            meters = this.height.meters
        ),
        mass = RocketMassModel(
            kg = this.mass.kg,
            lb = this.mass.lb
        ),
        firstFlight = this.firstFlight,
        company = this.company,
        country = this.country,
        rocketType = this.rocketType,
        costPerLaunch = this.costPerLaunch,
        rocketID = this.rocketID,
        wikipediaURL = this.wikipediaURL,
        landingLegs = LandingLegsModel(
            numberLandingLegs = this.landingLegs?.numberLandingLegs,
            materialLandingLegs = this.landingLegs?.materialLandingLegs
        ),
        active = this.active,
        flickrImages = this.flickrImages
        )
}

fun AllLaunchesDTO.toDomainAllLaunchesModel(): AllLaunchesModel {
    return AllLaunchesModel(
        flightNumber = this.flightNumber,
        missionName = this.missionName,
        launchYear = this.launchYear,
        launchDateLocal = this.launchDateLocal,
        rocket = RocketAllLaunchesModel(
            rocketName = this.rocket.rocketName,
            rocketType = this.rocket.rocketType
        ),
        launchSite = LaunchSiteAllLaunchesModel(
           siteNameLong = this.launchSite.siteNameLong
        ),
        launchSuccess = this.launchSuccess,
        details = this.details,
        links = LinksAllLaunchesModel(
            missionPatchSmall = this.links.missionPatchSmall,
            articleLink = this.links.articleLink,
            videoLink = this.links.videoLink
        )

    )
}


fun UpcomingMissionsDTO.toDomainUpcomingMissionsModel(): UpcomingMissionsModel {
    return UpcomingMissionsModel(
        flightNumber = this.flightNumber,
        missionName = this.missionName,
        launchYear = this.launchYear,
        launchDateLocal = this.launchDateLocal,
        rocketInUpcoming = RocketInUpcomingMissionsModel(
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
private const val ROCKET = "rockets"