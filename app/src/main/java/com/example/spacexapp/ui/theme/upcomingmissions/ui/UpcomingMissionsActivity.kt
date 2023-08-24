package com.example.spacexapp.ui.theme.upcomingmissions.ui

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToWelcomeActivity
import com.example.spacexapp.ui.theme.upcomingmissions.UpcomingMissionsViewModel
import com.example.spacexapp.ui.theme.upcomingmissions.UpcomingMissionsViewState
import com.example.spacexapp.ui.theme.upcomingmissions.model.UpcomingMissionsModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UpcomingMissionsActivity : ComponentActivity() {
    private val viewModel: UpcomingMissionsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXAppTheme {
                val state by viewModel.viewState.collectAsState()
                Surface {
                    UpcomingMissions(
                        state = state,
                        onClicked = { navigateToWelcomeActivity() }
                    )
                }
            }
        }
    }
}

@Composable
fun UpcomingMissions(
    state: UpcomingMissionsViewState,
    onClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                title = {
                    Text(
                        text = "Upcoming Missions:",
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                    )
                },
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = { onClicked.invoke() }) {
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
                .background(color = Color.Black)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            state.upcomingMissionsList.forEach { item ->
                ListOfUpcomingMissionsItem(items = item)

            }
        }

    }
}

@Composable
fun ListOfUpcomingMissionsItem(
    items: UpcomingMissionsModel
) {
    val handler = LocalUriHandler.current
    Card(
        modifier = Modifier
            // .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .border(
                width = 0.dp,
                color = Color.White,
                shape = RoundedCornerShape(corner = CornerSize(8.dp))
            ),
        elevation = 4.dp,
        backgroundColor = Color.Black,
        shape = RoundedCornerShape(corner = CornerSize(8.dp))
    ) {
        Column {
            Row(
                modifier = Modifier
                    //  .padding(horizontal = 16.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items.missionName?.let { missionName ->
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                        text = "Mission name: $missionName",
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic
                    )
                }
                items.flightNumber?.let { flightNumber ->
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 16.dp),
                        text = "Flight number: $flightNumber",
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
            items.launchDateLocal?.let { launchDateLocal ->
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                    text = launchDateLocal,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )
            }
            items.details?.let { details ->
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                    text = details,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )

            }
            Row(
                modifier = Modifier
                    //    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items.rocketInUpcoming.rocketName?.let { rocketName ->
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                        text = "Rocket name: $rocketName",
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic
                    )
                }
                items.rocketInUpcoming.rocketId?.let { rocketID ->
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                        text = "ID: $rocketID",
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
            Row(
                modifier = Modifier
                    //    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                items.launchSite.siteName?.let { siteName ->
                    Text(
                        modifier = Modifier.padding(16.dp, 16.dp),
                        text = "Launch site: $siteName",
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic
                    )
                }
                items.launchSite.siteId?.let { siteID ->
                    Text(
                        modifier = Modifier.padding(16.dp, 16.dp),
                        text = "ID: $siteID",
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
            items.launchSite.siteNameLong?.let { siteNameLong ->
                Text(
                    modifier = Modifier.padding(16.dp, 16.dp),
                    text = siteNameLong,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )
            }
            ButtonForURL()
        }
    }
}

@Composable
fun ButtonForURL(){
    Button(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 16.dp)
        .fillMaxWidth()
        .background(color = Color.Black)
        .border(
            width = 1.dp,
            color = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(8.dp))
        ),
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ){
        Text(
            text = "Mission Patch",
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic,
            color = Color.White
        )
    }
    Button(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 16.dp)
        .fillMaxWidth()
        .background(color = Color.Black)
        .border(
            width = 1.dp,
            color = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(8.dp))
        ),
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ){
        Text(
            text = "Reedit Campaign",
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpaceXAppTheme {

        UpcomingMissions(
            state = UpcomingMissionsViewState(),
            onClicked = {}
        )
    }
}
