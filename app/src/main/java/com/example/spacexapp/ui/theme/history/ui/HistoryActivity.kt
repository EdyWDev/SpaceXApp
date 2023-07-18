package com.example.spacexapp.ui.theme.history.ui

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.history.HistoryViewModel
import com.example.spacexapp.ui.theme.history.HistoryViewState
import com.example.spacexapp.ui.theme.history.model.SpaceXHistory
import com.example.spacexapp.ui.theme.navigationManager.SpaceXNavigationManager.navigateToWelcomeActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HistoryActivity : ComponentActivity() {
    private val viewModel: HistoryViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXAppTheme {
                val state by viewModel.viewState.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //       color = MaterialTheme.colors.primary
                ) {
                    HistoryItemScreen(
                        state = state,
                        onClicked = { navigateToWelcomeActivity() }
                    )
                }
            }
        }

    }
}

@Composable
fun HistoryItemScreen(
    state: HistoryViewState,
    onClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                title = {
                    Text(
                        text = "History details:",
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                    )
                },
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = { onClicked.invoke() }) {
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
        )
        {
            state.historyList.forEach { item ->
                ListOfHistoryItems(items = item)
            }
        }
    }


}


@Composable
fun ListOfHistoryItems(items: SpaceXHistory) {
    val handler = LocalUriHandler.current
    Card(
        modifier = Modifier
            //  .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .border(
                width = 0.dp,
                color = Color.White,
                shape = RoundedCornerShape(corner = CornerSize(8.dp))
            )
            .padding(horizontal = 4.dp, vertical = 4.dp),
        elevation = 4.dp,
        backgroundColor = Color.Transparent,
        shape = RoundedCornerShape(corner = CornerSize(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)

        ) {
            items.title?.let { title ->
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    text = title,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic,
                )
            }
            items.eventData?.let { evenData ->
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    text = evenData,
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic,
                )

            }
            items.details?.let { details ->
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    text = "Details: $details",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic,
                )
            }
            Button(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .background(Color.Black)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(corner = CornerSize(16.dp))
                    ),
                onClick = {
                    items.links.article?.let { handler.openUri(it) }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(
                    text = "Article",
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )
            }
            Button(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .background(Color.Black)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(corner = CornerSize(16.dp))
                    ),
                onClick = {
                    items.links.wikipedia?.let { handler.openUri(it) }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)

            ) {
                Text(
                    text = "Wikipedia",
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )
            }
            Button(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .background(Color.Black)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(corner = CornerSize(16.dp))
                    ),
                onClick = {
                    items.links.reddit?.let { handler.openUri(it) }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)

            ) {
                Text(
                    text = "Reddit",
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

        SpaceXAppTheme {
            HistoryItemScreen(
                state = HistoryViewState(),
                onClicked = {}
            )
        }
    }

