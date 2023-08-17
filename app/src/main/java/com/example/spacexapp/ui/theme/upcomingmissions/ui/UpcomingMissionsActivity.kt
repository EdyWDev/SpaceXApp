package com.example.spacexapp.ui.theme.upcomingmissions.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.theme.upcomingmissions.UpcomingMissionsViewModel
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
                    UpcomingMissions()
                }
            }
        }
    }
}

@Composable
fun UpcomingMissions() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding()
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
            Text(
                text = "Missions name",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 90.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraLight

            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpaceXAppTheme {

        UpcomingMissions()
    }
}