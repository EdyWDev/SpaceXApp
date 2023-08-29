package com.example.spacexapp.ui.theme.rocket.model

import com.google.gson.annotations.SerializedName
import java.net.URL

data class RocketModel(
    val rocketName: String,
    val description: String,
    val height: RocketHeightModel,
    val mass: RocketMassModel,
    val firstFlight: String,
    val company: String,
    val country: String,
    val rocketType: String,
    val costPerLaunch: String,
    val rocketID: String,
    val flickrImages: FlickrImagesModel,
    val wikipediaURL: String,
    val landingLegs: LandingLegsModel,
    val active: String
)