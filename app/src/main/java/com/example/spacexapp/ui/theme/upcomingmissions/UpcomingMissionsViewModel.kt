package com.example.spacexapp.ui.theme.upcomingmissions

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexapp.ui.theme.service.SpaceXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UpcomingMissionsViewModel @Inject constructor(
    private val spaceXRepository: SpaceXRepository
): ViewModel() {

    private val _viewState = MutableStateFlow(value = UpcomingMissionsViewState())
    val viewState = _viewState.asStateFlow()

    init {
        loadUpcomingMission()
    }
    private fun loadUpcomingMission(){
        viewModelScope.launch {
            try{
                val upcomingMissionsResponse = spaceXRepository.getUpcomingMissions()
                _viewState.update {
                    it.copy(upcomingMissionsList = upcomingMissionsResponse)
                }
            } catch (e: Exception){
                Log.e("EEE", "BLAD Z UPCOMING MISSIONS, ${e.message}")
            }
        }
    }
}