package com.example.spacexapp.ui.theme.allLaunches

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
class AllLaunchesViewModel @Inject constructor(
    private val spaceXRepository: SpaceXRepository
): ViewModel() {

    private val _viewState = MutableStateFlow(value = AllLaunchesViewState())
    val viewState = _viewState.asStateFlow()

    init{
        loadAllLaunches()
    }
    private fun loadAllLaunches(){
        viewModelScope.launch {
            try{
                val allLaunchesResponse = spaceXRepository.getAllLaunches()
                _viewState.update {
                    it.copy(allLaunchesList = allLaunchesResponse)
                }
            } catch(e: Exception){
                Log.e("EEE", "BŁĄD Z ALL LAUNCHES")
            }
        }
    }
}