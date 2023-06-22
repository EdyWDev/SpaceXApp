
package com.example.spacexapp.ui.theme.welcome

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
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

}
