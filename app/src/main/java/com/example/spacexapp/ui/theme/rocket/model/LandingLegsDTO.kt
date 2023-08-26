package com.example.spacexapp.ui.theme.rocket.model

import com.google.gson.annotations.SerializedName

data class LandingLegsDTO (
    @SerializedName("number")
    val numberLandingLegs: String?,
    @SerializedName("material")
    val materialLandingLegs: String?
        )