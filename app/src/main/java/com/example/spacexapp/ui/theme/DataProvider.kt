package com.example.spacexapp.ui.theme

data class SingleItemCell(
    val id: Int,
    val name: String
)

data class LaunchesItemCell(
    val id: Int,
    val name: String
)

object DataProvider {
    val navigationItems = listOf(
        LaunchesItemCell(name = "LAND PADS", id = 1),
        LaunchesItemCell(name = "LAUNCHPADS", id = 2),
        LaunchesItemCell(name = "INFO", id = 3),

        )
    val clickableItemsList = listOf(
        SingleItemCell(
            id = 1,
            name = "FEATURED MISSION"
        ),
        SingleItemCell(
            id = 2,
            name = "UPCOMING LAUNCHES"
        ),
       /* SingleItemCell(
            id = 2,
            name = "LAUNCH PADS"
        ),
        SingleItemCell(
            id = 3,
            name = "LANDING PADS"
        ),*/

       /* SingleItemCell(
            id = 5,
            name = "PAYLOADS"
        ),*/
        /*SingleItemCell(
            id = 6,
            name = "VEHICLESS"
        ),*/
      /*  SingleItemCell(
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
        ),*/
      /*  SingleItemCell(
            id = 11,
            name = "CORES"
        )*/
    )
}

