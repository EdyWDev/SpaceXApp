package com.example.spacexapp.ui.theme.rocket

import android.util.Log
import android.view.View
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
class RocketViewModel @Inject constructor(
    private val spaceXRepository: SpaceXRepository
): ViewModel() {
    private val _viewState = MutableStateFlow(value = RocketViewState())
    val viewState = _viewState.asStateFlow()

    init{
        loadRocketModel()
    }
    private fun loadRocketModel(){
        viewModelScope.launch {
            try{
                val rocketResponse = spaceXRepository.getRocket()
                _viewState.update {
                    it.copy(rocketList = rocketResponse)
                }
            } catch(e: Exception){
                Log.e("EEEE", "BLAD Z ROCKET, ${e.message}")
            }
        }
    }
}