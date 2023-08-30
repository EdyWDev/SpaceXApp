package com.example.spacexapp.ui.theme.rocket.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.spacexapp.R
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToWelcomeActivity
import com.example.spacexapp.ui.theme.rocket.RocketViewModel
import com.example.spacexapp.ui.theme.rocket.RocketViewState
import com.example.spacexapp.ui.theme.rocket.model.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketActivity : ComponentActivity() {
    private val viewModel: RocketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXAppTheme {
                val state by viewModel.viewState.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    RocketItemScreen(
                        state = state,
                        onClicked = { navigateToWelcomeActivity() }
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
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                title = {
                    Text(
                        text = stringResource(R.string.Rockets_Catalog),
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
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = innerPadding)
                .padding(horizontal = 8.dp, vertical = 8.dp)
                //.verticalScroll(rememberScrollState())
                .background(color = Color.Black),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(items = state.rocketList) { model ->
                ListOfRockets(item = model)
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ListOfRockets(
    item: RocketModel
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .border(
                width = 0.dp,
                color = Color.White,
                shape = RoundedCornerShape(corner = CornerSize(8.dp))
            ),
        elevation = 4.dp,
        backgroundColor = Color.Transparent,
        shape = RoundedCornerShape(corner = CornerSize(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                text = "Rocket: ${item.rocketName}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
            Row {
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                    text = "Rocket Type: ${item.rocketType}",
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                    text = "Rocket ID: ${item.rocketID}",
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )
            }
            AsyncImage(
                      model = ImageRequest.Builder(LocalContext.current)
                          .data(item.flickrImages[0])
                          .build(),
                      contentDescription = "This is an example image",
                      modifier = Modifier.fillMaxWidth()
                          .padding(horizontal = 16.dp, vertical = 16.dp),
                              contentScale = ContentScale.Crop
                  )
                  AsyncImage(
                      model = ImageRequest.Builder(LocalContext.current)
                          .data(item.flickrImages[1])
                          .build(),
                      contentDescription = "This is an example image",
                      modifier = Modifier.fillMaxWidth()
                          .padding(horizontal = 16.dp, vertical = 16.dp),
                      contentScale = ContentScale.Crop
                  )
            Text(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                text = item.description,
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
            Row {
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                    text = "Height: ${item.height.meters} meters",
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                    text = "Mass: ${item.mass.kg} kg",
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )
            }
            Text(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                text = "Diameter: ${item.height.feet} meters",
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )

            Text(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                text = "First flight: ${item.firstFlight}",
                color = Color.White,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Light
            )
            Text(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                text = "Country: ${item.country}",
                color = Color.White,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Light
            )
            Text(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                text = "Cost per Launch: ${item.costPerLaunch}",
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
            Text(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                text = item.wikipediaURL,
                color = Color.White,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Light
            )
            Row {
                item.landingLegs.materialLandingLegs?.let { materialLandingLegs ->
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                        text = "Material Landing Legs: $materialLandingLegs",
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic
                    )
                    item.landingLegs.numberLandingLegs?.let { numberLandingLegs ->
                        Text(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                            text = "Quantity: $numberLandingLegs",
                            color = Color.White,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Light
                        )
                    }
                }
            }

        }
    }

}


@Preview
@Composable
fun DefaultPreview() {
    SpaceXAppTheme {
        RocketItemScreen(
            state = RocketViewState(
                rocketList = listOf(
                    RocketModel(
                        rocketName = "Example 1",
                        description = "Description 1",
                        height = RocketHeightModel(
                            feet = "50",
                            meters = "10"
                        ),
                        mass = RocketMassModel(
                            kg = "1000",
                            lb = "2000"
                        ),
                        firstFlight = "2006-03-24",
                        company = "SpaceX",
                        country = "Republic of the Marshall Islands",
                        rocketType = "rocket",
                        rocketID = "falcon1",
                        costPerLaunch = "6700000$",
                        landingLegs = LandingLegsModel(
                            materialLandingLegs = "null",
                            numberLandingLegs = "0"
                        ),
                        wikipediaURL = "https://en.wikipedia.org/wiki/Falcon_1",
                        active = "true",
                        flickrImages = listOf(
                            "https://farm4.staticflickr.com/3955/32915197674_eee74d81bb_b.jpg",
                            "https://farm1.staticflickr.com/293/32312415025_6841e30bf1_b.jpg"
                        )
                    ),
                    RocketModel(
                        rocketName = "Example 2",
                        description = "Description 2",
                        height = RocketHeightModel(
                            feet = "40",
                            meters = "80"
                        ),
                        mass = RocketMassModel(
                            kg = "800",
                            lb = "1600"
                        ),
                        firstFlight = "2006-03-24",
                        company = "SpaceX",
                        country = "Republic of the Marshall Islands",
                        rocketType = "rocket",
                        rocketID = "falcon1",
                        costPerLaunch = "6700000$",
                        landingLegs = LandingLegsModel(
                            materialLandingLegs = "null",
                            numberLandingLegs = "0"
                        ),
                        wikipediaURL = "https://en.wikipedia.org/wiki/Falcon_1",
                        active = "true",
                        flickrImages = listOf(
                            "https://farm4.staticflickr.com/3955/32915197674_eee74d81bb_b.jpg",
                            "https://farm1.staticflickr.com/293/32312415025_6841e30bf1_b.jpg"
                        )
                    ),
                    RocketModel(
                        rocketName = "Example 2",
                        description = "Description 2",
                        height = RocketHeightModel(
                            feet = "40",
                            meters = "80"
                        ),
                        mass = RocketMassModel(
                            kg = "800",
                            lb = "1600"
                        ),
                        firstFlight = "2006-03-24",
                        company = "SpaceX",
                        country = "Republic of the Marshall Islands",
                        rocketType = "rocket",
                        rocketID = "falcon1",
                        costPerLaunch = "6700000$",
                        landingLegs = LandingLegsModel(
                            materialLandingLegs = "null",
                            numberLandingLegs = "0"
                        ),
                        wikipediaURL = "https://en.wikipedia.org/wiki/Falcon_1",
                        active = "true",
                        flickrImages = listOf(
                            "https://farm4.staticflickr.com/3955/32915197674_eee74d81bb_b.jpg",
                            "https://farm1.staticflickr.com/293/32312415025_6841e30bf1_b.jpg"
                        )
                    ),
                    RocketModel(
                        rocketName = "Example 2",
                        description = "Description 2",
                        height = RocketHeightModel(
                            feet = "40",
                            meters = "80"
                        ),
                        mass = RocketMassModel(
                            kg = "800",
                            lb = "1600"
                        ),
                        firstFlight = "2006-03-24",
                        company = "SpaceX",
                        country = "Republic of the Marshall Islands",
                        rocketType = "rocket",
                        rocketID = "falcon1",
                        costPerLaunch = "6700000$",
                        landingLegs = LandingLegsModel(
                            materialLandingLegs = "null",
                            numberLandingLegs = "0"
                        ),
                        wikipediaURL = "https://en.wikipedia.org/wiki/Falcon_1",
                        active = "true",
                        flickrImages = listOf(
                            "https://farm4.staticflickr.com/3955/32915197674_eee74d81bb_b.jpg",
                            "https://farm1.staticflickr.com/293/32312415025_6841e30bf1_b.jpg"
                        )
                    ),

                    )
            ),
            onClicked = {}
        )
    }
}

