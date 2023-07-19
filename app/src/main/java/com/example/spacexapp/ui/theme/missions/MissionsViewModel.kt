package com.example.spacexapp.ui.theme.missions

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
class MissionsViewModel @Inject constructor(
    private val missionRepository: SpaceXRepository
): ViewModel() {

    private val _viewState = MutableStateFlow(value = MissionsViewState())
    val viewState = _viewState.asStateFlow()

    init {
        loadMissionsDetails()
    }
    private fun loadMissionsDetails(){
        viewModelScope.launch {
            try{
               val missionResponse =  missionRepository.getMissionsDetails()
                _viewState.update {
                    it.copy(missionsList = missionResponse)
                }
            } catch(e: Exception){
                Log.e("EEE", "OBY DZIALALO, ${e.message}")
            }
        }
    }
}