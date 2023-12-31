package com.example.spacexapp.ui.theme

data class SingleItemCell(
    val id: Int,
    val name: String
)
object DataProvider {
    val clickableItemsList = listOf(
        SingleItemCell(
            id = 1,
            name = "ALL LAUNCHES"
        ),
        SingleItemCell(
            id = 2,
            name = "UPCOMING LAUNCHES"
        )
    )
}

