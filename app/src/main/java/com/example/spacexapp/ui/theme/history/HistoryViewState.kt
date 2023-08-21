package com.example.spacexapp.ui.theme.history

import com.example.spacexapp.ui.theme.history.model.HistoryModel

data class HistoryViewState(
    val historyList: List<HistoryModel> = emptyList()
)