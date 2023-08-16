package com.example.spacexapp.ui.theme.upcomingmissions

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class UpcomingMissionsViewModel @Inject constructor(): ViewModel() {

    private val _viewState = MutableStateFlow(value = UpcomingMissionsViewState())
    val viewState = _viewState.asStateFlow()

}