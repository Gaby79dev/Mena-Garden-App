package com.garden.menagarden

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.garden.menagarden.ui.contact.ContactScreen
import com.garden.menagarden.ui.landing.LandingScreen
import com.garden.menagarden.ui.landing.OurHistoryScreen
import com.garden.menagarden.ui.menu.MenuTabs
import com.garden.menagarden.ui.theme.MenaGardenTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MenaGardenTheme {
                MenaGardenNavHost()
            }
        }
    }
}

@Composable
fun MenaGardenNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "landing") {
        composable("landing") {
            LandingScreen(navController = navController)
        }
        composable("history") {
            OurHistoryScreen(navController = navController)
        }
        composable("contact") {
            ContactScreen(navController = navController)
        }
        composable(
            route = "menu?selectedTab={selectedTab}",
            arguments = listOf(navArgument("selectedTab") {
                type = NavType.StringType
                nullable = true
            })
        ) { backStackEntry ->
            val selectedTab = backStackEntry.arguments?.getString("selectedTab")
            MenuTabs(selectedTab = selectedTab)
        }
    }
}
