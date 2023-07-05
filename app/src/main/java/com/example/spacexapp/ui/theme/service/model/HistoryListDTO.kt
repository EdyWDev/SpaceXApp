package com.example.spacexapp.ui.theme.service.model

import com.google.gson.annotations.SerializedName

data class HistoryListDTO(
    @SerializedName("historyDetails")
    val historyDetails: List<HistoryDTO>?
)