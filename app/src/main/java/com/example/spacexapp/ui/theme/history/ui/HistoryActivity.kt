package com.example.spacexapp.ui.theme.history.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.history.HistoryViewModel
import com.example.spacexapp.ui.theme.history.HistoryViewState
import com.example.spacexapp.ui.theme.history.model.SpaceXHistory
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
                    color = MaterialTheme.colors.background
                ) {
                    HistoryItemScreen(
                        state = state
                    )
                }
            }
        }

    }
}

@Composable
fun HistoryItemScreen(
    state: HistoryViewState,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.DarkGray,
                title = {
                    Text(
                        text = "History Details:",
                        color = Color.White,
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
                .verticalScroll(rememberScrollState()),
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
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 0.dp,
                color = Color.White,
                shape = RoundedCornerShape(corner = CornerSize(8.dp))
            )
            .padding(8.dp),
        elevation = 4.dp,
        backgroundColor = Color.Transparent,
        shape = RoundedCornerShape(corner = CornerSize(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            items.title?.let { title ->
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                    text = title,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
            }
            items.eventData?.let { evenData ->
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                    text = evenData,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )

            }
            items.details?.let { details ->
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                    text = "Details: $details",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            items.links.article?.let { article ->
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp),
                    text = article,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            items.links.wikipedia?.let { wikipedia ->
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp),
                    text = wikipedia,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            items.links.reddit?.let { reddit ->
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp),
                    text = reddit,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    SpaceXAppTheme {
        HistoryItemScreen(
            state = HistoryViewState(),
        )
    }
}
