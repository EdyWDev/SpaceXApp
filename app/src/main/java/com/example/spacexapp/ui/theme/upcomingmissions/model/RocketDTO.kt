package com.example.spacexapp.ui.theme.upcomingmissions.model

import com.google.gson.annotations.SerializedName

data class RocketDTO (
    @SerializedName("rocket_id")
    val rocketId: String,
    @SerializedName("rocket_name")
    val rocketName: String,
    @SerializedName("rocket_type")
    val rocketType: String
        )