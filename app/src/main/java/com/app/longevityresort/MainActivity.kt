package com.app.longevityresort

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.longevityresort.features.home.HomeScreen
import com.app.longevityresort.features.home.HomeViewModel
import com.app.longevityresort.features.locations.LocationsScreen
import com.app.longevityresort.features.more.MoreScreen
import com.app.longevityresort.features.services.RoadmapScreen
import com.app.longevityresort.ui.theme.LongevityResortTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    @ExperimentalFoundationApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LongevityResortTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = { HomeBottomBar(navController) }) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Navigation(navController = navController, viewModel = viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeBottomBar(navController: NavController) {
    val items = listOf(
        NavigationItems.Home,
        NavigationItems.Roadmap,
        NavigationItems.Locations,
        NavigationItems.More,
    )
    BottomNavigation(
        backgroundColor = Color(0xFF2196F3), contentColor = Color.White
    )
    {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun Navigation(navController: NavHostController, viewModel: HomeViewModel) {
    NavHost(navController, startDestination = NavigationItems.Home.route) {
        composable(NavigationItems.Home.route) {
            HomeScreen(viewModel = viewModel)
        }
        composable(NavigationItems.Roadmap.route) {
            RoadmapScreen()
        }
        composable(NavigationItems.Locations.route) {
            LocationsScreen(viewModel = viewModel)
        }
        composable(NavigationItems.More.route) {
            MoreScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LongevityResortTheme {
//        HomeBottomBar(null)
    }
}