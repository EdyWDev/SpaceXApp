package com.example.spacexapp.ui.theme.navigationManager

import android.app.Activity
import android.content.Intent
import android.net.Uri
import com.example.spacexapp.ui.theme.companyinfo.CompanyInfoActivity
import com.example.spacexapp.ui.theme.history.ui.HistoryActivity
import com.example.spacexapp.ui.theme.missions.ui.MissionsActivity
import com.example.spacexapp.ui.theme.rocket.ui.RocketActivity
import com.example.spacexapp.ui.theme.welcome.ui.WelcomeActivity

object SpaceXNavigationManager {

    fun Activity.navigateToSpaceXHistory() {
        Intent(this, HistoryActivity::class.java).apply {
            startActivity(this@apply)
        }
    }

    fun Activity.navigateToCompanyInfo(){
        Intent(this, CompanyInfoActivity::class.java).apply {
            startActivity(this@apply)
        }
    }
    fun Activity.navigateToMission(){
        Intent(this, MissionsActivity::class.java).apply {
            startActivity(this@apply)
        }
    }
    fun Activity.navigateToRocket(){
        Intent(this, RocketActivity::class.java).apply {
            startActivity(this@apply)
        }
    }

    fun Activity.navigateToWelcomeActivity() {
        Intent(this, WelcomeActivity::class.java).apply {
            startActivity(this@apply)
        }
    }
}