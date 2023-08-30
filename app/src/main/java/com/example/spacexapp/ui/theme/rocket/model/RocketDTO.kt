package com.example.spacexapp.ui.theme.rocket.model

import com.google.gson.annotations.SerializedName
import java.net.URL

data class RocketDTO (
    @SerializedName("rocket_name")
    val rocketName: String,
    val description: String,
    val height: RocketHeightDTO,
    val mass: RocketMassDTO,
    @SerializedName("first_flight")
    val firstFlight: String,
    val company: String,
    val country: String,
    @SerializedName("rocket_type")
    val rocketType: String,
    @SerializedName("cost_per_launch")
    val costPerLaunch: String,
    @SerializedName("rocket_id")
    val rocketID: String,
    @SerializedName("flickr_images")
    val flickrImages: List<String>,
    @SerializedName("wikipedia")
    val wikipediaURL: String,
    @SerializedName("landing_legs")
    val landingLegs: LandingLegsDTO?,
    val active: String

    )