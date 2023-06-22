package com.example.spacexapp.ui.theme.welcome

import com.example.spacexapp.ui.theme.DataProvider
import com.example.spacexapp.ui.theme.NavigationBottomCell
import com.example.spacexapp.ui.theme.SingleItemCell

class WelcomeViewState(
    val cellList : List<SingleItemCell> = DataProvider.clickableItemsList,
    val navigationBottomCellList : List<NavigationBottomCell> = DataProvider.navigationItems,
)