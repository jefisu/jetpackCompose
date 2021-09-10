package com.jefisu.examplebottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person

object SampleData {

    const val ROUTE_INITIAL_SCREEN = "initialScreen"
    const val ROUTE_SECOND_SCREEN = "secondScreen"
    const val ROUTE_THIRD_SCREEN = "thirdScreen"

    val LIST_NAV_ITEM = listOf(
        BottomNavItem(
            name = "Initial",
            route = ROUTE_INITIAL_SCREEN,
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            name = "Second",
            route = ROUTE_SECOND_SCREEN,
            icon = Icons.Default.Person,
            badgeCount = 23
        ),
        BottomNavItem(
            name = "Third",
            route = ROUTE_THIRD_SCREEN,
            icon = Icons.Default.AccountCircle,
            badgeCount = 9
        )
    )
}