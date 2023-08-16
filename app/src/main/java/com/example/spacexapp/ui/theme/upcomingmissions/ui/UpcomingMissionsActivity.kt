package com.example.spacexapp.ui.theme.upcomingmissions.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.os.IResultReceiver.Default
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.upcomingmissions.UpcomingMissionsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UpcomingMissionsActivity: ComponentActivity() {
    private val viewModel: UpcomingMissionsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            SpaceXAppTheme {
                val state by viewModel.viewState.collectAsState()
                Surface(){}
            }
        }
    }
}

@Composable
fun UpcomingMissions(){

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    SpaceXAppTheme {
        
    }
}