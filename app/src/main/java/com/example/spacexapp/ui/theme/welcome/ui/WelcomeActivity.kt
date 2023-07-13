package com.example.spacexapp.ui.theme.welcome.ui

import android.os.Bundle
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
import androidx.navigation.compose.rememberNavController
import com.example.spacexapp.R
import com.example.spacexapp.ui.theme.DataProvider
import com.example.spacexapp.ui.theme.SingleItemCell
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToSpaceXHistory
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
                        state = state,
                        onItemClicked = viewModel::onItemCellClicked,
                        onHistoryClicked = { navigateToSpaceXHistory() }
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
    onHistoryClicked: () -> Unit
) {
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
                            color = Color.Black,
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
                        ListOfItems(items = item, onClick = onItemClicked)
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
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        modifier = Modifier
                            .size(48.dp)
                            .clickable {
                            },
                        painter = painterResource(id = R.drawable.baseline_home_24),
                        contentDescription = null,
                        tint = Color.Black
                    )
                    Icon(
                        modifier = Modifier
                            .size(48.dp)
                            .clickable {
                            },
                        painter = painterResource(id = R.drawable.baseline_home_24),
                        contentDescription = null,
                        tint = Color.Black
                    )
                    Icon(
                        modifier = Modifier
                            .size(48.dp)
                            .clickable {
                            },
                        painter = painterResource(id = R.drawable.baseline_home_24),
                        contentDescription = null,
                        tint = Color.Black
                    )
                    Icon(
                        modifier = Modifier
                            .size(48.dp)
                            .clickable {
                                onHistoryClicked.invoke()
                            },
                        painter = painterResource(id = R.drawable.baseline_history_24),
                        contentDescription = null,
                        tint = Color.Black
                    )
                    Icon(
                        modifier = Modifier
                            .size(48.dp)
                            .clickable { },
                        painter = painterResource(id = R.drawable.baseline_info_24),
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }
        }
    }
}

/*@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Icon(modifier =
        Modifier
            .size(48.dp)
            .clickable {
            },
        painter = painterResource(id = R.drawable.baseline_search_24),
            contentDescription = null
        ) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .background(Color.Transparent)
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(corner = CornerSize(16.dp))
            )
    )
}*/

@Composable
fun ListOfItems(
    items: SingleItemCell,
    onClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.Black,
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
        val navController = rememberNavController()
        //WelcomeCard()
        NewWelcomeActivity(
            onItemClicked = {},
            state = WelcomeViewState(
                cellList = DataProvider.clickableItemsList,
                navigationBottomCellList = DataProvider.navigationItems
            ),
            onHistoryClicked = {}
        )
    }
}

/*@Composable
    fun BottomNavigation(navController: NavController) {
        val items = listOf(
            BottomNavItem.History,
            BottomNavItem.Home,
            BottomNavItem.Info
        )
        BottomNavigation(
            backgroundColor = colorResource(id = R.color.white),
            contentColor = Color.Black
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontSize = 9.sp
                        )
                    },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Black.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = currentRoute == item.screen_route,
                    onClick = {
                        Log.e("KKK", "${item.screen_route}")
                    }
                )
            }
        }
    }*/