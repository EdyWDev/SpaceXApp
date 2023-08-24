package com.example.spacexapp.ui.theme.allLaunches.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.allLaunches.AllLaunchesViewModel
import com.example.spacexapp.ui.theme.allLaunches.AllLaunchesViewState
import com.example.spacexapp.ui.theme.allLaunches.model.AllLaunchesModel
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToWelcomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllLaunchesActivity : ComponentActivity() {
    private val viewModel: AllLaunchesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXAppTheme {
                val state by viewModel.viewState.collectAsState()
                Surface {

                    AllLaunchesUI(
                        state = state,
                        onClicked = { navigateToWelcomeActivity() }
                    )
                }

            }
        }
    }
}

@Composable
fun AllLaunchesUI(
    state: AllLaunchesViewState,
    onClicked: () -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Text(
                    text = "All Launches",
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            backgroundColor = Color.White,
            navigationIcon = {
                IconButton(onClick = { onClicked.invoke() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null, tint = Color.Black)
                }
            }

        )
    }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = innerPadding)
                .background(color = Color.Black)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            state.allLaunchesList.forEach { item ->
                ListOfAllLaunchesElement(items = item)
            }

        }

    }
}

@Composable
fun ListOfAllLaunchesElement(
    items: AllLaunchesModel
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .border(
                width = 0.dp,
                color = Color.White,
                shape = RoundedCornerShape(corner = CornerSize(8.dp))
            ),
        elevation = 4.dp,
        backgroundColor = Color.Black,
        shape = RoundedCornerShape(corner = CornerSize(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp

                )
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                text = "Mission: ${items.missionName}",
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                text = items.launchDateLocal,
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpaceXAppTheme {
        AllLaunchesUI(
            state = AllLaunchesViewState(),
            onClicked = {}
        )
    }
}
