package com.example.spacexapp.ui.theme.history

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HistoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXAppTheme {
                // A surface container using the 'background' color from the theme
                //   val state by viewModel.viewState.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HistoryScreen(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun HistoryScreen(modifier: Modifier) {
    modifier
        .fillMaxWidth()
        .background(Color.White)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    SpaceXAppTheme {
        HistoryScreen(modifier = Modifier)
    }
}