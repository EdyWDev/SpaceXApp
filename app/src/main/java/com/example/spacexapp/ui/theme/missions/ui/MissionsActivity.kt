package com.example.spacexapp.ui.theme.missions.ui

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
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.missions.MissionsViewModel
import com.example.spacexapp.ui.theme.missions.MissionsViewState
import com.example.spacexapp.ui.theme.missions.model.SpaceXMissions
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToWelcomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MissionsActivity : ComponentActivity() {
    private val viewModel: MissionsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXAppTheme {
                val state by viewModel.viewState.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MissionTrucker(
                        state = state,
                        onClicked = { navigateToWelcomeActivity() }
                    )
                }
            }
        }
    }
}

@Composable
fun MissionTrucker(
    state: MissionsViewState,
    onClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    Text(
                        text = "Mission Trucker:",
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        //  textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onClicked.invoke() }) {
                        Icon(Icons.Filled.ArrowBack, null)

                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = innerPadding)
                .verticalScroll(rememberScrollState())
                .background(color = Color.Black)
        ) {
            state.missionsList.forEach { item ->
                ListOfMissions(items = item)
            }

        }

    }
}

@Composable
fun ListOfMissions(items: SpaceXMissions) {
    val handler = LocalUriHandler.current
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(corner = CornerSize(16.dp))
            ),
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),

            ) {
            Row {

                items.name?.let { name ->
                    Text(
                        text = name,
                        color = Color.White,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.weight(1F))
                items.id?.let { id ->
                    Text(
                        text = id,
                        color = Color.White,
                        textAlign = TextAlign.End,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold
                    )

                }


            }
            Button(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .fillMaxWidth()
                    .background(color = Color.Black)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(corner = CornerSize(16.dp))
                    ),
                onClick = {
                    items.wikipedia?.let { it ->
                        handler.openUri(it)
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(
                    text = "Wkikipedia",
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic,
                    color = Color.White
                )
            }

            Button(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .background(color = Color.Black)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(corner = CornerSize(16.dp))
                    ),
                onClick = {
                    items.website?.let { it ->
                        handler.openUri(it)
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(
                    text = "Website",
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic,
                    color = Color.White
                )
            }
            items.description?.let { description ->
                Text(
                    text = description,
                    color = Color.White,
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )

            }

        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    MissionTrucker(
        onClicked = {},
        state = MissionsViewState()
    )
}