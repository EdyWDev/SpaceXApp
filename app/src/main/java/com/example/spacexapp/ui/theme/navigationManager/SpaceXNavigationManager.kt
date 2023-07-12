package com.example.spacexapp.ui.theme.navigationManager

import android.app.Activity
import android.content.Intent
import com.example.spacexapp.ui.theme.di.history.ui.HistoryActivity

object SpaceXNavigationManager {

    fun Activity.navigateToSpaceXHistory() {
        Intent(this, HistoryActivity::class.java).apply {
            startActivity(this@apply)
        }
    }
}