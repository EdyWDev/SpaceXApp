package com.example.spacexapp.ui.theme.rocket.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.SavedStateHandle
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.rocket.RocketViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketActivity:ComponentActivity() {
    private val viewMode: RocketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            SpaceXAppTheme() {

            }
        }
    }
}