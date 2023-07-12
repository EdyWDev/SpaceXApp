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
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {

        // To powinien byc toolbar albo topAppBar chyba po nowemu
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray)
                .padding(horizontal = 16.dp, vertical = 16.dp),
            text = "Szczególy historii",
            color = Color.Black,
            fontSize = 18.sp,
        )

        state.historyList.forEach { item ->
            ListOfHistoryItems(items = item)
        }
    }
}

@Composable
fun ListOfHistoryItems(items: SpaceXHistory) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.White,
            ),
        elevation = 4.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(8.dp))
    ) {
        items.title?.let { title ->
            Text(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                text = title,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
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
