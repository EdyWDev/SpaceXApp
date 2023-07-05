package com.example.spacexapp.ui.theme.history.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.history.HistoryViewModel
import com.example.spacexapp.ui.theme.history.HistoryViewState
import com.example.spacexapp.ui.theme.history.model.SpaceXHistory
import com.example.spacexapp.ui.theme.service.HistoryRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@AndroidEntryPoint
class HistoryActivity : ComponentActivity() {
    private val viewModel: HistoryViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXAppTheme {
                // A surface container using the 'background' color from the theme
                //  val state by viewModel.viewState.collectAsState()
                Surface(
                    //val history = viewModel.history.collectAsState()
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HistoryItemScreen()
                }
            }
        }
    }
}

@Composable
fun HistoryItemScreen() {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        backgroundColor = Color.Blue,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .border(1.dp, Color.Transparent)
                .padding(horizontal = 15.dp, vertical = 26.dp),
            //   .align(Alignment.BottomEnd),
            text = "HISTORY",
            color = Color.White,
            fontSize = 35.sp,

            )

    }
    ListOfHistoryItems(historyItems = SpaceXHistory())
}

@Composable
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
        backgroundColor = Color.White,
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
            // .clickable { onClick.invoke() }
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
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {

        SpaceXAppTheme {
            HistoryItemScreen()
        }
    }
