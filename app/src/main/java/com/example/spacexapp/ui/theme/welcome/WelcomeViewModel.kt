
package com.example.spacexapp.ui.theme.welcome

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexapp.ui.theme.di.Capsule
import com.example.spacexapp.ui.theme.di.Rocket
import com.example.spacexapp.ui.theme.service.SpaceXService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WelcomeViewModel @Inject constructor(
   // private val savedStateHandle: SavedStateHandle,
  //  private val spaceXService: SpaceXService
): ViewModel() {

    private val _viewState = MutableStateFlow<WelcomeViewState>(value = WelcomeViewState())
    val viewState = _viewState.asStateFlow()


    fun onItemCellClicked(id: Int) {
        Log.e("EEE","Id from Item: $id")
        val matchedItem = _viewState.value.cellList.firstOrNull{
            it.id == id
        }
        Log.e("EEE","Clicked Item Name ${matchedItem?.name}")
    }

  //  private val _capsules = MutableStateFlow<List<Capsule>>(emptyList())
   // val capsules = _capsules.asStateFlow()

  //  private val _rockets = MutableStateFlow<List<Rocket>>(emptyList())
//    val rockets = _rockets.asStateFlow()

 /*   fun loadCapsules(){
        viewModelScope.launch {
            val capsules = spaceXService.getCapsules()
            _capsules.value = capsules
        }
    }
    fun loadRockets(){
        viewModelScope.launch {
            val rockets = SpaceXService.getRockets()
            _rockets.value = rockets
        }
    }*/

}
