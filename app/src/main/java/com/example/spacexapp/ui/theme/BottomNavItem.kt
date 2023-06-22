package com.example.spacexapp.ui.theme

import com.example.spacexapp.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Home : BottomNavItem("HOME", R.drawable.baseline_home_24, "home")
    object History : BottomNavItem("HISTORY", R.drawable.baseline_history_24, "history")
    object Info : BottomNavItem("INFO", R.drawable.baseline_info_24, "info")
/*
    object Home: BottomNavItem("HOME",*/
/* androidx.core.R.drawable.notification_bg*//*
, "home")
*/

}