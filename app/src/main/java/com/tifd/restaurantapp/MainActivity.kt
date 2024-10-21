package com.tifd.restaurantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import com.tifd.restaurantapp.ui.theme.RestaurantsAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantsAppTheme {
                RestaurantsApp()            }
        }
    }
}
@Composable
private fun RestaurantsApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "restaurants") {
        composable(route = "restaurants") {
            RestaurantsScreen { id ->
                navController.navigate("restaurants/$id")
            }
        }
        composable(
            route = "restaurants/{restaurant_id}",
            arguments = listOf(navArgument("restaurant_id") {
                type = NavType.IntType
            }),
            deepLinks = listOf(navDeepLink { uriPattern =
                "www.restaurantsapp.details.com/{restaurant_id}" }),
        ) { RestaurantDetailsScreen() }
    }
}
