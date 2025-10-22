package com.garden.menagarden

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.garden.menagarden.ui.landing.LandingScreen
import com.garden.menagarden.ui.menu.MenuScreen
import com.garden.menagarden.ui.theme.MenaGardenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MenaGardenTheme {
                MenaGardenApp()
            }
        }
    }
}

@Composable
fun MenaGardenApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "landing") {
        composable("landing") {
            LandingScreen(navController = navController)
        }
        composable("menu") {
            MenuScreen()
        }
    }
}
