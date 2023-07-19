package com.example.spacexapp.ui.theme.missions.model

import com.google.gson.annotations.SerializedName

class MissionsDTO(
    @SerializedName("mission_name")
    val name: String?,
    @SerializedName("mission_id")
    val id: String?,
    val wikipedia: String?,
    val website: String?,
    val description: String?
)