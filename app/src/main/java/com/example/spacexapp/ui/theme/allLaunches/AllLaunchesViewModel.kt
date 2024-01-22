package com.example.spacexapp.ui.theme.allLaunches

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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


    private val _launchSuccessLiveData = MutableLiveData<String>()
    val launchSuccessLiveData: LiveData<String> = _launchSuccessLiveData

    // do przechowywania inf wyswietlanyych w UI
    private val _displayTextLiveData = MutableLiveData<String>()

    // live data z textem tylko do odczytu
    val displayTextLiveData: LiveData<String>
    get() = _displayTextLiveData

    // metoda do ustawienia wartosci launchSuccessLiveData
    fun setLaunchSuccessText(success: String){
        _launchSuccessLiveData.value = success

        // ustawienie inf jaka ma sie wyswietlic w UI
        _displayTextLiveData.value = if(success == "true"){
            "Yes"
        } else {
            "No"
        }
    }

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
                Log.e("EEE", "BŁĄD Z ALL LAUNCHES  ${e.message}" )
            }
        }
    }
}