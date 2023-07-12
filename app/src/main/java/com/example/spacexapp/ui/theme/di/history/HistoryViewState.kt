package com.example.spacexapp.ui.theme.di.history

import com.example.spacexapp.ui.theme.di.history.model.SpaceXHistory

data class HistoryViewState(
    val historyList: List<SpaceXHistory> = emptyList()
)