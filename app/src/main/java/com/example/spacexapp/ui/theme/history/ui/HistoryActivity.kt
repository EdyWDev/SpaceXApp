package com.example.spacexapp.ui.theme.history.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.Magenta
    ) {
        Text(
            modifier = Modifier
                .border(1.dp, Color.Transparent)
                .padding(horizontal = 15.dp, vertical = 26.dp),
            text = " ",
            color = Color.White,
            fontSize = 35.sp,

            )

    }
    state.historyList.forEach { item ->
        ListOfHistoryItems(items = item)
    }
}

@Composable
fun ListOfHistoryItems(items: SpaceXHistory) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(corner = CornerSize(16.dp))
            ),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            items.title?.let { title ->
                Text(
                    text = title,
                    color = Color.Black,
                    fontSize = 8.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }


        }

    }
}

/*@Composable
fun ListOfHistoryItems(
    historyItems: SpaceXHistory,
    //historyRepository: HistoryRepository
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .fillMaxWidth()
            .border(1.dp, Color.White),
        elevation = 2.dp,
        backgroundColor = Color.Transparent,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        LaunchedEffect(Unit){
            val result = withContext(Dispatchers.IO){
     //           apiResultState.loadHistory()
            }

        }
         Column(
            modifier = Modifier
                .padding(16.dp)

        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                historyItems.title?.let {
                    Text(
                        text = it,
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                }
                historyItems.eventData?.let {
                    Text(
                        text = it,
                        color = Color.Black,
                        fontSize = 20.sp

                    )
                }
            }
             historyItems.details?.let {
                 Text(
                     text = it,
                     color = Color.Black,
                     fontSize = 20.sp
                 )
             }
             historyItems.links1?.let {
                 Text(
                     text = it,
                     color = Color.Black,
                     fontSize = 20.sp
                 )
             }
             historyItems.links2?.let {
                 Text(
                     text = it,
                     color = Color.Black,
                     fontSize = 20.sp

                 )
             }
             historyItems.links3?.let {
                 Text(
                     text = it,
                     color = Color.Black,
                     fontSize = 20.sp

                 )
             }
        }

    }
    }*/


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    SpaceXAppTheme {
        HistoryItemScreen(
            state = HistoryViewState(),
        )
    }
}
