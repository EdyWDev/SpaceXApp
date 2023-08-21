package com.example.spacexapp.ui.theme.upcomingmissions.model

import com.google.gson.annotations.SerializedName

data class LinksDTO (
    @SerializedName("mission_patch")
    val missionsPatch: String,
    @SerializedName("mission_patch_small")
    val missionsPatchSmall: String,
    @SerializedName("reddit_campaign")
    val redditCampaign: String
)