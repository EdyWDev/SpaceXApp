package com.example.spacexapp.ui.theme.allLaunches.model

import com.google.gson.annotations.SerializedName

data class LinksAllLaunchesDTO (
    @SerializedName("mission_patch_small")
    val missionPatchSmall: String,
    @SerializedName("article_link")
    val articleLink: String,
    @SerializedName("video_link")
    val videoLink: String
        )