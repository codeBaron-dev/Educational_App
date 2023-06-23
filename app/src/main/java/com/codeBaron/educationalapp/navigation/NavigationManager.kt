package com.codeBaron.educationalapp.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.codeBaron.educationalapp.MainActivity
import com.codeBaron.educationalapp.R
import com.codeBaron.educationalapp.screens.AuthenticationScreen
import com.codeBaron.educationalapp.screens.HomeScreen
import com.codeBaron.educationalapp.ui.theme.Purple40

@Composable
fun NavigationManager(
    mainActivity: MainActivity
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        route = Graphs.ROOT_GRAPH.name,
        startDestination = Destinations.AUTH_SCREEN.name
    ) {
        composable(Destinations.AUTH_SCREEN.name) {
            AuthenticationScreen(navigationController = navController)
        }
        composable(Destinations.HOME_SCREEN.name) {
            HomeScreen()
        }
    }
}

@Composable
fun BottomNav() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationItem("home", "Home", painterResource(R.drawable.baseline_home_24)),
        BottomNavigationItem("my_course", "My Course", painterResource(R.drawable.outline_play_circle_outline_24)),
        BottomNavigationItem("blog", "Blog", painterResource(R.drawable.outline_menu_book_24)),
        BottomNavigationItem("profile", "Profile", painterResource(R.drawable.outline_account_circle_24))
    )
    val selectedItem = items[0]

    BottomNavigation(
        modifier = Modifier.height(56.dp),
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = item.label
                    )
                },
                label = { Text(item.label) },
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                },
                unselectedContentColor = Purple40,
                selectedContentColor = Purple40
            )
        }
    }
}