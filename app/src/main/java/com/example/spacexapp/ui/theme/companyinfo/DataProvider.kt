package com.example.spacexapp.ui.theme.companyinfo.ui

data class OneItemCell(
    val name: String
)

object DataProvider {
    val elementsOfList = listOf(
       /* OneItemCell(
            name = "NAME: SpaceX"
        ),*/
        OneItemCell(
            name =
            "SpaceX designs, manufactures and launches advanced rockets and spacecraft. " +
                    "The company was founded in 2002 to revolutionize space technology, with the ultimate goal of enabling people to live on other planets."
        ),
        OneItemCell(
            name = "FOUNDED: 2002"
        ),
        OneItemCell(
            name = "CEO: Elon Musk"
        ),

      /*  OneItemCell(
            name = "EMPLOYEES: 7000"
        ),
        OneItemCell(
            name = "VEHICLES: 3"
        ),
        OneItemCell(
            name = "LAUNCH SITES: 3"
        ),
        OneItemCell(
            name = "CEO: Elon Musk"
        ),
        OneItemCell(
            name = "CTO: Elon Musk"
        ),
        OneItemCell(
            name = "COO: Gwynne Shotwell"
        ),
        OneItemCell(
            name = "CTO PROPULSION: Tom Mueller"
        ),
        OneItemCell(
            name = "VALUATION: 27500000000"
        ),
        OneItemCell(
            name = "STATE: California, Hawthorne"
        ),
        OneItemCell(
            name = "WEBSITE: https://www.spacex.com/"
        ),
        OneItemCell(
            name = "FLICKR: https://www.flickr.com/photos/spacex/"
        ),
        OneItemCell(
            name = "TWITTER: https://twitter.com/SpaceX"
        ),
        OneItemCell(
            name = "ELON TWITTER: https://twitter.com/elonmusk"
        ),*/

    )
}