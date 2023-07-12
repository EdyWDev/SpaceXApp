package com.example.spacexapp.ui.theme.history.model

data class SpaceXHistory(
    var id: String?,
    var title: String?,
    var eventData: String?,
    var flightNumber: String?,
    var details: String?,
    var links: LinksModel
)