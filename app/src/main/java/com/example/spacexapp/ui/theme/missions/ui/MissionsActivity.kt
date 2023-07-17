package com.example.spacexapp.ui.theme.missions.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.missions.MissionsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MissionsActivity : ComponentActivity() {
    private val viewModel: MissionsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXAppTheme {
                MissionTrucker()
            }
        }
    }
}

@Composable
fun MissionTrucker() {
    Scaffold(
        topBar = {
            TopAppBar(
                 backgroundColor = Color.White,
                title = {
                    Text(
                        text = "Mission Trucker",
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    ) {

    }
}

@Preview
@Composable
fun DefaultPreview() {
    MissionTrucker()
}