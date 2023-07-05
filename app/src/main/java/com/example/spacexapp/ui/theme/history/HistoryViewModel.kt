package com.example.spacexapp.ui.theme.history

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexapp.ui.theme.history.model.SpaceXHistory
import com.example.spacexapp.ui.theme.service.HistoryRepository
import com.example.spacexapp.ui.theme.service.SpaceXService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HistoryViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val historyRepository: HistoryRepository,
    private val spaceXService: SpaceXService
) : ViewModel() {

    private val _viewState = MutableStateFlow(value= HistoryViewState())
    val viewState = _viewState.asStateFlow()

    private val _history = MutableStateFlow<List<SpaceXHistory>>(emptyList())
    val history = _history.asStateFlow()


    fun loadHistory(){
        viewModelScope.launch {
            val historyResponse = historyRepository.getSpaceXHistory()
           // _history.value = history
         //   historyResponse.

        }
    }
}

