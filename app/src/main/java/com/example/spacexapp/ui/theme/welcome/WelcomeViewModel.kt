package com.example.spacexapp.ui.theme.welcome

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacexapp.ui.theme.DataProvider
import com.example.spacexapp.ui.theme.SingleItemCell
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class WelcomeViewModel @Inject constructor(
) : ViewModel() {

    private val _viewState = MutableStateFlow(value = WelcomeViewState())
    val viewState = _viewState.asStateFlow()


    private val _viewStateLiveData = MutableLiveData<WelcomeViewState>()
    val viewStateLiveData: LiveData<WelcomeViewState> = _viewStateLiveData

    fun updateViewState(newState: WelcomeViewState){
        _viewStateLiveData.value = newState
    }
    fun onItemCellClicked(id: Int) {
        Log.e("EEE", "Id from Item: $id")
        val matchedItem = _viewState.value.cellList.firstOrNull {
            it.id == id
        }
        Log.e("EEE", "Clicked Item Name ${matchedItem?.name}")
    }

}
