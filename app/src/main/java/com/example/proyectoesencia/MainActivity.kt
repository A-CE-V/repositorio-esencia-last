package com.example.proyectoesencia

import AppLogoIntro
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.ProyectoESENCIATheme
import com.example.proyectoesencia.Screens.AppManagerMainScreenButton
import com.example.proyectoesencia.Screens.AppManagerPP
import com.example.proyectoesencia.Screens.SettingsScreen

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoESENCIATheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "intro"
                ) {
                    composable("button") {
                        AppManagerMainScreenButton(navController)
                    }
                    composable("main") {
                        AppManagerPP(navController)
                    }
                    composable("intro") {
                        AppLogoIntro(navController)
                    }
                    composable("settings") {
                        SettingsScreen(onBack = { navController.popBackStack() })
                    }
                }
            }
        }
    }
}
