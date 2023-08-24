package com.example.spacexapp.ui.theme.rocket.model

import com.google.gson.annotations.SerializedName

data class RocketDTO (
    @SerializedName("rocket_name")
    val rocketName: String,
    val description: String,
    val height: RocketHeightDTO
        )