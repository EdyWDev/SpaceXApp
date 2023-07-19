package com.example.spacexapp.ui.theme.rocket.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToWelcomeActivity
import com.example.spacexapp.ui.theme.rocket.RocketViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketActivity:ComponentActivity() {
    private val viewModel: RocketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            SpaceXAppTheme {

                RocketItemScreen(
                    onClicked = {navigateToWelcomeActivity()}
                )
            }
        }
    }
}

@Composable
fun RocketItemScreen(
    onClicked: () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                title = {
                    Text(
                        text = "Rockets:",
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                    )
                },
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = {onClicked.invoke()}) {
                        Icon(Icons.Filled.ArrowBack, null)

                    }
                }
                //  colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Yellow)

            )
        }
    ) { innerPadding ->
        Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues = innerPadding)
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState())
            .background(color = Color.Black),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ){}
    }
}

@Composable
fun ListOfRockets(){

}

@Preview
@Composable
fun DefaultPreview(){
   SpaceXAppTheme {
       RocketItemScreen {
       }
   }
}