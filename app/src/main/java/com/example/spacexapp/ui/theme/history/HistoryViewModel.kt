package com.example.spacexapp.ui.theme.history

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexapp.ui.theme.service.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val historyRepository: HistoryRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow(value = HistoryViewState())
    val viewState = _viewState.asStateFlow()

    init {
        loadHistory()
    }

    private fun loadHistory() {
        viewModelScope.launch {
            try {
                val historyResponse = historyRepository.getSpaceXHistory()
                _viewState.update {
                    it.copy(historyList = historyResponse)
                }
            } catch (e: Exception) {
                Log.e("EEE", "COS TU NIE GRA, ${e.message}")
            }
        }
    }
}

