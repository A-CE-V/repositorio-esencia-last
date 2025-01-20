package com.example.proyectoesencia.NavigationClasses

import AppLogoIntro
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoesencia.Screens.FirstScreen.AppManagerMainScreenButton
import com.example.proyectoesencia.Screens.mainScreen.AppManagerPP
import com.example.proyectoesencia.Screens.SettingsScreen.SettingsScreen

@Composable
fun StartNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RutasSealed.IntroScreen.ruta
    ) {
        composable(RutasSealed.FirstScreen.ruta) {
            AppManagerMainScreenButton(navController)
        }
        composable(RutasSealed.MainScreen.ruta) {
            AppManagerPP(navController)
        }
        composable(RutasSealed.IntroScreen.ruta) {
            AppLogoIntro(navController)
        }
        composable(RutasSealed.SettingsScreen.ruta) {
            SettingsScreen(onBack = { navController.popBackStack() })
        }
    }
}