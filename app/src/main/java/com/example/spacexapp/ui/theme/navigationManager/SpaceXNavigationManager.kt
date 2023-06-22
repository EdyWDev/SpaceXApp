package com.example.spacexapp.ui.theme.navigationManager

import android.app.Activity
import android.content.Intent
import com.example.spacexapp.ui.theme.history.HistoryActivity

object SpaceXNavigationManager {

    fun Activity.navigateToSPaceXHistory(){
        Intent(this, HistoryActivity::class.java).apply {
            startActivity(this)
        }
    }
}