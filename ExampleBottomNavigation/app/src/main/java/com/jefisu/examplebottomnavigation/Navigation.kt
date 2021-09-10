package com.jefisu.examplebottomnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jefisu.examplebottomnavigation.SampleData.LIST_NAV_ITEM
import com.jefisu.examplebottomnavigation.SampleData.ROUTE_INITIAL_SCREEN
import com.jefisu.examplebottomnavigation.SampleData.ROUTE_SECOND_SCREEN
import com.jefisu.examplebottomnavigation.SampleData.ROUTE_THIRD_SCREEN

@ExperimentalMaterialApi
@Composable
fun ShowScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = LIST_NAV_ITEM,
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        },
        content = {
            Navigation(navController = navController)
        }
    )
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ROUTE_INITIAL_SCREEN
    ) {
        composable(route = ROUTE_INITIAL_SCREEN, content = { InitialScreen() })
        composable(route = ROUTE_SECOND_SCREEN, content = { SecondScreen() })
        composable(route = ROUTE_THIRD_SCREEN, content = { ThirdScreen() })
    }
}

@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if(item.badgeCount > 0) {
                            BadgeBox(
                                badgeContent = {
                                    Text(text = item.badgeCount.toString())
                                }
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name
                            )
                        }
                        if(selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }
}