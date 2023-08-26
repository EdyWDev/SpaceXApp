package com.example.spacexapp.ui.theme.rocket.model

import com.google.gson.annotations.SerializedName
import java.net.URL

data class FlickrImagesDTO (
    @SerializedName("0")
    val flickrImages0: String,
    @SerializedName("1")
    val flickrImages1: String
        )