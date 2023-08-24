package com.example.spacexapp.ui.theme.welcome.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacexapp.R
import com.example.spacexapp.ui.theme.DataProvider
import com.example.spacexapp.ui.theme.SingleItemCell
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToAllLaunches
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToCompanyInfo
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToMission
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToRocket
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToSpaceXHistory
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToUpcomingMission
import com.example.spacexapp.ui.theme.welcome.WelcomeViewModel
import com.example.spacexapp.ui.theme.welcome.WelcomeViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeActivity : ComponentActivity() {
    private val viewModel: WelcomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXAppTheme {
                val state by viewModel.viewState.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NewWelcomeActivity(
                        //viewModel = viewModel,
                        state = state,
                        onItemClicked = viewModel::onItemCellClicked,
                        onHistoryClicked = { navigateToSpaceXHistory() },
                        onCompanyInfoClicked = { navigateToCompanyInfo() },
                        onMissionClicked = { navigateToMission() },
                        onRocketClicked = { navigateToRocket() },
                        onUpcomingMissions = { navigateToUpcomingMission() },
                        onAllLaunches = {navigateToAllLaunches()}

                    )
                }
            }
        }
    }
}


@Composable
fun NewWelcomeActivity(
    state: WelcomeViewState,
    onItemClicked: (Int) -> Unit,
    onHistoryClicked: () -> Unit,
    onCompanyInfoClicked: () -> Unit,
    onMissionClicked: () -> Unit,
    onRocketClicked: () -> Unit,
    onUpcomingMissions: () -> Unit,
    onAllLaunches: () -> Unit

) {
    // val viewState: WelcomeViewState by viewModel.viewState.collectAsState(WelcomeViewState())
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    Text(
                        text = "Rocket Tracker",
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = innerPadding)
        )
        {
            val context = LocalContext.current
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .paint(
                        painterResource(id = R.drawable.cosmos),
                        contentScale = ContentScale.FillHeight
                    )

            ) {
                // SearchBar()
                Card(
                    modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 4.dp)
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(corner = CornerSize(16.dp))
                        ),
                    elevation = 2.dp,
                    backgroundColor = Color.Transparent,
                    shape = RoundedCornerShape(corner = CornerSize(16.dp))
                ) {
                    Text(
                        text = "Welcome to Rocket Tracker",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 90.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.ExtraLight
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .weight(1F)
                ) {

                    state.cellList.forEach { item ->
                        ListOfItems(items = item) {
                            if (item.id == 2){
                                onUpcomingMissions.invoke()
                            }else if(item.id == 1){
                                onAllLaunches.invoke()
                            } else{
                                Log.e("EEEE", "onClick from ${item.id}")
                            }

                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.white_transparent))
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        ),
                    //.height(80.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = onRocketClicked,
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    ) {
                        Column {
                            Icon(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clickable {
                                        onRocketClicked.invoke()
                                    },
                                painter = painterResource(id = R.drawable.rocket),
                                contentDescription = "Rocket",
                                tint = Color.Black,
                            )
                            Spacer(modifier = Modifier.size(0.dp))
                            Text(
                                text = "Rocket",
                                color = Color.Black
                            )
                        }
                    }
                    Button(
                        onClick = onMissionClicked,
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    ) {
                        Column {
                            Icon(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clickable {
                                        onMissionClicked.invoke()
                                    },
                                painter = painterResource(id = R.drawable.mission),
                                contentDescription = "Missions",
                                tint = Color.Black,
                            )
                            Spacer(modifier = Modifier.size(0.dp))
                            Text(
                                text = "Mission",
                                color = Color.Black
                            )
                        }
                    }
                    Button(
                        onClick = onHistoryClicked,
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    ) {
                        Column {
                            Icon(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clickable {
                                        onHistoryClicked.invoke()
                                    },
                                painter = painterResource(id = R.drawable.baseline_history_24),
                                contentDescription = "History",
                                tint = Color.Black,
                            )
                            Spacer(modifier = Modifier.size(0.dp))
                            Text(
                                text = "History",
                                color = Color.Black
                            )
                        }
                    }
                    Button(
                        onClick = onHistoryClicked,
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                    ) {
                        Column {
                            Icon(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clickable {
                                        onCompanyInfoClicked.invoke()
                                    },
                                painter = painterResource(id = R.drawable.baseline_info_24),
                                contentDescription = null,
                                tint = Color.Black
                            )
                            Spacer(modifier = Modifier.size(0.dp))
                            Text(
                                text = "Info",
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun OnButtonClick(
    viewModel: WelcomeViewModel
) {
    val newState = WelcomeViewState(shouldOpenNewActivity = true)
    viewModel.updateViewState(newState)
}

@Composable
fun ListOfItems(
    items: SingleItemCell,
    //  itemLaunches: SingleItemCell,
    onClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(corner = CornerSize(16.dp))
            ),
        elevation = 2.dp,
        backgroundColor = Color.Transparent,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clickable {
                    onClick.invoke(items.id)
                    /*if (items.id == 2) {
                        onUpcomingMissions.invoke()
                    } else {
                        Log.e("EEEE", "onClick from ${items.id}")
                    }*/

                }

        ) {
            Text(
                text = items.name,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    SpaceXAppTheme {
        NewWelcomeActivity(
            // viewModel = viewModel(),
            onItemClicked = {},
            state = WelcomeViewState(
                cellList = DataProvider.clickableItemsList,
                //    navigationBottomCellList = DataProvider.navigationItems
            ),
            onHistoryClicked = {},
            onCompanyInfoClicked = {},
            onRocketClicked = {},
            onMissionClicked = {},
            onUpcomingMissions = {},
            onAllLaunches = {}
        )
    }
}

