package com.example.spacexapp.ui.theme.companyinfo

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CompanyInfoViewModel @Inject constructor(): ViewModel() {

    private val _viewState = MutableStateFlow(value = CompanyInfoViewState())
    val viewState = _viewState.asStateFlow()
}