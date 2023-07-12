package com.example.spacexapp.ui.theme.service.model

import com.google.gson.annotations.SerializedName

class HistoryDTO (
    val id: String,
    val title: String,
    @SerializedName("event_date_utc")
    val eventData: String,
    val flightNumber: String,
    val details: String,
    val links: LinksDTO,
)