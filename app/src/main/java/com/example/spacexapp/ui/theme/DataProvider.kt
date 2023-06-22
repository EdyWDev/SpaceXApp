package com.example.spacexapp.ui.theme

data class SingleItemCell(
    val id: Int,
    val name: String
)

data class NavigationBottomCell(
    val id: Int,
    val name: String
)

object DataProvider {
    val navigationItems = listOf(
        NavigationBottomCell(name = "HOME", id = 1),
        NavigationBottomCell(name = "HISTORY", id = 2),
        NavigationBottomCell(name = "INFO", id = 3),
        NavigationBottomCell(name = "ABOUT", id = 4),

        )
    val clickableItemsList = listOf(
        SingleItemCell(
            id = 1,
            name = "LAUNCHES"
        ),
        SingleItemCell(
            id = 2,
            name = "LAUNCH PADS"
        ),
        SingleItemCell(
            id = 3,
            name = "LANDING PADS"
        ),
        SingleItemCell(
            id = 4,
            name = "MISSIONS"
        ),
        SingleItemCell(
            id = 5,
            name = "PAYLOADS"
        ),
        SingleItemCell(
            id = 6,
            name = "ROCKETS"
        ),
        SingleItemCell(
            id = 7,
            name = "ROADSTER"
        ),
        SingleItemCell(
            id = 8,
            name = "SHIPS"
        ),
        SingleItemCell(
            id = 9,
            name = "CAPSULES"
        ),
        SingleItemCell(
            id = 10,
            name = "DRAGONS"
        ),
        SingleItemCell(
            id = 11,
            name = "CORES"
        )
    )
}

