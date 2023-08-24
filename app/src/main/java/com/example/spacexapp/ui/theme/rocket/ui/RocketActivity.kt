package com.example.spacexapp.ui.theme.rocket.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToWelcomeActivity
import com.example.spacexapp.ui.theme.rocket.RocketViewModel
import com.example.spacexapp.ui.theme.rocket.RocketViewState
import com.example.spacexapp.ui.theme.rocket.model.RocketModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketActivity:ComponentActivity() {
    private val viewModel: RocketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            SpaceXAppTheme {
                val state by viewModel.viewState.collectAsState()
                Surface(
                   // modifier = Modifier.fillMaxWidth()
                     //   .background(color = Color.Blue),
                color = Color.Black

                ){
                    RocketItemScreen(
                        state = state,
                        onClicked = {navigateToWelcomeActivity()}
                    )
                }
            }
        }
    }
}

@Composable
fun RocketItemScreen(
    state: RocketViewState,
    onClicked: () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                title = {
                    Text(
                        text = "Rockets Catalog:",
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                    )
                },
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = {onClicked.invoke()}) {
                        Icon(Icons.Filled.ArrowBack, null, tint = Color.Black)

                    }
                }
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
    ){
            state.rocketList.forEach {item->
                ListOfRockets(items = item)
            }
        }
    }
}

@Composable
fun ListOfRockets(
    items: RocketModel
){
    Card(
        modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 8.dp)
        .border(
            width = 0.dp,
            color = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(8.dp))
        ),
        elevation = 4.dp,
        backgroundColor = Color.Transparent,
        shape = RoundedCornerShape(corner = CornerSize(8.dp))
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black)
        ){
            Text(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                text ="Rocket: ${ items.rocketName }",
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                text =  "Height: ${items.height.meters} meters" ,
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                text =  "Diameter: ${items.height.feet} meters" ,
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                text = items.description,
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
        }
    }

}

@Preview
@Composable
fun DefaultPreview(){
   SpaceXAppTheme {

       RocketItemScreen(
           state = RocketViewState(),
           onClicked = {}
       )
   }
}