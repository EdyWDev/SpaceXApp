package com.example.spacexapp.ui.theme.companyinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
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
import com.example.spacexapp.ui.theme.companyinfo.ui.OneItemCell
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToWelcomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompanyInfoActivity : ComponentActivity() {

    private val viewModel: CompanyInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXAppTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Black
                ) {

                }
                val state by viewModel.viewState.collectAsState()
                InfoView(state = state,
                onClicked = {navigateToWelcomeActivity()})
            }
        }

    }
}

@Composable
fun InfoView(
    state: CompanyInfoViewState,
    onClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                title = {
                    Text(
                        text = "About company:",
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
                //  colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Yellow)

            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
                .background(color = Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SPACE X",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 86.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.ExtraLight
            )
            state.listOfItems.forEach { item ->
                ListOfItems(items = item)
            }
            ButtonURL()
        }

    }
}

@Composable
fun ListOfItems(
    items: OneItemCell
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .fillMaxWidth(),
    ) {

        Text(
            text = items.name,
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.ExtraLight
        )
    }
}

@Composable
fun ButtonURL(
    // onWebsiteButtonClicked: ()-> Unit
) {
    val handler = LocalUriHandler.current
    Button(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 16.dp)
        .fillMaxWidth()
        .background(color = Color.Black)
        .border(
            width = 1.dp,
            color = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ),
        onClick = {
            handler.openUri("https://www.spacex.com/")
        },
    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black))
    {
        Text(
            text = "Website",
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
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ),
        onClick = {
            handler.openUri("https://www.flickr.com/photos/spacex/")
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    )
    {
        Text(
            text = "Flickr",
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic,
            color = Color.White
        )
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
            handler.openUri("https://twitter.com/SpaceX")
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
    ) {
        Text(
            text = "Twitter",
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic,
            color = Color.White
        )
    }
}


@Preview
@Composable
fun DefaultPreview() {
    InfoView(
        state = CompanyInfoViewState(),
        onClicked = {}
    )
}