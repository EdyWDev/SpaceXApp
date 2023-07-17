package com.example.spacexapp.ui.theme.history

import com.example.spacexapp.ui.theme.history.model.SpaceXHistory

data class HistoryViewState(
    val historyList: List<SpaceXHistory> = emptyList()
)